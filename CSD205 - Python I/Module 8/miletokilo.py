#For this module’s assignment, write a program that uses a function to convert miles to kilometers. Your program should prompt the user for the number of miles driven then call a function that converts miles to kilometers. Check and validate all user input and incorporate Try/Except block(s). The program should then display the total miles and the kilometers.

def MtK(mile):
    try:
        return float(mile) * 1.609
    except ValueError:
        return print("Please Enter a Number")


miles = input("Miles Driven: ")
converted = MtK(miles)
if(converted != None):
    print(f"{miles} Miles is Equal to {converted} Kilometers")

