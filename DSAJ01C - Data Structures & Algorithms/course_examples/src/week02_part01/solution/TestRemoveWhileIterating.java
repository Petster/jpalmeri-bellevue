package week02_part01.solution;

import java.util.ListIterator;
import java.util.Scanner;

public class TestRemoveWhileIterating
{
    public static void printArrayList(FHarrayList<String> list)
    {
        for (String elem : list)
            System.out.print(elem + ", ");
        System.out.println("\n");
    }

    public static void main(String [] args)
    {
        String[] words = {"When", "Harry", "Met", "Sally",
                "X", "Wild", "Beast", "X",
                "La", "Femme", "Nikita", "X", "Back", "To",
                "The", "Future", "X"};

        FHarrayList<String> myList = new FHarrayList<>();

        // Initialize myList
        for (String name : words)
            myList.add(name);
        System.out.println("Contents of list before remove:");
        printArrayList(myList);


        // assume requestedVar has been initialized with input from the user
        int count = 0;
        ListIterator<String> iter;
        System.out.println("Enter the requested value to remove:");
        Scanner keyboard = new Scanner(System.in);
        String requestedVar = keyboard.nextLine();
        // Note: Assume valid user input
        System.out.println("Enter number of items to remove:");
        int numberOfItemsToRemove = Integer.parseInt(keyboard.nextLine());
        for (iter = myList.listIterator(); iter.hasNext();  )
        {
            if (iter.next().equals(requestedVar))
            {
                iter.remove();
            }
            if (count++ > numberOfItemsToRemove)
            {
                myList.remove(count);
            }
        }

        System.out.println("Contents of list after remove:");
        printArrayList(myList);
    }
}
