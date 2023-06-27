# pytech_insert
# Jason Palmeri
# 1/9/2022

from pymongo import MongoClient

url = "mongodb+srv://admin:admin@cluster0.wfbdf.mongodb.net/pytech"

client = MongoClient(url)

db = client.pytech

student1 = {
    "student_id": "1007",
    "first_name": "John",
    "last_name": "Doe",
    "enrollments": [
        {
            "term": "Summer",
            "gpa": "3.4",
            "start_date": "January 10, 2022",
            "end_date": "June 14, 2022",
            "courses": [
                {
                    "course_id": "CSD310",
                    "description": "Database Development and Use",
                    "instructor": "Professor Krasso",
                    "grade": "A+"
                },
                {
                    "course_id": "CSD320",
                    "description": "Programming with Java",
                    "instructor": "Professor Krasso",
                    "grade": "A+"
                }
            ]
        }
    ]
}

student2 = {
    "student_id": "1008",
    "first_name": "Jimmy",
    "last_name": "Doe",
    "enrollments": [
        {
            "term": "Summer",
            "gpa": "3.4",
            "start_date": "January 10, 2022",
            "end_date": "June 14, 2022",
            "courses": [
                {
                    "course_id": "CSD330",
                    "description": "Database Development and Use",
                    "instructor": "Professor Krasso",
                    "grade": "A+"
                },
                {
                    "course_id": "CSD340",
                    "description": "Programming with Java",
                    "instructor": "Professor Krasso",
                    "grade": "A+"
                }
            ]
        }
    ]
}

student3 = {
    "student_id": "1009",
    "first_name": "Josh",
    "last_name": "Doe",
    "enrollments": [
        {
            "term": "Summer",
            "gpa": "3.4",
            "start_date": "January 10, 2022",
            "end_date": "June 14, 2022",
            "courses": [
                {
                    "course_id": "CSD350",
                    "description": "Database Development and Use",
                    "instructor": "Professor Krasso",
                    "grade": "A+"
                },
                {
                    "course_id": "CSD360",
                    "description": "Programming with Java",
                    "instructor": "Professor Krasso",
                    "grade": "A+"
                }
            ]
        }
    ]
}

students = db.students

print("Inserting...")
student1_student_id = students.insert_one(student1).inserted_id
print("  Inserted student record Student1 into the students collection with document_id " + str(student1_student_id))
student2_student_id = students.insert_one(student2).inserted_id
print("  Inserted student record Student2 into the students collection with document_id " + str(student2_student_id))
student3_student_id = students.insert_one(student3).inserted_id
print("  Inserted student record Student3 into the students collection with document_id " + str(student3_student_id))

input("\n\n End of program, press any key to exit...")