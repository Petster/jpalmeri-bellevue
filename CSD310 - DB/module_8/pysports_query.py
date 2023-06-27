# pytech_query
# Jason Palmeri
# 1/27/2022

import mysql.connector
from mysql.connector import errorcode

config = {
    "user": "pysports_user",
    "password": "MySQL8IsGreat!",
    "host": "127.0.0.1",
    "port": "3333",
    "database": "pysports",
    "raise_on_warnings": True
}


try:
    db = mysql.connector.connect(**config)
    print("\n Database User {} connected to MySQL on host {} with database {}\n\n".format(config["user"], config["host"], config["database"]))
    
    cursor = db.cursor()

    cursor.execute("SELECT * FROM team")

    teams = cursor.fetchall()

    print("-Printing Team Names-")
    for team in teams:
        print("Team ID: {}\nTeam Name: {}\nMascot: {}".format(team[0], team[1], team[2]))
        print(" ")
    
    cursor.execute("SELECT * FROM player")

    players = cursor.fetchall()
    
    print("-Printing Players-")
    for player in players:
        print("Player ID: {}\nPlayer First Name: {}\nPlayer Last Name: {}\nTeam ID: {}".format(player[0], player[1], player[2], player[3]))
        print("")

    input("\n\n Press any key to continue...")
except mysql.connector.Error as err:
    if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
        print("The Supploed username or password are invalid")
    elif err.errno == errorcode.ER_BAD_DB_ERROR:
        print("The specified database does not exist")
    else:
        print(err)
finally:
    db.close()