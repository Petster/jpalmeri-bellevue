package week01_part02;

import java.util.Scanner;

public class TestBoxes
{
    public static void main(String [] args)
    {
        BoundedBox<Double> packet = new BoundedBox<Double>();
        while(true)
        {
            System.out.println("Enter a number to store in the box or '0' to quit:");
            Scanner keyboard = new Scanner(System.in);
            double input = keyboard.nextDouble();
            if (input == 0)
                break;
            packet.setData(input);
            System.out.println(packet);
            System.out.println("Is odd number stored: " + packet.isOdd());
        }

        // Testing type which is bounded by instance Comparable
        int [] var = new int[5];
        BoundedComparableBox[] ballots = new BoundedComparableBox[3];
        ballots[0] = new BoundedComparableBox<String>("Cricket");
        ballots[1] = new BoundedComparableBox<String>("Alice");
        ballots[2] = new BoundedComparableBox<String>("Rumple");

        // print the ballots
        System.out.println("Before sorting the ballots:");
        for(BoundedComparableBox<String> voter : ballots)
        {
            System.out.println(voter.toString());
        }

        // sort the ballots
        BoundedComparableBox<String> currentSmallest = ballots[0];
        if (currentSmallest.amILarger(ballots[1]))
        {
            currentSmallest = ballots[1];
            ballots[1] = ballots[0];
            ballots[0] = currentSmallest;
        }
        if (currentSmallest.amILarger(ballots[2]))
        {
            currentSmallest = ballots[2];
            ballots[2] = ballots[1];
            ballots[1] = currentSmallest;
        }

        // print the ballots
        System.out.println("After sorting the ballots:");
        for(BoundedComparableBox<String> voter : ballots)
        {
            System.out.println(voter);
        }

        System.out.println("done.");
    }
}
