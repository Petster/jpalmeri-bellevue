# mongodb_test.py
# Jason Palmeri
# 1/9/2022
# test mongodb connection

from pymongo import MongoClient

url = "mongodb+srv://admin:admin@cluster0.wfbdf.mongodb.net/pytech"

client = MongoClient(url)

db = client.pytech

print("--Pytech Collection List--")
print(db.list_collection_names())
input("\n\n End of program, press any key to exit...")