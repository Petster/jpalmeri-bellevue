# pytech_delete
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

student4 = {
    "student_id": "1010",
    "first_name": "Manny",
    "last_name": "Johnson"
}

print("Inserting...")
student4_student_id = students.insert_one(student4).inserted_id
print("Inserted student record Student4 into the students collection with document_id " + str(student4_student_id))

studentFour = students.find_one({"student_id": "1010"})

print("\n-Student 4 Docs-")

print("Student ID:" + studentFour["student_id"] + "\nFirst Name: " + studentFour["first_name"] + "\nLast Name: " + studentFour["last_name"] + "\n")

print("Deleting Student 4...\n")
delete_student_four = students.delete_one({"student_id": "1010"})

newstudentList = students.find({})

for docs in newstudentList:
    print("Student ID:" + docs["student_id"] + "\nFirst Name: " + docs["first_name"] + "\nLast Name: " + docs["last_name"] + "\n")

input("\n\n End of program, press any key to exit...")