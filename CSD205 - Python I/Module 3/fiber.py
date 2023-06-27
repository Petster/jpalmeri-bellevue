import os

print("Welcome To Our Fiber Optic Installation Buying Page!")
company = input("Enter Your Company Name: \n")
needed = input("Enter How Many Feet of Fiber Optic %s Needs: \n" % company)
total = float(needed) * 0.87
format_float = "{:.2f}".format(total)
print("To Install %s Feet of Fiber Optic to %s It Would Cost %s" % (needed, company, format_float))

os.system("pause")