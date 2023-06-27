#Welcome Message
print("Welcome To Our Fiber Optic Installation Buying Page!")
#Get Company Name
company = input("Enter Your Company Name: \n")
#Get Amount of Fiber Optic Needed
needed = input(f"Enter How Many Feet of Fiber Optic {company} Needs: \n")
#Set Default Price
price = 0.87
#Convert User Input to Float
neednum = float(needed)
#Check if over or under a threshold
if(neednum >= 100 and neednum <= 249):
    price = 0.80
elif(neednum >= 250 and neednum <= 499):
    price = 0.70
elif(neednum >= 500):
    price = 0.50
#Calculate Total Price
total = neednum * price
#Format Total to Dollar Value 0.00
format_float = "{:.2f}".format(total)
#Output Final Results
print(f"To Install {neednum} Feet of Fiber Optic to {company} It Would Cost ${format_float} at a cost of ${price}/foot")