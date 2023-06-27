# Project folder:
    Petster-cs1c-project02/

    src/subsetSum/ShoppingBag.java
        - The main application
        - An object of type ShoppingBag class creates an object of type subset sum to find a best
            possible grocery shopping list within the given budget.

    src/subsetsum/SubsetSum.java
        - The SubsetSum class uses the findSubset() method to find all subsets of a
            given ArrayList, and find the closest sum to the given budget
        - The SubsetSum class also contains the findSubsetOfSongs() method
            to find the subset of a given array, and find the closest sum to the duration
        
    src/subsetsum/GroceriesFileReader.java
        - The GroceriesFileReader uses the readFile() method to read a file
            based on the filePath, and convert the input from csv to an ArrayList<Double>

    src/subsetsum/example.java
        - This file was me proving that my practice problem from
            the assigned module "An Algorithm" worked correctly 

    resources/RUN.txt
        - various test case outputs of ShoppingBag.java
    
    resources/testcase1.txt
        - a CSV delimited shopping list with key,value pairs

    resources/testcase2.txt
        - a CSV delimited shopping list with key,value pairs, including negatives

    README.md
        - description of submitted files