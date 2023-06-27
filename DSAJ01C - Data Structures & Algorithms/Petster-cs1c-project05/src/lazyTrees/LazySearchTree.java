package lazyTrees;

import java.util.*;

/**
 * A binary search tree with lazy deletion functionality
 * tracks the size of the tree both hard (all nodes) and soft (non deleted nodes)
 *
 *
 * @author Foothill College, Jason Palmeri
 */
public class LazySearchTree<E extends Comparable< ? super E > > {
    // Non Deleted Nodes Total
    protected int mSize;
    // Non Deleted and Deleted (Lazy) Nodes Total
    protected int mSizeHard;
    protected LazySTNode<E> mRoot;

    /**
     * a Private class to LazySearchTree that creates a Node object
     * for each <E> Object in the binary search tree
     * keeps track of the left and right children, data
     * and if the node is lazily deleted
     *
     * @author Foothill College, Jason Palmeri
     */
    private class LazySTNode<E extends Comparable< ? super E > > {
        LazySTNode<E> lftChild;
        LazySTNode<E> rtChild;
        protected E data;
        protected boolean deleted;
        /**
         * creates a new node with an assigned data value
         *
         * @param d data value to assign
         * @param lft the left data node to assign
         * @param rt the right data node to assign
         */
        public LazySTNode( E d, LazySTNode<E> lft, LazySTNode<E> rt ) {
            lftChild = lft;
            rtChild = rt;
            data = d;
            deleted = false;
        }
    }
    /**
     * creates an empty instance of a LazySearchTree
     */
    public LazySearchTree() {
        clear();
    }
    /**
     * checks if the size of the tree is empty
     */
    public boolean empty() {
        return (mSize == 0);
    }
    /**
     * returns the size of the tree with nodes that are not deleted
     */
    public int size() {
        return mSize;
    }
    /**
     * returns the size of the tree with all nodes deleted and non deleted
     */
    public int sizeHard() {
        return mSizeHard;
    }
    /**
     * clears the tree by setting size to 0 and root to null
     */
    public void clear() {
        mSize = 0;
        mRoot = null;
    }
    /**
     * public method to find the minimum node of the tree root.
     */
    public E findMin() {
        if (mRoot == null)
            throw new NoSuchElementException();
        return findMin(mRoot).data;
    }
    /**
     * public method to find the maximum node of the tree root
     */
    public E findMax() {
        if (mRoot == null)
            throw new NoSuchElementException();
        return findMax(mRoot).data;
    }
    /**
     * public method to find a specific node
     *
     * @param x the node we are searching for
     */
    public E find(E x) {
        LazySTNode<E> resultNode;
        resultNode = find(mRoot, x);
        if (resultNode == null)
            throw new NoSuchElementException();
        return resultNode.data;
    }
    /**
     * searches for a node that contains certain data, returns a boolean
     *
     * @param x the node we are searching for
     */
    public boolean contains(E x) {
        return find(mRoot, x) != null;
    }
    /**
     * public method that inserts data into the tree
     *
     * @param x the data to insert into the tree
     */
    public boolean insert(E x) {
        int oldSize = mSize;
        mRoot = insert(mRoot, x);
        return (mSize != oldSize);
    }
    /**
     * the public method to remove a node from the tree based on its data
     *
     * @param x the data to remove from the tree
     */
    public boolean remove(E x) {
        int oldSize = mSize;
        remove(mRoot, x);
        return (mSize != oldSize);
    }
    /**
     * public traversal method to search through all nodes
     * searches through both deleted and non deleted notes
     *
     * @param printObject the function used to print out the tree
     */
    public void traverseHard(PrintObject<E> printObject) {
        traverseHard(printObject, mRoot);
    }
    /**
     * public traversal method to search through all nodes
     * searches through non deleted notes
     *
     * @param printObject the function used to print out the tree
     */
    public void traverseSoft(PrintObject<E> printObject) {
        traverseSoft(printObject, mRoot);
    }
    /**
     * public garbage collection method
     */
    public boolean collectGarbage() {
        int previousSize = mSizeHard;
        mRoot = collectGarbage(mRoot);
        return previousSize != mSizeHard;
    }
    /**
     * private garbage collection method
     * checks for multiple cases, if the root has no children, or only right, only left, and deletes the node
     * and sets the mSizeHard to the appropriate value
     *
     * @param root the root we are collecting garbage from
     */
    protected LazySTNode<E> collectGarbage(LazySTNode<E> root) {
        if(root == null) {
            return null;
        }
        root.lftChild = collectGarbage(root.lftChild);
        root.rtChild = collectGarbage(root.rtChild);
        if(root.deleted) {
            if(root.lftChild == null && root.rtChild == null) {
                //if there is no children nodes
                mSizeHard--;
                root = null;
            } else if(root.lftChild == null) {
                //if there is no left child set root to right child
                mSizeHard--;
                return root.rtChild;
            } else if(root.rtChild == null) {
                //if there is no right child set root to left child
                mSizeHard--;
                return root.lftChild;
            } else {
                LazySTNode<E> temp = findMinHard(root.rtChild);
                root.data = temp.data;
                root.deleted = temp.deleted;
                temp.deleted = true;
                root.rtChild = removeHard(root.rtChild, temp.data);
            }
        }
        return root;
    }
    /**
     * removeHard() takes a root and a value to search for
     * and attempts to find the value. Upon finding the value it will remove
     * the node from the tree, instead of setting it to deleted
     *
     * @param root the root we are searching through
     * @param x the node data we are searching for
     */
    protected LazySTNode<E> removeHard(LazySTNode<E> root, E x) {
        int compareResult;
        if(root == null) {
            return null;
        }

        compareResult = x.compareTo(root.data);
        if(compareResult < 0) {
            root.lftChild = removeHard(root.lftChild, x);
        } else if(compareResult > 0) {
            root.rtChild = removeHard(root.rtChild, x);
        } else if(root.lftChild != null && root.rtChild != null) {
            root.data = findMinHard(root.rtChild).data;
            root.rtChild = removeHard(root.rtChild, root.data);
        } else {
            root = (root.lftChild != null) ? root.lftChild : root.rtChild;
            mSizeHard--;
        }
        return root;
    }
    /**
     * private method to find the minimum node of a given root
     * checks for nodes that are both deleted and not
     *
     * @param root the root node to search through
     */
    protected LazySTNode<E> findMinHard(LazySTNode<E> root ) {
        if (root == null) {
            return null;
        }
        if (root.lftChild == null) {
            return root;
        }
        return findMinHard(root.lftChild);
    }
    /**
     * private method to find the maximum node of a given root
     * checks for nodes that are both deleted and not
     *
     * @param root the root node to search through
     */
    protected LazySTNode<E> findMaxHard(LazySTNode<E> root ) {
        if (root == null){
            return null;
        }
        if (root.rtChild == null) {
            return root;
        }
        return findMaxHard(root.rtChild);
    }
    /**
     * private method to find the minimum node of a given root
     * checks for nodes that are not marked as deleted
     *
     * @param root the root node to search through
     */
    protected LazySTNode<E> findMin(LazySTNode<E> root) {
        if (root == null) {
            return null;
        }
        if (root.lftChild == null) {
            if (root.deleted) {
                return findMin(root.rtChild);
            } else {
                return root;
            }
        }
        return findMin(root.lftChild);
    }
    /**
     * private method that finds the maximum value of a given root
     * only checks for nodes that are not marked as deleted
     *
     * @param root the root node to search through
     */
    protected LazySTNode<E> findMax(LazySTNode<E> root) {
        if (root == null) {
            return null;
        }
        if (root.rtChild == null) {
            if (root.deleted) {
                return findMax(root.lftChild);
            } else {
                return root;
            }
        }
        return findMax(root.rtChild);
    }
    /**
     * private insertion method that increased both the soft size and hard size of the tree
     *
     * @param root the root node to insert the new node into
     * @param x the data to create the new node that gets inserted
     */
    protected LazySTNode<E> insert(LazySTNode<E> root, E x) {
        int compareResult;
        if (root == null) {
            mSize++;
            mSizeHard++;
            return new LazySTNode<E>(x, null, null);
        }
        compareResult = x.compareTo(root.data);
        if (compareResult < 0) {
            root.lftChild = insert(root.lftChild, x);
            // insertion is done
            // we check children of current root
            // if AVL is not met, meaning height difference
            // TODO: rotations
        } else if (compareResult > 0) {
            root.rtChild = insert(root.rtChild, x);
        }
        return root;
    }
    /**
     * private removal method that finds the given node and sets it deleted value to true
     *
     * @param root the root to search through
     * @param x the data value to search for
     */
    protected void remove(LazySTNode<E> root, E x) {
        int compareResult;
        try {
            if (root == null)
                throw new NoSuchElementException();
            compareResult = x.compareTo(root.data);
            if (compareResult < 0) {
                remove(root.lftChild, x);
            } else if (compareResult > 0) {
                remove(root.rtChild, x);
            } else if(!root.deleted) {
                root.deleted = true;
                mSize--;
            }
        } catch(NoSuchElementException e) {
            System.out.println("No Such Element");
            e.printStackTrace();
        }
    }
    /**
     * private traversal method that searches through every node in the tree
     * traverses through both deleted and non deleted nodes
     *
     * @param func the function used to print the node out
     * @param treeNode the current node being searched through
     */
    protected <F extends Traverser<? super E>> void traverseHard(F func, LazySTNode<E> treeNode) {
        if (treeNode == null)
            return;
        traverseHard(func, treeNode.lftChild);
        System.out.print(treeNode.data);
        traverseHard(func, treeNode.rtChild);
    }
    /**
     * private traversal method that searches through every non deleted node in the tree
     *
     * @param func the function used to print out the node
     * @param treeNode the current node being searched through
     */
    protected <F extends Traverser<? super E>> void traverseSoft(F func, LazySTNode<E> treeNode) {
        if (treeNode == null)
            return;
        traverseSoft(func, treeNode.lftChild);
        if(!treeNode.deleted) {
            System.out.print(treeNode.data);
        }
        traverseSoft(func, treeNode.rtChild);
    }
    /**
     * private find method that searches every node for a certain data
     *
     * @param root the root to search through
     * @param x the value we are searching for
     */
    protected LazySTNode<E> find(LazySTNode<E> root, E x) {
        int compareResult;  // avoid multiple calls to compareTo()
        if (root == null)
            return null;
        compareResult = x.compareTo(root.data);
        if (compareResult < 0)
            return find(root.lftChild, x);
        if (compareResult > 0)
            return find(root.rtChild, x);
        return root;   // found
    }
}
