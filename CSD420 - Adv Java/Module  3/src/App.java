/*
    Jason Palmeri
    5/25/22
    Assignment 3
    method that returns a new array list with no duplicates
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {       
        ArrayList<E> sortedArray = new ArrayList<E>();

        for(E element : list) {
            if(!sortedArray.contains(element)) {
                sortedArray.add(element);
            }
        }

        return sortedArray;
    }

    public static char randomLetter() {
        Random rand = new Random();

        String chars = "abcdefghijklmnopqrstuvwxyz";

        int randInt = rand.nextInt(chars.length());
        char randChar = chars.charAt(randInt);

        return randChar;
    }

    public static <E> void displayList(ArrayList<E> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int x = 0;

        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        while(x < 50) {
            int num = rand.nextInt(1, 21);
            unsortedArray.add(num);
            x++;
        }

        System.out.println("Original List:");

        Collections.sort(unsortedArray);

        displayList(unsortedArray);

        ArrayList<Integer> sortedArray = removeDuplicates(unsortedArray);

        Collections.sort(sortedArray);

        System.out.println("\nNew List:");

        displayList(sortedArray);

        //since the method is generic I created a arraylist of random characters to demonstrate.

        System.out.println("\nOriginal Char List:");

        ArrayList<Character> unsortedChar = new ArrayList<Character>();
        x = 0;

        while(x < 50) {
            char let = randomLetter();
            unsortedChar.add(let);
            x++;   
        }

        Collections.sort(unsortedChar);

        displayList(unsortedChar);

        ArrayList<Character> sortedChar = removeDuplicates(unsortedChar);

        System.out.println("\nSorted Char List:");

        Collections.sort(sortedChar);

        displayList(sortedChar);

    }
}
