/**
 * A quicksort algorithm from course_examples
 *
 * @author Jason Palmeri
 * */
public class FHsort {
    protected static int QS_RECURSION_LIMIT = 15;

    /**
     * Sorts the specified array using the insertion sort algorithm.
     *
     * @param a The array to sort.
     */
    public static < E extends Comparable< ? super E > > void insertionSort(E[] a) {
        int k, pos, arraySize;
        E tmp;

        arraySize = a.length;
        for(pos = 1; pos < arraySize; pos++ )
        {
            tmp = a[pos];
            for(k = pos; k > 0 && tmp.compareTo(a[k-1]) < 0; k-- )
                a[k] = a[k-1];
            a[k] = tmp;
        }
    }

    /**
     * Sorts the specified array using the shell sort algorithm
     *
     * @param a The array to sort.
     * */
    public static < E extends Comparable< ? super E > > void shellSort1(E[] a) {
        int gap = 1;
        int k, pos, arraySize;
        E tmp;

        arraySize = a.length;
        for (gap = arraySize/2;  gap > 0;  gap /= 2)
            for(pos = gap; pos < arraySize; pos++ )
            {
                tmp = a[pos];
                for(k = pos; k >= gap && tmp.compareTo(a[k-gap]) < 0; k = k - gap )
                    a[k] = a[k-gap];
                a[k] = tmp;
            }
    }

    /**
     * Merges the specified subarrays of the client array into the working array.
     *
     * @param client The array to be sorted.
     * @param working The array to hold the merged subarrays.
     * @param leftPos The index of the start of the first subarray.
     * @param rightPos The index of the end of the first subarray.
     * @param rightStop The index of the end of the second subarray.
     * */
    protected static < E extends Comparable< ? super E > > void merge(E[] client, E[] working, int leftPos, int rightPos, int rightStop) {
        int leftStop, workingPos, arraySize;

        workingPos = leftPos;
        leftStop = rightPos - 1;
        arraySize = rightStop - leftPos + 1;

        // as soon as we reach the end of either input array, stop
        while(leftPos <= leftStop && rightPos <= rightStop)
            if(client[leftPos].compareTo(client[rightPos]) < 0 )
                working[workingPos++] = client[leftPos++];
            else
                working[workingPos++] = client[rightPos++];

        // merge is over; copy the remainder of one or the other input array
        while(leftPos <= leftStop)
            working[workingPos++] = client[leftPos++];
        while( rightPos <= rightStop )
            working[workingPos++] = client[rightPos++];

        // copy back into client array
        for( ; arraySize > 0; arraySize--, rightStop-- )
            client[rightStop] = working[rightStop];
    }

    /**
     * Sorts the specified array using the merge sort algorithm.
     *
     * @param a The array to be sorted.
     * @param working The array to hold the merged subarrays.
     * @param start The index of the start of the array.
     * @param stop The index of the end of the array.
     */
    protected static < E extends Comparable< ? super E > > void mergeSort(E[] a, E[] working, int start, int stop) {
        int rightStart;

        if (stop - start < 1)
            return;

        rightStart = (start + stop)/2 + 1;
        mergeSort(a, working, start, rightStart - 1);
        mergeSort(a, working, rightStart, stop);
        merge(a, working, start, rightStart, stop);
    }

    /**
     * Sorts the specified array using the merge sort algorithm.
     *
     * @param a The array to be sorted.
     */
    public static < E extends Comparable< ? super E > > void mergeSort(E[] a) {
        if (a.length < 2)
            return;

        E[] working = (E[])new Comparable[a.length];
        mergeSort(a, working, 0, a.length - 1);
    }

    /**
     * Moves the element at the specified hole down the heap until it is in the correct position.
     *
     * @param a The heap.
     * @param hole The index of the element to move.
     * @param arraySize The size of the heap.
     */
    protected static < E extends Comparable< ? super E > > void percolateDown(E[] a, int hole, int arraySize) {
        int child;
        E tmp;

        for( tmp = a[hole]; 2 * hole + 1 < arraySize; hole = child )
        {
            child = 2 * hole + 1;
            // if 2 children, get the GREATER of the two (because MAX heap)
            if( child < arraySize - 1 && a[child].compareTo(a[child + 1]) < 0)
                child++;
            if( tmp.compareTo(a[child]) < 0 )   // MAX heap, not min heap
                a[hole] = a[child];
            else
                break;
        }
        a[hole] = tmp;
    }

    /**
     * Sorts the specified array using the heap sort algorithm.
     *
     * @param a The array to be sorted.
     */
    public static < E extends Comparable< ? super E > > void heapSort(E[] a) {
        int k, arraySize;
        E temp;

        // order the array using percolate down
        arraySize = a.length;
        for(k = arraySize/2; k >= 0; k-- )
            percolateDown(a, k, arraySize);

        // now remove the max element (root) and place at end of array
        for(k = arraySize - 1; k > 0; k-- )
        {
            // "remove" by placing at end of array
            temp = a[0];
            a[0] = a[k];
            a[k] = temp;
            percolateDown( a, 0, k );  // k represents the shrinking array size
        }
    }

    /**
     * Finds the median of the three elements at the specified indices in the array.
     *
     * @param a The array.
     * @param left The index of the first element.
     * @param right The index of the last element.
     * @return The median of the three elements.
     */
    protected static < E extends Comparable< ? super E > > E median3(E[] a, int left, int right) {
        int center;
        E tmp;

        // swaps are done in-line for speed;  each compound line is a swap
        center = (left + right) / 2;
        if(a[center].compareTo(a[left]) < 0)
        { tmp = a[center]; a[center] = a[left]; a[left] = tmp; }
        if(a[right].compareTo(a[left]) < 0)
        { tmp = a[right]; a[right] = a[left]; a[left] = tmp; }
        if(a[right].compareTo(a[center]) < 0)
        { tmp = a[right]; a[right] = a[center]; a[center] = tmp; }

        tmp = a[center]; a[center] = a[right-1]; a[right-1] = tmp;

        return a[right - 1];
    }

    /**
     * Sets the recursion limit for the QuickSort algorithm.
     *
     * @param newLim The new recursion limit.
     * @return True if the new recursion limit was set successfully, false otherwise.
     */
    public static boolean setRecursionLimit(int newLim) {
        if (newLim < 2 || newLim > 1000)
            return false;
        QS_RECURSION_LIMIT = newLim;
        return true;
    }

    /**
     * Sorts the specified array using the QuickSort algorithm.
     *
     * @param a The array to be sorted.
     * @param left The index of the first element.
     * @param right The index of the last element.
     */
    protected static < E extends Comparable< ? super E > > void quickSort(E[] a, int left, int right) {
        E pivot, tmp;
        int i, j;

        if( left + QS_RECURSION_LIMIT <= right ) {
            pivot = median3(a, left, right);
            for(i = left, j = right - 1; ; )
            {
                while( a[++i].compareTo(pivot) < 0 )   ;
                while( pivot.compareTo(a[--j]) < 0) ;
                if(i < j)
                { tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp; }

                else break;
            }

            // restore pivot
            tmp = a[i]; a[i] = a[right - 1]; a[right - 1] = tmp;

            // recursive calls on smaller sub-groups
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
        else
            // non-recursive escape valve - insertion sort
            insertionSort(a, left, right);
    }

    /**
     * Sorts the specified array using the insertion sort algorithm.
     * @param a The array to be sorted.
     * @param start The index of the first element.
     * @param stop The index of the last element.
     * */
    protected static < E extends Comparable< ? super E > > void insertionSort(E[] a, int start, int stop) {
        int k, pos;
        E tmp;

        // we are not testing for ranges to keep times down - private so ok
        for(pos = start + 1; pos <= stop; pos++ )
        {
            tmp = a[pos];
            for(k = pos; k > 0 && tmp.compareTo(a[k-1]) < 0; k-- )
                a[k] = a[k-1];
            a[k] = tmp;
        }
    }

    /**
     * Sorts the specified array using the QuickSort algorithm.
     *
     * @param a The array to be sorted.
     */
    public static < E extends Comparable< ? super E > > void quickSort( E[] a ) {
        quickSort(a, 0, a.length - 1);
    }
}