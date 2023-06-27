package stacks;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * A testing grounds for StackList and the Navigator class
 * to ensure all methods work properly
 *
 * @author Foothill College, Jason Palmeri
 */
public class example {
    /**
     * Creates an object of type StackList and Navigator to verify
     * that their methods work properly
     * @param args default params
     */
    public static void main(String[] args) {
        System.out.println("---Creating StackList---");
        StackList<String> myList = new StackList<>("myList");
        Iterator<String> iter = myList.iterator();
        System.out.println("---Is Empty?---");
        System.out.println(myList.isEmpty());
        System.out.println(myList);

        System.out.println("---Pushing Elements---");
        myList.push("Hey");
        myList.push("Hi");
        myList.push("Hello");
        myList.push("Yo");
        myList.push("Hai");

        System.out.println("---Is Empty?---");
        System.out.println(myList.isEmpty());
        System.out.println(myList);

        System.out.println("---Popping Element---");
        myList.pop();
        System.out.println(myList);

        System.out.println("---Iterating List---");
        iter = myList.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println(myList);

        System.out.println("---Removing 'Hello' via Iteration---");
        iter = myList.iterator();
        while(iter.hasNext()) {
            String temp = iter.next();
            if(temp.equals("Hello")) {
                iter.remove();
            }
        }
        System.out.println(myList);

        System.out.println("---Iterating Modified List---");
        iter = myList.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println(myList);
    }
}
