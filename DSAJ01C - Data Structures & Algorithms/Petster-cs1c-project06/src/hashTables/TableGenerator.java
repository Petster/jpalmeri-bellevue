package hashTables;
import cs1c.SongEntry;
import java.util.ArrayList;

/**
 * TableGenerator() creates Hash Maps of a given array using either the Title or Artist as the key.
 *
 * @author Foothill College, Jason Palmeri
 */
public class TableGenerator {
    protected ArrayList<String> artistNames;
    FHhashQPwFind<String, SongCompTitle> tableOfSongTitles;
    FHhashQPwFind<String, SongCompArtist> tableOfArtists;
    /**
     * constructs a new TableGenerator() with given table size
     *
     * @param tableSize the size of the new hash table
     */
    public TableGenerator(int tableSize) {
        artistNames = new ArrayList<>();
        tableOfArtists = new FHhashQPwFind(tableSize);
        tableOfSongTitles = new FHhashQPwFind(tableSize);
    }
    /**
     * populates the hash table of song titles with the given song list
     *
     * @param allSongs a list of all songs to be put into the tableOfSongTitles
     */
    public FHhashQPwFind<String, SongCompTitle> populateTitleTable(SongEntry[] allSongs) {
        int counter = 0;
        for(SongEntry x : allSongs) {
            SongCompTitle temp = new SongCompTitle(x);
            tableOfSongTitles.insert(temp);
            counter++;
        }

        System.out.println("\nPopulating hash table of song titles...");
        System.out.println("Number of songs attempted to insert: " + counter);
        System.out.println("Number of quadratic probes performed: " + tableOfSongTitles.countOfProbes);
        System.out.println("Final table size for the hash table of song titles: " + tableOfSongTitles.mTableSize);

        return tableOfSongTitles;
    }
    /**
     * populates the hash table of songs based on the artist from the given array
     *
     * @param allSongs a list of all songs to be put into the tableOfSongArtists
     */
    public FHhashQPwFind<String, SongCompArtist> populateArtistTable(SongEntry[] allSongs) {
        int counter = 0;
        for(SongEntry x : allSongs) {
            if(!artistNames.contains(x.getArtistName())) {
                artistNames.add(x.getArtistName());
                tableOfArtists.insert(new SongCompArtist(x.getArtistName(), new ArrayList<>()));
                tableOfArtists.find(x.getArtistName()).addSong(x);
            } else {
                tableOfArtists.find(x.getArtistName()).addSong(x);
            }
            counter++;
        }

        System.out.println("\nPopulating hash table of artists...");
        System.out.println("Number of songs attempted to insert: " + counter);
        System.out.println("Number of quadratic probes performed: " + tableOfArtists.countOfProbes);
        System.out.println("Final table size for the hash table of song titles: " + tableOfArtists.mTableSize);

        return tableOfArtists;
    }
    /**
     * returns the list of all artists in the artistNames array
     */
    public ArrayList<String> getArtists() {
        return artistNames;
    }
}
