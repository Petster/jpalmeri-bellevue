/*
    Jason Palmeri
    3/18/22
    Assignment4
    ArrayList class to find the highest number
*/
import java.util.*;

class JasonArrayListTest {
    ArrayList<Integer> myList = new ArrayList<Integer>();

    public JasonArrayListTest(ArrayList<Integer> list) {
        myList = list;
    }

    public static Integer max(ArrayList<Integer> myList) {
        if(myList.size() > 0) {
            Integer Largest = Collections.max(myList);
            return Largest;
        } else {
            return 0;
        }
    }    
}

public class App {
    public static void main(String[] args) {
       Scanner userIn = new Scanner(System.in);
       
       ArrayList<Integer> userList = new ArrayList<Integer>();

       System.out.println("Enter Number One at a Time (0 to Exit)");
       int userNum = userIn.nextInt();
       while(userNum != 0) {
            userList.add(userNum);
            userNum = userIn.nextInt();
       }
       userList.add(0);

       JasonArrayListTest testOne = new JasonArrayListTest(userList);

       int largestNum = testOne.max(userList);
       System.out.println("The Largest Number you Submitted was " + largestNum);
    }
}
