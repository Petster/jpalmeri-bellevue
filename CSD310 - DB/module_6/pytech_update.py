# pytech_update
# Jason Palmeri
# 1/19/2022

from pymongo import MongoClient

url = "mongodb+srv://admin:admin@cluster0.wfbdf.mongodb.net/pytech"

client = MongoClient(url)

db = client.pytech

students = db.students

studentList = students.find({})

print("-Student Documents-")

for docs in studentList:
    print("Student ID:" + docs["student_id"] + "\nFirst Name: " + docs["first_name"] + "\nLast Name: " + docs["last_name"] + "\n")

result = students.update_one({"student_id": "1007"}, {"$set": {"last_name": "Ardenweald"}})

studentOne = students.find_one({"student_id": "1007"})

print("-Student 1 Docs-")

print("Student ID:" + studentOne["student_id"] + "\nFirst Name: " + studentOne["first_name"] + "\nLast Name: " + studentOne["last_name"] + "\n")

input("\n\n End of Program..")