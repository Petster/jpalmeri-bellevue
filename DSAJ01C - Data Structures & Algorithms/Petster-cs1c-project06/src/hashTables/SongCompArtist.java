package hashTables;
import cs1c.SongEntry;
import java.util.ArrayList;
/**
 * A wrapper class that allows us to compare songs based on artist
 *
 * @author Foothill College, Jason Palmeri
 */
public class SongCompArtist implements Comparable<String> {
    protected String key;
    protected ArrayList<SongEntry> artistList;
    /**
     * constructs a new SongCompArtist() with a key and a value
     *
     * @param
     */
    public SongCompArtist(String key, ArrayList<SongEntry> artistList) {
        this.key = key;
        this.artistList = new ArrayList<SongEntry>();
    }
    /**
     * compareTo() based on the key
     *
     * @param o the string we are comparing to
     */
    @Override
    public int compareTo(String o) {
        return this.key.compareTo(o);
    }
    /**
     * adds a song to an existing SongCompArtist().artistList
     *
     * @param e the SongEntry we are adding
     */
    public void addSong(SongEntry e) {
        artistList.add(e);
    }
    /**
     * checks if the key is equal to the given key
     *
     * @param d an instance of SongCompArtist
     */
    public boolean equals(SongCompArtist d) {
        return key.equals(d.key);
    }
    /**
     * obtains the hash code
     */
    @Override
    public int hashCode() {
        return key.hashCode();
    }
    /**
     * returns the key and size of the array of the class
     */
    @Override
    public String toString() {
        return "\t\t" + key + " size\t" + artistList.size();
    }
}
