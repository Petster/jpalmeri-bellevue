package foothillTunes;

import lazyTrees.Item;
import lazyTrees.LazySearchTree;
import lazyTrees.PrintObject;

import java.util.*;

public class FoothillTunesStore {
    private LazySearchTree<SongEntry> tunes;
    PrintObject<SongEntry> printObject = new PrintObject<>();
    /**
     * Instantiates inventory to be a LazySearchTree of Item objects.
     */
    public FoothillTunesStore() {
        tunes = new LazySearchTree<>();
    }
    /**
     * Add a new song with the name as in parameter into inventory. If there is
     * already same name product, increase amount by one, if not create a new object.
     * @param song		The song to be added to the inventory tree.
     */
    public void addToTunes(SongEntry song) {
        SongEntry tmp = song;
        boolean isFound = tunes.contains(tmp);
        if(!isFound) {
            tunes.insert(tmp);
            SongEntry found = tunes.find(tmp);
            if(found.getCount() == 0) {
                found.incrementCount();
            }
            return;
        }
        SongEntry found = tunes.find(tmp);
        found.incrementCount();
    }
    /**
     * If the song is in the inventory, decrease the count by one.
     * If only one item is left, remove it from the inventory.
     * @param song		The song to be removed to the inventory tree.
     */
    public void removeFromInventory(SongEntry song) {
        SongEntry tmp = song;
        boolean isFound = tunes.contains(tmp);
        if(!isFound) {
            throw new NoSuchElementException();
        }
        SongEntry found = tunes.find(tmp);
        if(found.getCount() == 0) {
            throw new NoSuchElementException();
        } else if(found.getCount() == 1) {
            found.decrementCount();
            tunes.remove(tmp);
        } else {
            found.decrementCount();
        }
    }
    /**
     * Display the first item and last time of the soft tree in lexical order.
     */
    public void showFirstAndLastSong() {
        try {
            SongEntry min = tunes.findMin();
            System.out.println("First Song: " + min.toString());
        } catch (Exception NoSuchElementException) {
            System.out.println("Warning: minimum element not found!");
        }

        try {
            SongEntry max = tunes.findMax();
            System.out.println("Last Song: " + max.toString());
        } catch (Exception NoSuchElementException) {
            System.out.println("Warning: maximum element not found!");
        }
    }
    /**
     * Shows the state of the tree by displaying:
     * - the *hard* inventory, which includes deleted nodes.
     * - the *soft* inventory, which excludes deleted nodes.
     * @param showTree	Set to true if we want to display the contents of the tree
     */
    protected void displayTunesState(boolean showTree) {
        System.out.println("\"hard\" number of unique items (i.e. mSizeHard) = " + tunes.sizeHard());
        System.out.println("\"soft\" number of unique items (i.e. mSize) = " + tunes.size());
        if(!showTree) {
            return;
        }
        System.out.println( "\nTesting traversing \"hard\" inventory:");
        tunes.traverseHard(printObject);
        System.out.println( "\n\nTesting traversing \"soft\" inventory:");
        tunes.traverseSoft(printObject);
        System.out.println("\n");
    }
    public static void main(String[] args) {
        final String musicList = "resources/music_genre_subset.json";

        MillionSongDataSubset songs = new MillionSongDataSubset(musicList);

        SongEntry [] allSongs = songs.getArrayOfSongs();

        ArrayList<SongEntry> songList = new ArrayList<>(Arrays.asList(allSongs));

        FoothillTunesStore store = new FoothillTunesStore();

        System.out.printf("Welcome! We have over %d songs in FoothillTunes store! \n", songList.size());

        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("\nEnter the amount of songs you would like in your playlist:");
        } while(!keyboard.hasNextInt());

        int songCount = Integer.parseInt(keyboard.nextLine());

        while(songCount >= 0) {
            int index = (int)(Math.random() * songList.size());
            System.out.println("Adding: " + songList.get(index));
            store.addToTunes(songList.get(index));
            store.showFirstAndLastSong();
            songCount--;
        }
    }
}
