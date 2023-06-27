package week02_part02;

import java.util.ListIterator;

public class Practice {
    public static void main(String[] args) {
        FHlinkedList<String> myList = new FHlinkedList<>();

        myList.add(0, "Hey");
        myList.add(1, "Yo");
        myList.add(2, "What");
        myList.add(3, "Bang");
        myList.add(4, "Ding");
        myList.add(5, "Ow");

        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("--------------");

        System.out.println(myList.getFirst());

        System.out.println("--------------");

        System.out.println(myList.getLast());

        System.out.println("--------------");

        //System.out.println(myList.getNode());

        System.out.println("--------------");

        ListIterator<String> iter = myList.listIterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
