/*
    Jason Palmeri
    5/29/22
    Assignment 6
    write two methods that bubble sort an array, 1 using the comparable interface, and the other using the comparator interface.
*/

import java.util.Random;
import java.util.Comparator;
import java.util.Collections;

public class App {
    public static Integer[] createArray(int max) {
        Integer[] newList = new Integer[max];

        for(int i = 0; i < max; i++) {
            Random rand = new Random();
            newList[i] = rand.nextInt(100);
        }

        return newList;
    }

    public static <E> void displayList(E[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static String randomLetter() {
        Random rand = new Random();

        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int randInt = rand.nextInt(chars.length());
        String sub = "";
        if(randInt > chars.length()) {
            sub = chars.substring(randInt-2, randInt-1);
        } else if(randInt < chars.length()) {
            sub = chars.substring(randInt+1, randInt+2);
        }

        return sub;
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped = true;

        for(int i = 1; i < list.length && swapped; i++) {
            swapped = false;
            for(int j = 0; j < list.length - i; j++) {
                if(comparator.compare(list[j], list[j+1]) > 0) {
                    //System.out.println("Comparing " + list[j] + " to " + list[j+1] + " = " + comparator.compare(list[j], list[j+1]));
                    E temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;

                    swapped = true;
                    //displayList(list);
                    //System.out.println("");
                }
            }
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        bubbleSort(list, (x, y) -> ((Comparable<E>)x).compareTo(y));
    }
    public static void main(String[] args) {
        Integer[] myArray = createArray(20);

        System.out.println("--Original Array--");
        displayList(myArray);

        System.out.println("\n--Sorted Array w/ Comparator--");
        bubbleSort(myArray);
        displayList(myArray);

        String[] myArray2 = new String[20];
        for(int i = 0; i < 20; i++) {
            myArray2[i] = randomLetter();
        }

        System.out.println("\n--Original Array2--");
        for(int i = 0; i < myArray2.length; i++) {
            System.out.print(myArray2[i] + " ");
        }

        System.out.println("\n--Sorted Array w/ Comparable--");
        bubbleSort(myArray2, (x, y) -> x.compareToIgnoreCase(y));
        displayList(myArray2);
    }
}
