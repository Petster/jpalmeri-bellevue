# WhatABook Project
# Jason Palmeri
# 2/03/2022

import mysql.connector
from mysql.connector import errorcode
import os

config = {
    "user": "whatabook_user",
    "password": "MySQL8IsGreat!",
    "host": "127.0.0.1",
    "port": "3333",
    "database": "whatabook",
    "raise_on_warnings": True
}

def show_menu():
    print("Welcome to WhatABook's Online Tool!\n")
    print("-What would you like to do?-")
    print("1. View Books")
    print("2. View Store Locations")
    print("3. My Account")
    print("4. Exit")
    while True:
        try:
            choice = int(input('Select a Function '))
        except ValueError:
            print("That's Not a Number! Try Again")
        else:
            if 1 <= choice <= 4:
                return choice
                break
            else:
                print("That Is not a Valid Option!")

def show_books(db_cursor):
    db_cursor.execute("SELECT * FROM book")

    books = db_cursor.fetchall()

    print("\n-Displaying Books-\n")

    for book in books:
        print("Book #{}\nBook Name: {}\nAuthor: {}\nDetails: {}".format(book[0], book[1], book[3], book[2]))
        print("----")

def show_locations(db_cursor):
    db_cursor.execute("SELECT * FROM store")

    stores = db_cursor.fetchall()

    print("\n-Displaying Locations-\n")

    for store in stores:
        print("Store #{}\nStore Location: {}\n".format(store[0], store[1]))
        print("----")

def validate_user():
    while True:
        try:
            userInputID = int(input("Enter Customer ID: "))
        except ValueError:
            print("That's Not a Number! Try Again")
        else:
            if 1 <= userInputID <= 3:
                return userInputID
                break
            else:
                print("That Is not a Valid Option!")

def show_account_menu():
    print("-What would you like to do?-")
    print("1. Wishlist")
    print("2. Add Book")
    print("3. Main Menu")
    while True:
        try:
            choice = int(input('Select a Function '))
        except ValueError:
            print("That's Not a Number! Try Again")
        else:
            if 1 <= choice <= 3:
                return choice
                break
            else:
                print("That Is not a Valid Option!")

def show_wishlist(db_cursor, user_id):
    db_cursor.execute("SELECT user.user_id, user.first_name, user.last_name, book.book_id, book.book_name, book.author FROM wishlist INNER JOIN user on wishlist.user_id = user.user_id INNER JOIN book ON wishlist.book_id = book.book_id WHERE user.user_id = {}".format(user_id))

    wishlist = db_cursor.fetchall()

    print("-Displaying User {}'s Wishlist-".format(user_id))

    for book in wishlist:
        print("Book Name: {}\nAuthor: {}".format(book[4], book[5]))
        print("----")

def show_books_to_add(db_cursor, user_id):
    db_cursor.execute("SELECT * FROM book WHERE book_id NOT IN (SELECT book_id FROM wishlist WHERE user_id = {})".format(user_id))

    books = db_cursor.fetchall()

    print("-Displaying Available Books-")
    
    for book in books:
        print("Book ID: {}\nBook Name: {}".format(book[0], book[1]))
        print("----")

def add_book_to_wishlist(db_cursor, user_id, book_id):
    db_cursor.execute("INSERT INTO wishlist(user_id, book_id) VALUES({}, {})".format(user_id, book_id))

try:
    db = mysql.connector.connect(**config)
    print("\nDatabase User {} connected to MySQL on host {} with database {}\n\n".format(config["user"], config["host"], config["database"]))

    #db cursor
    cursor = db.cursor()

    #get user input
    userInput = show_menu()

    while userInput != 4:

        #view books
        if userInput == 1:
            os.system('cls')
            show_books(cursor)
        
        #view stores
        if userInput == 2:
            os.system('cls')
            show_locations(cursor)
        
        #my account
        if userInput == 3:
            os.system('cls')
            #validate user id
            inputUserID = validate_user()
            userAccountInput = show_account_menu()

            while userAccountInput != 3:
                #show wishlist
                if userAccountInput == 1:
                    os.system('cls')
                    show_wishlist(cursor, inputUserID)
                
                #show available books to add
                if userAccountInput == 2:
                    os.system('cls')
                    show_books_to_add(cursor, inputUserID)
                    userBookInput = int(input("\nEnter the ID of the book you would like to add: "))
                    add_book_to_wishlist(cursor, inputUserID, userBookInput)
                    db.commit()

                    print("\nBook #{} was added to user {}'s wishlist!".format(userBookInput, inputUserID))

                #main menu
                if userAccountInput == 3:
                    os.system('cls')
                    break

                userAccountInput = show_account_menu()

        #exit
        if userInput == 4:
            os.system('cls')
            print("Exiting Program...")
            exit
        
        userInput = show_menu()
except mysql.connector.Error as err:
    if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
        print("The Supploed username or password are invalid")
    elif err.errno == errorcode.ER_BAD_DB_ERROR:
        print("The specified database does not exist")
    else:
        print(err)
finally:
    db.close()