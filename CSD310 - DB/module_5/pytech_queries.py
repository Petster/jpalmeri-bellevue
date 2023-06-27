# pytech_insert
# Jason Palmeri
# 1/9/2022

from pymongo import MongoClient

url = "mongodb+srv://admin:admin@cluster0.wfbdf.mongodb.net/pytech"

client = MongoClient(url)

db = client.pytech

students = db.students

student_list = students.find({})

print("Displaying Student Documents")
for person in student_list:
    print("  Student ID: " + person["student_id"] + "\n  First Name: " + person["first_name"] + "\n  Last Name: " + person["last_name"] + "\n")

student3 = students.find_one({"student_id": "1009"})

print("Displaying Student 3 Query")
print("  Student ID: " + student3["student_id"] + "\n  First Name: " + student3["first_name"] + "\n  Last Name: " + student3["last_name"] + "\n")

input("\n\n End of program, press any key to exit...")