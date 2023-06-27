package hashTables;

import java.util.NoSuchElementException;
/**
* a hash table that supports finding elements based on their key
*
* @author Foothill College, Jason Palmeri
*/
public class FHhashQPwFind<KeyType, E extends Comparable<KeyType>> extends FHhashQP<E>{
    /**
     * initializes a new FHhashQPwFind() based on its super class FHhashQP()
     *
     * @param tableSize the size of the table to create
     */
    public FHhashQPwFind(int tableSize) {
        super(tableSize);
    }
    /**
     * finds the element with the given key in the hash table
     *
     * @param key the key of the element we are looking for
     */
    public E find(KeyType key) {
        if(mArray[findPosKey(key)].state != ACTIVE) {
            throw new NoSuchElementException();
        }
        return mArray[findPosKey(key)].data;
    }
    /**
     * calculates the hash code of the given key
     *
     * @param key the key we are calculating the hash code for
     */
    protected int myHashKey(KeyType key) {
        int hashVal;

        hashVal = key.hashCode() % mTableSize;
        if(hashVal < 0) {
            hashVal += mTableSize;
        }
        return hashVal;
    }
    /**
     * find the position of the element with the given key in the hash table
     *
     * @param key the key of the element we are trying to find
     */
    protected int findPosKey(KeyType key) {
        int kthOddNum = 1;
        int index = myHashKey(key);

        while (mArray[index].state != EMPTY && mArray[index].data.compareTo(key) != 0) {
            index += kthOddNum;
            kthOddNum += 2;
            if ( index >= mTableSize ) {
                index -= mTableSize;
            }
        }
        return index;
    }
}
