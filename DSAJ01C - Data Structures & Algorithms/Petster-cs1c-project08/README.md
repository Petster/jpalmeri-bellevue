# Petster-cs1c-project08/

    src/shortestPath/BaseballFileReader.java
        - File reader class that converts csv to an array of Connection Objects

    src/shortestPath/Connection.java
        - An object that holds 2 cities and the distance between them

    src/shortestPath/FHgraph.java
        - Graph data structure from course_examples
        - uses Dijkstra's algorithm to find the shortest path between two points

    src/shortestPath/Pair.java
        - Pair data structure from course_examples
        - used to create an adjacency list that stores vertices and their costs

    src/shortestPath/RouteFinder.java
        - The main application
        - allows the user to find the shortest path between cities
        - allows the user to avoid certain cities

    resources/BaseballCitiesEdgeCosts.txt
        - original text case file provided

    resources/test.txt
        - test to help me visualize Week 10 discussion problem

    resources/RUN.txt
        - an output of the main java class and its test cases
        - Test Case Requirements:
            - 3 Different cities as starting points
            - 3 Different cities as destination
            - Test permutations of the start and end cities with a list of cities to filter

    README.md
        - description of submitted files and additional questions

# Additional Observations
- Sometimes taking away flight paths, shortens the overall flight path
- Some paths just do not exist when you remove enough flight paths
- Having no avoided cities seems to keep it really short, as most flights have a direct flight to the destination
