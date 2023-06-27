/*
    Jason Palmeri
    Assignment 9
    1/29/22
    create an array of 20 integers, find highest num, lowest, average, sum
*/

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random randNum = new Random();
        int masterArray[] = new int[20];
        int highest = 0;
        int lowest = 500;
        int average = 0;
        int sum = 0;

        for(int i = 0; i < 20; i++) {
            int tempRand = randNum.nextInt(500);
            masterArray[i] = tempRand;
            //System.out.println(tempRand);
        }

        for(int i = 0; i < masterArray.length; i++) {
            sum += masterArray[i];
            if(masterArray[i] > highest) {
                highest = masterArray[i];
            }
            if(masterArray[i] < lowest) {
                lowest = masterArray[i];
            }
        }
        average = sum / masterArray.length;

        System.out.println("Highest Number: " + highest + "\nLowest Number: " + lowest + "\nAverage: " + average + "\nSum: " + sum);
    }
}
