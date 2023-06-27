package subsetsum;

import cs1c.SongEntry;

import java.util.ArrayList;

/**
 * The SubsetSum class contains methods to find the SubsetSum of a provided list, and target
 *
 * @author Foothill College, Jason Palmeri
 */
public class SubsetSum {
    /**
     *  findSubset() method finds a subset of items that sum up to the budget.
     *  first finds out if the budget is greater than the sum of shoppingList
     *  if not we find all subsets of shoppingList, checking each sum of subsets
     *  to find one that is equal to budget, and if not checking if it is less than
     *  the budget and greater than the previously largest sum.
     *
     * @param shoppingList an ArrayList of doubles that act as a price for items
     * @param budget a double number that acts as the sum
    */
    public static ArrayList<Double> findSubset(ArrayList<Double> shoppingList, double budget) {
        // initialize the Collection of subsets, the largest available subset, and some constant values
        ArrayList<ArrayList<Double>> Col = new ArrayList<>();
        ArrayList<Double> largestCol = new ArrayList<>();
        double largestColSum = 0;
        double shoppingListSum = 0;
        int shoppingListSize = shoppingList.size();

        // check if budget is 0; if so return an empty array
        if (budget == 0) {
            return largestCol;
        }

        // calculate the sum of all shopping list items
        for(double price : shoppingList) {
            shoppingListSum += price;
        }

        // check if the budget is greater than or equal to the sum of shopping list items
        // if so; return the entire list
        if(budget >= shoppingListSum) {
            return shoppingList;
        }

        // A double nested for loop to go through each element in the shoppinglist
        // for each element in the shopping list create a temporary sublist, and a temporary sum of the sublist
        // the inner for loop goes through each element in the shopping list again creating sublists for each element
        // finally we check if the tempSum == budget, in which case we return the tempSubset
        // if not we check if it is the largest subset, and add it to the largestCollection
        // and if the tempSum is less than the budget add it to the Collection (to make sure we don't store higher subset sums)
        for(int i = 0; i < (1 << shoppingListSize); i++) {
            ArrayList<Double> tempSubSet = new ArrayList<>();
            double tempSum = 0;
            for(int j = 0; j < shoppingListSize; j++) {
                if((i & (1 << j)) > 0) {
                    tempSubSet.add(shoppingList.get(j));
                    tempSum += shoppingList.get(j);
                }
            }
            if(tempSum == budget) {
                return tempSubSet;
            }
            if(tempSum < budget && tempSum > largestColSum) {
                largestCol.clear();
                largestColSum = tempSum;
                largestCol = tempSubSet;
            }
            if(tempSum < budget) {
                Col.add(tempSubSet);
            }
        }

        // At this point there was no exact match, so we will return the largest Collection
        return largestCol;
    }

    /**
     *  findSubsetOfSongs() method finds a subset of SongEntry durations() that sum up to the duration.
     *  This approach uses Dynamic Programming to create a table of True or False values
     *  to find the correct subset of SongEntry's
     *
     * @param songList an ArrayList of SongEntry's
     * @param duration the playlist duration to look for
     */
    public static ArrayList<SongEntry> findSubsetOfSongs(ArrayList<SongEntry> songList, double duration) {
        // initiailize a totalDuration of all the song durations()
        double totalDuration = 0;
        for (SongEntry song : songList) {
            totalDuration += song.getDuration();
        }

        // pre-check to ensure we don't do unnecessary work, return the whole list if duration >= totalDuration
        if (duration >= totalDuration) {
            return songList;
        }

        // create our 2D boolean Array, with songList.size() rows, and duration columns
        boolean[][] subsetTable = new boolean[songList.size() + 1][(int) Math.ceil(duration) + 1];

        // set the 0 0 column to true
        for(int i = 0; i <= songList.size(); i++) {
            subsetTable[i][0] = true;
        }

        // a double nested for loop, with an outer loop going through each songList SongEntry (the rows)
        // the second for loop goes through the duration individually (1, 2, 3) (the columns)
        // then we check if j - current song duration >= 0 (5000 - 234 >= 0)
        // if this is true we set the current tables position to either its above value (if true)
        // or we set it to the value of the above value, j-songduration to the left
        // if the statement is false, we set it equal to its above value
        // This part can be visualized from my example.java class that prints out the True and False table
        for (int i = 1; i <= songList.size(); i++) {
            for(int j = 1; j <= (int) Math.ceil(duration); j++) {
                if(j - songList.get(i-1).getDuration() >= 0) {
                    subsetTable[i][j] = subsetTable[i-1][j] || subsetTable[i-1][j-songList.get(i-1).getDuration()];
                } else {
                    subsetTable[i][j] = subsetTable[i-1][j];
                }
            }
        }

        // check that the bottom right value of the table is false; if so return nothing because there was no match
        if(!subsetTable[songList.size()][(int) Math.ceil(duration)]) {
            return new ArrayList<>();
        }

        // not we work backwards, from the bottom right of the array to find the subset
        ArrayList<SongEntry> subset = new ArrayList<>();
        int i = songList.size();
        int j = (int) Math.ceil(duration);
        while(i > 0 && j > 0) {
            if(!subsetTable[i-1][j]) {
                subset.add(songList.get(i-1));
                j -= songList.get(i-1).getDuration();
            }
            i--;
        }

        // finally return the subset that we found by going backwards
        return subset;
    }
}
