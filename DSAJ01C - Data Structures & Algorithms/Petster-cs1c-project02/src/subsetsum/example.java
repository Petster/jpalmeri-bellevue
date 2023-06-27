package subsetsum;

import cs1c.TimeConverter;

import java.util.ArrayList;

/**
 * The Example class is me testing out a Dynamic Programming approach to the Subset Sum problem
 *
 * @author Foothill College, Jason Palmeri
 */
public class example {
    /**
     * findSubSet() method creates a dynamic programming table
     * to find the correct sublist that adds up to the target value
     *
     * This method is the practice problem from "An Algorithm"
     *
     * @param myList an ArrayList of Integers that act as the 10 random # between 3-20
     * @param target an Integer that acts as the sum of the subsets, given number was 37
     */
    public static ArrayList<Integer> findSubset(ArrayList<Integer> myList, int target) {
        boolean subsetTable[][] = new boolean[myList.size() + 1][target + 1];

        for(int i = 0; i <= myList.size(); i++) {
            subsetTable[i][0] = true;
        }

        for(int i = 1; i <= myList.size(); i++) {
            for(int j = 1; j <= target; j++) {
                if(j - myList.get(i-1) >= 0) {
                    subsetTable[i][j] = subsetTable[i-1][j] || subsetTable[i-1][j - myList.get(i-1)];
                } else {
                    subsetTable[i][j] = subsetTable[i-1][j];
                }
            }
        }

        //print out array for visualization
        for (boolean[] x : subsetTable)
        {
            for (boolean y : x)
            {
                if(y == true) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }

        if(!subsetTable[myList.size()][target]) {
            return new ArrayList<>();
        }
        ArrayList<Integer> subset = new ArrayList<>();
        int i = myList.size();
        int j = target;
        while (i > 0 && j > 0) {
            if (!subsetTable[i - 1][j]) {
                subset.add(myList.get(i - 1));
                j -= myList.get(i - 1);
            }
            i--;
        }
        return subset;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(9);
        myList.add(3);
        myList.add(12);
        myList.add(8);
        myList.add(6);
        myList.add(11);
        myList.add(4);
        myList.add(17);
        myList.add(20);

        long startTime, estimatedTime;

        startTime = System.nanoTime();
        ArrayList<Integer> purchases = findSubset(myList, 37);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("\nAlgorithm Elapsed Time: "
                + TimeConverter.convertTimeToString(estimatedTime));

        System.out.println(purchases);

        System.err.flush();
    }
}
