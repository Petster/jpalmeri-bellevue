package stacks;
import java.util.*;

/**
 * A Singly Linked Data Structure that allows the user
 * to push() items to the top of a list
 * pop() items off the top
 * and peek() at the top item
 *
 * @author Foothill College, Jason Palmeri
 */
public class StackList<T> implements Iterable<T> {
    /**
     * a Private class to StackList that creates a Node object
     * for each <T> Object in StackList
     * Helps to keep track of the next value to a node
     *
     * @author Foothill College, Jason Palmeri
     */
    private class Node {
        Node next;
        T data;
        /**
         *  Node() creates an instance of the Node class
         *  setting the data
         *
         * @param x the data we are setting to the Node
         */
        Node(T x) {
            data = x;
        }
        /**
         *  insertBefore() creates a new node
         *  sets the nodes next element to the current Head
         *  and sets the head equal to the new Node
         *
         * @param x the data we are using to create the new Node
         */
        void insertBefore(T x) {
            Node newNode = new Node(x);
            newNode.next = mHead;
            mHead = newNode;
        }
        /**
         *  remove() removes the requested Node (this)
         */
        public void remove() {
            if(mHead == this) {
                mHead = this.next;
                return;
            }
            Node mCurrent = mHead;
            while(mCurrent != null && mCurrent.next != this) {
                mCurrent = mCurrent.next;
            }
            if(mCurrent != null) {
                mCurrent.next = this.next;
            }
        }
    }
    /**
     * a Private class to StackList that implements the Iterator<T> Class
     * Allows the StackList to be iterated against
     *
     * @author Foothill College, Jason Palmeri
     */
    private class StackIterator implements Iterator<T> {
        protected Node mCurrentNode;
        protected Node mLastNodeReturned = null;
        protected int mCurrentIndex;
        protected int mIterModCount = modCount;
        /**
         *  StackIterator() creates an instance of StackIterator
         *  and sets default values
         */
        public StackIterator() {
            mCurrentNode = mHead;
            mCurrentIndex = 0;
        }
        /**
         *  hasNext() checks if the current index is less than the size of the Stacklist
         */
        public boolean hasNext() {
            return mCurrentIndex < mSize;
        }
        /**
         *  next() checks if there is a hasNext() value and sets LastNode to currentNode
         *  sets the currentNode to currentNode's next Node
         *  increases the Iterator Index
         *  and returns the Last requested Node's Data
         */
        public T next() {
            if(mIterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            mLastNodeReturned = mCurrentNode;
            mCurrentNode = mCurrentNode.next;
            mCurrentIndex++;
            return mLastNodeReturned.data;
        }
        /**
         *  remove() checks that there is a LastNode
         *  if there is it will remove that node
         *  decrease the StackList size
         *  and set the LastNode to null
         */
        public void remove() {
            if(mIterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if(mLastNodeReturned == null) {
                throw new IllegalStateException();
            }
            mLastNodeReturned.remove();
            mSize--;
            mIterModCount++;
            modCount++;
            mLastNodeReturned = null;
        }
    }
    /**
     *  getNode() goes through each element in the StackList until
     *  it finds the Node with the correct Index
     *
     * @param index the index we are searching for
     */
    private Node getNode(int index) {
        Node p;
        int k;

        for(k = 0, p = mHead.next; k < index; p = p.next, k++);

        return p;
    }
    private String name;
    private int mSize;
    private int modCount = 0;
    private Node mHead;
    /**
     *  StackList() Creates an instance of StackList with a reference name
     *
     * @param name The name used for toString()
     */
    public StackList(String name) {
        this.name = name;
        clear();
    }
    /**
     *  get() uses useNode() to find the requested index's data
     *
     * @param index the index we are searching for
     */
    public T get(int index) {
        if(index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
    }
    /**
     *  push() inserts an element at the top of the list
     *  setting mHead = new element
     *
     * @param x the item we are pushing to the list
     */
    public boolean push(T x) {
        mHead.insertBefore(x);
        mSize++;
        modCount++;
        return true;
    }
    /**
     *  pop() removes the top element of the list
     *  setting mHead = mHead's next value
     *  reducing the size of the List
     *  and returning value that was removed
     */
    public T pop() {
        T previousData = mHead.data;
        mHead = mHead.next;
        mSize--;
        modCount++;
        return previousData;
    }
    /**
     *  peek() returns the top element of the stack mHead or null if the list is empty
     */
    public T peek() {
        return mHead.data != null ? mHead.data : null;
    }
    /**
     *  clear() resets the List to size 0, null mHead
     */
    public void clear() {
        mSize = 0;
        mHead = new Node(null);
        modCount++;
    }
    /**
     *  toString() returns the name of the StackList, the size and all elements in the
     *  list in a neat format
     */
    public String toString() {
        String x = name + " with " + mSize + " links:\n[";
        for(T d : this) {
            x += " " + d;
        }
        x += " ]";
        return x;
    }
    /**
     *  isEmpty() checks if the StackList size is 0
     */
    public boolean isEmpty() {
        return mSize == 0;
    }
    /**
     *  size() returns the size of the list
     */
    public int size() {
        return mSize;
    }
    /**
     *  iterator() returns an object of StackIterator
     */
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
