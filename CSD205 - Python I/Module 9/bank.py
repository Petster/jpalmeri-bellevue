#For this module, we will work with classes by creating a banking program. Your program will use the inheritance diagram from this week in order to create a parent class and two child classes. Your program will create an object of each type (CheckingAccount and SavingsAccount).

#Jason Palmeri
#Assignment 9
#CSD205

#random number for account number
from random import randint
#BankAccount
class BankAccount:
    def __init__(self, accountNumber, balance):
        self.accountNumber = accountNumber
        self.balance = balance

    #Bank Account Functions
    def Withdrawl(self, amount):
        if(self.balance > amount):
            self.balance -= amount
            print(f"You have Withdrawn ${amount} from Account #{self.accountNumber}.\nNew Balance: ${self.balance}")

    def Deposit(self, amount):
        if(amount > 0):
            self.balance += amount
            print(f"You have added ${amount} to Account #{self.accountNumber}.\nNew Balance: ${self.balance}")

    def GetBalance(self, check, save):
        totalBal = check + save
        print(f"You Have ${totalBal} Available to Spend.")

#Checking
class CheckingAccount(BankAccount):
    def __init__(self, accountNumber, balance):
        self.fees = 5.00
        self.minbal = 50.00
        BankAccount.__init__(self, accountNumber, balance)
    #Checking Functions
    def DeductFees(self, amount):
        if(self.balance >= self.minbal + self.fees + amount):
            self.balance -= self.fees
            return True
        else:
            return False
        

    def CheckMinBal(self):
        if(self.balance <= self.minbal):
            return False
        else:
            return True

    def Withdrawl(self, amount):
        standing = self.CheckMinBal()
        if(standing == True):
            feesDeductable = self.DeductFees(amount)
            if(feesDeductable == True):
                if(self.balance > amount):
                    self.balance -= amount
                    print(f"You have withdrawn ${amount} from account #{self.accountNumber} with a fee of ${self.fees}.\nNew Balance: ${self.balance}")
                else:
                    print(f"Your withdrawl request of ${amount} could not be processed.")
            else:
                print(f"We couldn't process your request because your balance would be below the minimum afterwards.")
        else:
            print(f"Your Withdrawl Request of ${amount} could not be processed because you do not have the minimum amount to withdraw.")

#Savings
class SavingsAccount(BankAccount):
    def __init__(self, accountNumber, balance):
        self.ir = 0.02
        BankAccount.__init__(self, accountNumber, balance)
    #Savings Functions
    def AddInterest(self):
        newBal = self.balance
        for x in range(1, 6):
            newBal += (newBal * self.ir)
            formatBal = round(newBal, 2)
            print(f"After {x} year(s), you would have ${formatBal}")

#Create Bank Account
def CreateBankAccount():
    print("Welcome to the Create a Bank Account System")
    print("How Much Would You Like To Deposit To Your New Checking Account? ($50.00 Minimum)")
    checkAccIni = float(input("$"))
    while checkAccIni < 50.00:
        print(f"Error: Your Initial Deposit of {checkAccIni} is Less Than $50.00\nPlease Enter a Value Above $50.00")
        checkAccIni = float(input("$"))
    print("How Much Would You Like To Deposit To Your New Savings Account?")
    saveAccIni = float(input("$"))
    accNum = randint(10000, 50000)

    global newCheck
    global newSave

    newCheck = CheckingAccount(accNum, checkAccIni)
    newSave = SavingsAccount(accNum, saveAccIni)

    print("----------------------------")
    print(f"Thank you for Creating your account with our Bank!\nYour Account Number is {accNum}")
    print("----------------------------")

#Start Loop
while True:
    if 'bankAcc' in locals():
        print("1: Check Balance")
        print("2: Withdraw from Checking")
        print("3: Deposit to Checking")
        print("4: Check Savings Interest (Next 4 Years)")
        print("5: Exit Bank Program")
    else:
        print("1: Create Bank Account")
        print("2: Exit Bank Program")

    #accept input
    userIn = int(input("What Would You Like to Do? "))

    if not 'bankAcc' in locals():
        if(userIn == 1):
            bankAcc = CreateBankAccount()
        elif(userIn == 2):
            break
    else:
        if(userIn == 1):
            print("----------------------------")
            print(f"You Have ${newCheck.balance} Available in Your Checking Account\nYou Have ${newSave.balance} Available In Your Savings Account")
            newCheck.GetBalance(newCheck.balance, newSave.balance)
            print("----------------------------")
        elif(userIn == 2):
            print("----------------------------")
            amount = float(input("Amount to Withdraw: $"))
            newCheck.Withdrawl(amount)
            print("----------------------------")
        elif(userIn == 3):
            print("----------------------------")
            amount = float(input("Amount to Deposit: $"))
            newCheck.Deposit(amount)
            print("----------------------------")
        elif(userIn == 4):
            print("----------------------------")
            newSave.AddInterest()
            print("----------------------------")
        elif(userIn == 5):
            break
