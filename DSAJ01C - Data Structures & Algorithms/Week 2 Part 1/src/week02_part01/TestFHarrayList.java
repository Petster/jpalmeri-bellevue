package week02_part01;

import java.util.*;

public class TestFHarrayList
{
    public static void main (String[] args)
    {
        String[] words = {"When", "Harry", "Met", "Sally",
                "X", "Wild", "Beast", "X",
                "La", "Femme", "Nikita", "X", "Back", "To",
                "The", "Future", "X"};

        FHarrayList<String> myList = new FHarrayList<>();

        // Initialize myList
        for (String name : words)
            myList.add(name);

        // assume requestedVar has been initialized with input from the user
        int count = 0;
        ListIterator<String> iter;
        System.out.println("Enter the requested value to remove:");
        Scanner keyboard = new Scanner(System.in);
        String requestedVar = "When"; //keyboard.nextLine();
        System.out.println("Enter the number of items to remove:");
        int numberOfItemsToRemove = 3; //Integer.parseInt(keyboard.nextLine());
        for (iter = myList.listIterator(); iter.hasNext(); )
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

        for( String name : myList) {
            System.out.println(name);
        }
    }
}