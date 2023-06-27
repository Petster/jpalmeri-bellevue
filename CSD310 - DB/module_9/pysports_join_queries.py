# pysports_join_queries
# Jason Palmeri
# 1/29/2022

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

    cursor.execute("SELECT player_id, first_name, last_name, team_name FROM player INNER JOIN team ON player.team_id = team.team_id")

    players = cursor.fetchall()

    print("-Player Info-\n")

    for player in players:
        print("  Player ID: {}\n  First Name: {}\n  Last Name: {}\n  Team Name: {}\n".format(player[0], player[1], player[2], player[3]))


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