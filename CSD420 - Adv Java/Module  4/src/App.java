/*
    Jason Palmeri
    5/27/22
    Assignment 4
    store 50,000 and 500,000 integers and see how long it takes to traverse an array
*/

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static long iterateArray(LinkedList<Integer> array) {
        long startTime = System.currentTimeMillis();
        for(Integer i : array) {
            System.out.print(i);
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        return duration;
    }

    public static long getIndex(LinkedList<Integer> array) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        return duration;
    }

    public static long getIndexList(ArrayList<Integer> array) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        return duration;
    }

    public static LinkedList<Integer> createArray(int max) {
        LinkedList<Integer> newList = new LinkedList<Integer>();

        for(int i = 0; i < max; i++) {
            Random rand = new Random();
            newList.add(rand.nextInt(100));
        }

        return newList;
    }

    public static ArrayList<Integer> createArrayList(int max) {
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for(int i = 0; i < max; i++) {
            Random rand = new Random();
            newList.add(rand.nextInt(100));
        }

        return newList;
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> fiftyk = createArray(50000);
        ArrayList<Integer> fiftykList = createArrayList(50000);

        //iteration
        long duration = iterateArray(fiftyk);

        //.get(index)
        long durationGet = getIndexList(fiftykList);

        LinkedList<Integer> fivehunk = createArray(500000);
        ArrayList<Integer> fivehunkList = createArrayList(50000);

        //iteration
        long durationH = iterateArray(fivehunk);

        //.get(index)
        long durationHGet = getIndexList(fivehunkList);

        //output
        System.out.println("\n----------50,000----------");
        System.out.println("Iteration took " + duration + " millisecond(s) to complete");

        System.out.println("get(index) method took " + durationGet + " millisecond(s) to complete");

        System.out.println("\n----------500,000----------");
        System.out.println("Iteration took " + durationH + " millisecond(s) to complete");

        System.out.println("get(index) method took " + durationHGet + " millisecond(s) to complete");
    }
}
