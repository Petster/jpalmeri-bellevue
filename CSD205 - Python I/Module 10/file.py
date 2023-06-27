#ask user for directory to save to, and newfile name
#ask user for name, address, phone
#create file, csv format, save in directory
#read the file that was just created

import os
from os.path import exists
username = os.getlogin()

#file functions
def openFile(dir, name):
    checkEnd = dir.endswith('/')
    if(checkEnd == True):
        file = dir + name
    else:
        file = dir + "/" + name

    if(file[-3] != '.txt'):
        temp = file
        file = temp + '.txt'

    f = open(file, "w+")
    return f

def readFile(dir, name):
    checkEnd = dir.endswith('/')
    if(checkEnd == True):
        file = dir + name
    else:
        file = dir + "/" + name

    if(file[-3] != '.txt'):
        temp = file
        file = temp + '.txt'

    f = open(file, "r")
    return f

def checkFile(dir, name):
    checkEnd = dir.endswith('/')
    if(checkEnd == True):
        file = dir + name
    else:
        file = dir + "/" + name

    if(file[-3] != '.txt'):
        temp = file
        file = temp + '.txt'

    check = exists(file)
    if(check == True):
        return True
    else:
        return False

def writeFile(file, string):
    newString = ""
    for x in string:
        newString += f"{x}, "
    file.write(newString)


#main functions
def createFile():
    dir = input(f"Directory: C:/Users/{username}/Desktop/")
    fileName = ""
    while fileName == "":
        fileName = input("File Name: ")
    directory = f"C:/Users/{username}/Desktop/" + dir

    inputs = []
    name = input("Name: \n")
    inputs.append(name)
    add = input("Address: \n")
    inputs.append(add)
    phone = input("Phone: \n")
    inputs.append(phone)


    L = openFile(directory, fileName)
    writeFile(L, inputs)
    
    print(f"File written to {directory}{fileName}\nData Written {inputs}")

def rFile():
    dir = input(f"Directory: C:/Users/{username}/Desktop/")
    fileName = ""
    while fileName == "":
        fileName = input("File Name: ")
    directory = f"C:/Users/{username}/Desktop/" + dir

    check = checkFile(directory, fileName)

    if(check == True):
        L = readFile(directory, fileName)
        contents = L.read()
        return print(contents)
    else:
        print("File doesn't exist!")


#main loop
while True:
    print("1: Create File")
    print("2: Read File")
    print("3: Exit")
    print("------------")
    userIn = int(input("Choice: "))

    match userIn:
        case 1:
            print("------------")
            createFile()
            print("------------")
        case 2:
            print("------------")
            rFile()
            print("------------")
        case 3:
            break


