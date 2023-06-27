#Jason Palmeri
#Assignment 4
#Initialize with values.
stateList = (
    "Alabama",
    "Alaska",
    "Arizona",
    "Arkansas",
    "California",
    "Colorado",
    "Connecticut",
    "Delaware",
    "Florida",
    "Georgia",
    "Hawaii",
    "Idaho",
    "Illinois",
    "Indiana",
    "Iowa",
    "Kansas",
    "Kentucky",
    "Louisiana",
    "Maine",
    "Maryland",
    "Massachusetts",
    "Michigan",
    "Minnesota",
    "Mississippi",
    "Missouri",
    "Montana",
    "Nebraska",
)
#Display the contents in a single statement.
print(stateList)
print("------------")
#Iterate through the collection displaying
#the output as a complete sentence
#using each value.
for index, state in enumerate(stateList):
    if index % 2 == 0:
        print(f"I Live In {state}")
    else:
        print(f"I Don't Live In {state}")
#Repeat the output in reverse
#order using a different context string.
print("------------")
newState = stateList[::-1]
for index, state in enumerate(newState):
    if index % 2 == 0:
        print(f"I Want to Live In {state}")
    else:
        print(f"I Don't Want To Live In {state}")
