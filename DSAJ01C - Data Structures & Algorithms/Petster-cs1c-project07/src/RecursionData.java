/**
 * A class for storing the results of the quicksort algorithm, storing the current size, increment, and average time
 *
 * @author Jason Palmeri
 * */
public class RecursionData {
    private int arraySize;
    private int recursionIncrement;
    private long avgTime;

    /**
     * constructs a new RecursionData object with given values
     *
     * @param arraySize the size of the current array
     * @param recursionIncrement the current iteration (in steps of 2)
     * @param avgTime the average time to sort
     * */
    public RecursionData(int arraySize, int recursionIncrement, long avgTime) {
        this.arraySize = arraySize;
        this.recursionIncrement = recursionIncrement;
        this.avgTime = avgTime;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int getRecursionIncrement() {
        return recursionIncrement;
    }

    public void setRecursionIncrement(int recursionIncrement) {
        this.recursionIncrement = recursionIncrement;
    }

    public long getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(long avgTime) {
        this.avgTime = avgTime;
    }
}
