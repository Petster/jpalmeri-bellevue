/*
    Jason Palmeri
    Assignment 10
    1/29/22
    four overloaded methods
*/

import java.util.Random; 

public class App {

    public static int average(int [] array) {
        int sum = 0;
        String output = "[";
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(i == array.length-1) {
                output += array[i] + "]";
            } else {
                output += array[i] + ", ";
            }
        }
        int avg = sum / array.length;
        System.out.println("Int Array:");
        System.out.println(output);
        return avg;
    }

    public static long average(long [] array) {
        long sum = 0;
        String output = "[";
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(i == array.length-1) {
                output += array[i] + "]";
            } else {
                output += array[i] + ", ";
            }
        }
        long avg = sum / array.length;
        System.out.println("Long Array:");
        System.out.println(output);
        return avg;
    }

    public static double average(double [] array) {
        double sum = 0.0;
        String output = "[";
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(i == array.length-1) {
                output += array[i] + "]";
            } else {
                output += array[i] + ", ";
            }
        }
        double avg = sum / array.length;
        System.out.println("Double Array:");
        System.out.println(output);
        return avg;
    }

    public static int average(short [] array) {
        int sum = 0;
        String output = "[";
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(i == array.length-1) {
                output += array[i] + "]";
            } else {
                output += array[i] + ", ";
            }
        }
        int avg = sum / array.length;
        System.out.println("Short Array:");
        System.out.println(output);
        return avg;
    }
    public static void main(String[] args) {
        Random randNum = new Random();
        double dArray[] = new double[10];
        long lArray[] = new long[15];
        int iArray[] = new int[20];
        short sArray[] = new short[25];

        for(int i = 0; i < 25; i++) {
            if(i < 20) {
                int tempRandI = randNum.nextInt(500);
                iArray[i] = tempRandI;
            }
            if(i < 15) {
                long tempRandL = randNum.nextLong();
                lArray[i] = tempRandL;
            }
            if(i < 10) {
                double tempRandD = randNum.nextDouble(500.00);
                dArray[i] = tempRandD;
            }
            short tempRandS = (short) randNum.nextInt((Short.MAX_VALUE - Short.MIN_VALUE) + Short.MAX_VALUE);
            sArray[i] = tempRandS;
        }

        System.out.println("Average: " + average(iArray) + "\n");
        System.out.println("Average: " + average(dArray) + "\n");
        System.out.println("Average: " + average(lArray) + "\n");
        System.out.println("Average: " + average(sArray) + "\n");


    }
}
