package hashTables;
import cs1c.SongEntry;

/**
 * a wrapper class that allows us to compare songs by title
 *
 * @author Foothill College, Jason Palmeri
 */
public class SongCompTitle implements Comparable<String> {
    protected SongEntry key;
    /**
     * constructs a new instance of SongCompTitle() with SongEntry data
     *
     * @param d the SongEntry we will pull the data from
     */
    public SongCompTitle(SongEntry d) {
        this.key = d;
    }
    /**
     * compares the key's title with another title
     *
     * @param o the title we are comparing to
     */
    @Override
    public int compareTo(String o) {
        return this.key.getTitle().compareTo(o);
    }
    /**
     * checks if the key's title is equal to a given title
     *
     * @param d SongEntry we are checking is equal to
     */
    public boolean equals(SongEntry d) {
        return key.getTitle().equals(d.getTitle());
    }
    /**
     * returns the hash code of this song
     */
    @Override
    public int hashCode() {
        return key.getTitle().hashCode();
    }
    /**
     * returns a string from SongEntry's toString()
     */
    @Override
    public String toString() {
        return key.toString();
    }
}
