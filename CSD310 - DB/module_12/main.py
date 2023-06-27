import tkinter as Tk
from tkinter import ttk
from tkinter import font
import mysql.connector
from mysql.connector import errorcode

config = {
    "user": "whatabook_user",
    "password": "MySQL8IsGreat!",
    "host": "127.0.0.1",
    "port": "3333",
    "database": "whatabook",
    "raise_on_warnings": True
}

def doQuery(query):
    try:
        db = mysql.connector.connect(**config)
        #print("\nDatabase User {} connected to MySQL on host {} with database {}\n\n".format(config["user"], config["host"], config["database"]))

        #db cursor
        cursor = db.cursor()
        cursor.execute(query)

        result = cursor.fetchall()

        return result

    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print("The Supploed username or password are invalid")
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("The specified database does not exist")
        else:
            print(err)
    finally:
        db.close()

def changePage(min, max, frame, nextFrame):
    global pageMin
    global pageMax
    pageMin = min
    pageMax = max
    if(frame != "none"):
        if(nextFrame != "none"):
            if(nextFrame == "book"):
                viewBooks(frame)
            elif(nextFrame == "wishlist"):
                viewWishlist(frame)
            elif(nextFrame == "booktoadd"):
                showBooksToAdd(frame)

def clearWindow(frame):
    for widget in frame.winfo_children():
        widget.destroy()

def createMenuFrame(frame):
    if(frame != "none"):
        clearWindow(frame)
        frame.grid()
    changePage(0, 5, "none", "none")
    root.title("WhatABook Online")
    header = Tk.Label(frame, text="WhatABook Online\n--------------", font=buttonFont).grid(row=0, column=3, columnspan=5)
    labelOne = Tk.Button(frame, text="View Books", font=buttonFont, command= lambda: viewBooks(frame), width=17).grid(row=1, column=3, columnspan=5, pady=10)
    labelTwo = Tk.Button(frame, text="View Store Locations", font=buttonFont, command= lambda: viewLocations(frame), width=17).grid(row=2, column=3, columnspan=5, pady=10)
    labelThree = Tk.Button(frame, text="My Account", bg='blue', fg='white', font=buttonFont, command= lambda: accountCheck(frame), width=17).grid(row=3, column=3, columnspan=5, pady=10)
    labelFour = Tk.Button(frame, text="Exit", font=buttonFont, bg='red', fg='white', command=root.destroy, width=17).grid(row=4, column=3, columnspan=5, pady=10)
    return frame

def viewBooks(frame):
    clearWindow(frame)
    root.title("WhatABook Inventory")
    header = Tk.Label(frame, text="WhatABook's Inventory\n--------------", font=buttonFont).grid(row=0, column=3, columnspan=5)
    books = doQuery("SELECT * FROM book")

    bookList = []

    for book in books:
        bookList.append("Book #{} | {} By: {}".format(book[0], book[1], book[3]))

    curRow = 1
    iterator = bookList[pageMin:pageMax]
    for item in iterator:
        Tk.Label(frame, text=item, wraplength=500, font=buttonFont).grid(row=curRow, column=3, columnspan=5)
        curRow += 1

    if(len(bookList) > 5):
        nextPage = Tk.Button(frame, text="Next", font=buttonFont, bg='green', fg='white', command= lambda: changePage(5, 9, frame, "book")).grid(row=curRow+1, column=5, columnspan=5)
    
    backPage = Tk.Button(frame, text="Back", font=buttonFont, bg='blue', fg='white', command= lambda: changePage(0, 5, frame, "book")).grid(row=curRow+1, column=1, columnspan=5)
    backButton = Tk.Button(frame, text="Menu", font=buttonFont, bg='red', fg='white', command= lambda: createMenuFrame(frame)).grid(row=curRow+1, column=3, columnspan=5)

def viewLocations(frame):
    clearWindow(frame)
    root.title("WhatABook Locations")
    header = Tk.Label(frame, text="WhatABook Locations\n--------------", font=buttonFont).grid(row=0, column=3, columnspan=5)

    stores = doQuery("SELECT * FROM store")

    curRow = 1
    for store in stores:
        Tk.Label(frame, text="Store #{}".format(store[0]), font=buttonFont).grid(row=curRow, column=3, columnspan=5)
        curRow += 1
        Tk.Label(frame, text="Location: {}".format(store[1]), font=buttonFont, wraplength=500).grid(row=curRow, column=3, columnspan=5)
        curRow += 1

    backButton = Tk.Button(frame, text="Menu", font=buttonFont, bg='red', fg='white', command= lambda: createMenuFrame(frame)).grid(row=curRow+1, column=3, columnspan=5)

def validateUser(frame):
    global currentUserID
    root.title("WhatABook Login")
    errorLabel = Tk.Label(frame, text="", fg="red", font=buttonFont)
    errorLabel.grid(row=0, column=3, columnspan=5)
    try:
        verifyID = userInput.get()
    except Tk.TclError:
        #print("That's Not a Number! Try Again")
        errorLabel.config(text="That's Not a Number! Try Again")
    else:
        if 1 <= verifyID <= 3:
            errorLabel.config(text="")
            currentUserID = verifyID
            #print(currentUserID)
            createAccountMenu(frame)
        else:
            #print("That Is not a Valid Option!")
            errorLabel.config(text="That Is not a Valid Option!")
    
def accountCheck(frame):
    clearWindow(frame)
    root.title("WhatABook Login")
    header = Tk.Label(frame, text="Verify Account ID", font=buttonFont).grid(row=1, column=3, columnspan=5)
    userIn = Tk.Entry(frame, textvariable=userInput, font=entryFont).grid(row=2, column=3, columnspan=5, pady=7)
    userInButton = Tk.Button(frame, text="Submit", font=buttonFont, bg='green', fg='white', command= lambda: validateUser(frame), width=17).grid(row=3, column=3, columnspan=5, pady=7)
    backButton = Tk.Button(frame, text="Menu", font=buttonFont, bg='red', fg='white', command= lambda: createMenuFrame(frame), width=17).grid(row=4, column=3, columnspan=5, pady=7)

def createAccountMenu(frame):
    clearWindow(frame)
    changePage(0, 5, "none", "none")
    root.title("{}'s Account".format(currentUserID))
    header = Tk.Label(frame, text="What would you like to do?\n--------------", font=buttonFont).grid(row=0, column=3, columnspan=5)
    currentID = Tk.Label(frame, text="Current User: {}".format(currentUserID), font=buttonFont).grid(row=1, column=3, columnspan=5)
    viewWList = Tk.Button(frame, text="Your Wishlist", font=buttonFont, command= lambda: viewWishlist(frame), width=17).grid(row=2, column=3, columnspan=5, pady=7)
    addBookButton = Tk.Button(frame, text="Add Books", font=buttonFont, command= lambda: showBooksToAdd(frame), width=17).grid(row=3, column=3, columnspan=5, pady=7)
    backButton = Tk.Button(frame, text="Menu", font=buttonFont, bg='red', fg='white', command= lambda: createMenuFrame(frame), width=17).grid(row=4, column=3, columnspan=5, pady=7)

def viewWishlist(frame):
    clearWindow(frame)
    root.title("{}'s Wishlist".format(currentUserID))
    currentID = Tk.Label(frame, text="Current User: {}".format(currentUserID), font=buttonFont).grid(row=1, column=3, columnspan=5)
    myWishlist = doQuery("SELECT user.user_id, user.first_name, user.last_name, book.book_id, book.book_name, book.author FROM wishlist INNER JOIN user on wishlist.user_id = user.user_id INNER JOIN book ON wishlist.book_id = book.book_id WHERE user.user_id = {}".format(currentUserID))

    wishList = []

    for book in myWishlist:
        wishList.append("Book Name: {} | Author: {}".format(book[4], book[5]))
    
    header = Tk.Label(frame, text="Your Wishlist | {} Item's\n--------------".format(len(wishList)), font=buttonFont).grid(row=0, column=3, columnspan=5)

    curRow = 1
    iterator = wishList[pageMin:pageMax]
    for item in iterator:
        Tk.Label(frame, text=item, wraplength=500, font=buttonFont).grid(row=curRow, column=3, columnspan=5)
        curRow += 1

    if(len(wishList) > 5):
        nextPage = Tk.Button(frame, text="Next", font=buttonFont, bg='green', fg='white', command= lambda: changePage(5, 11, frame, "wishlist")).grid(row=curRow+1, column=5, columnspan=5)
    
    backPage = Tk.Button(frame, text="Back", font=buttonFont, bg='blue', fg='white', command= lambda: changePage(0, 5, frame, "wishlist")).grid(row=curRow+1, column=1, columnspan=5)
    backButton = Tk.Button(frame, text="Menu", font=buttonFont, bg='red', fg='white', command= lambda: createAccountMenu(frame)).grid(row=curRow+1, column=3, columnspan=5)

def showBooksToAdd(frame):
    clearWindow(frame)
    global successLabel
    root.title("{}'s Add to Wishlist".format(currentUserID))
    header = Tk.Label(frame, text="Available Books\n--------------", font=buttonFont).grid(row=0, column=3, columnspan=5)
    currentID = Tk.Label(frame, text="Current User: {}".format(currentUserID), font=buttonFont).grid(row=1, column=3, columnspan=5)
    bookQuery = doQuery("SELECT * FROM book WHERE book_id NOT IN (SELECT book_id FROM wishlist WHERE user_id = {})".format(currentUserID))

    availBooks = []

    for book in bookQuery:
            availBooks.append("Book ID: {} | Book Name: {}".format(book[0], book[1]))

    curRow = 1
    iterator = availBooks[pageMin:pageMax]
    for item in iterator:
        Tk.Label(frame, text=item, wraplength=500, font=buttonFont).grid(row=curRow, column=3, columnspan=5)
        curRow += 1

    if(len(availBooks) > 5):
        nextPage = Tk.Button(frame, text="Next", font=buttonFont, bg='green', fg='white', command= lambda: changePage(5, 9, frame, "booktoadd")).grid(row=curRow+2, column=5, columnspan=5)
    
    backPage = Tk.Button(frame, text="Back", font=buttonFont, bg='blue', fg='white', command= lambda: changePage(0, 5, frame, "booktoadd")).grid(row=curRow+2, column=1, columnspan=5)
    backButton = Tk.Button(frame, text="Menu", font=buttonFont, bg='red', fg='white', command= lambda: createAccountMenu(frame)).grid(row=curRow+2, column=3, columnspan=5)
    
    bookToAddEntry = Tk.Entry(frame, textvariable=bookToAdd, font=entryFont).grid(row=curRow+1, column=2, columnspan=5)
    userInButton = Tk.Button(frame, text="Add Book", font=entryFont, bg='yellow', fg='black', command= lambda: addBook(frame)).grid(row=curRow+1, column=5, columnspan=5)

def addBook(frame):
    global successLabel
    validBook = bookToAdd.get()
    #print(validBook)
    try:
        db = mysql.connector.connect(**config)
        cursor = db.cursor()
        cursor.execute("INSERT INTO wishlist(user_id, book_id) VALUES({}, {})".format(currentUserID, validBook))
        db.commit()
        showBooksToAdd(frame)

    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print("The Supploed username or password are invalid")
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("The specified database does not exist")
        else:
            print(err)
    finally:
        db.close()

#init tkinter
root = Tk.Tk()
root.title("WhatABook Online")
root.geometry('600x700')
root.grid_rowconfigure(0, weight=1)
root.grid_columnconfigure(0, weight=1)

#settings
buttonFont = font.Font(size=20)
entryFont = font.Font(size=15)

#frame
mainFrame = ttk.Frame(root)

#start
start = createMenuFrame(mainFrame).grid(row=0, column=0)

#vars
userInput = Tk.IntVar()
bookToAdd = Tk.IntVar()
currentUserID = 0
pageMin = 0
pageMax = 5

#main loop
root.resizable(False, False) 
root.mainloop()