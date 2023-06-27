#For this module’s assignment, write a program that uses a while loop to determine how long it takes for an investment to double at a given interest rate. The input will be an annualized interest rate and the initial investment amount, and the output is the number of years it takes an investment to double.

#https://www.calculator.net/interest-calculator.html?cstartingprinciple=100&cannualaddition=0&cmonthlyaddition=0&cadditionat1=beginning&cinterestrate=6&ccompound=annually&cyears=12&ctaxtrate=0&cinflationrate=0&printit=0&x=121&y=23#interestresults
#checked using this


air = input("Your Annual Interest Rate (1-100)\n")
ini = input("Your Initial Investment\n$")

airF = float(air)
iniF = float(ini)

iniD = iniF * 2
years = 0
newAmount = iniF

while newAmount < iniD:
    years+=1
    ir = (airF / 100) * newAmount
    newAmount += ir

print(newAmount)
print(f"With an Annual Interest Rate of {airF}% It would take {years} years for you initial investment of ${iniF} to double to ${iniD}")
