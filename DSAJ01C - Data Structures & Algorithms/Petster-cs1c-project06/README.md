# Petster-cs1c-project06/

    src/hashTables/MyTunes.java
        - The main application
        - Reads the song information from a JSON input file to
            Populate two hash tables to compare SongEntry objects based on their different keys.

    src/hashTables/FHhashQP.java
        - Hash function that incorporates quadratic probing
    
    src/hashTables/FHhashQPwFind.java
        - Extension of FHhashQP that finds an object based on the key

    src/hashTables/SongCompArtist.java
        - Wrapper class that helps compare songs based on the Artist

    src/hashTables/SongCompTitle.java
        - Wrapper class similar to SongCompArtist, but for comparing song titles

    src/hashTables/TableGenerator.java
        - generates hash tables based on either the artist or the song title, and puts them
            into an instance of FHhashQPwFind

    resources/findArtists_2.txt
        - a secondary test case for the MyTunes class, for artists

    resources/findTitles_2.txt
        - a secondary test case for the MyTunes class, for titles

    resources/RUN.txt
        - various test case outputs of MyTunes.java

    README.md
        - description of submitted files and additional questions

# Additional Questions

### Which method(s) probe for an element when adding a new key to the table?
 - the findPos() method will update the probe variable

### From the client's perspective which method(s) may result in probing the table?
 - the insert() method is probably going to be the most common method that results in probing, as it calls the findPos() method.

### Given the initial table size of 10, what is the actual initial table size used? and why?
 - in the FHhashQP we set the initial size to 7, and when we create a new instance of that class we check if the table size is less than 7, and if it is greater than 7 we are calling nextPrime, which would give us 11

### How does different initial table sizes impact the number of quadratic probes?
 - more space to insert items, has a greater chance for the item to go in on the first try, not requiring the formula discussed in the modules.

### Change the initial requested table size. In your README discuss how this effects the number of quadratic probes performed?
 - changing the table size from 10 to 15 made the number of quadratic probes go down to 14. I believe that it went down is because with more open spaces the amount of times we needed to do the "index = hashIndex + k*k" was less.
 - its safe to assume that an increased table size, decreases the amount of probes required.