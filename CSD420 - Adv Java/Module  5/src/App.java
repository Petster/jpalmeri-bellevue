/*
    Jason Palmeri
    5/27/22
    Assignment 5
    desc
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.net.URL;
import java.io.File;
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

    public static void main(String[] args) throws Exception {
        URL path = App.class.getResource("collection_of_words.txt");

        File f = new File(path.getFile());

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();

        ArrayList<String> fileList = new ArrayList<String>();

        while(line != null) {
            fileList.add(line);
            line = reader.readLine();
        }
        reader.close();

        System.out.println("--Original Array--");
        for(String i : fileList) {
            System.out.print(i + " ");
        }

        ArrayList<String> noDupe = removeDuplicates(fileList);

        Collections.sort(noDupe);
        System.out.println("\n--Sorted Ascending Order--");
        for(String i : noDupe) {
            System.out.print(i + " ");
        }
        Collections.sort(noDupe, Collections.reverseOrder());
        System.out.println("\n--Sorted Descending Order--");
        for(String i : noDupe) {
            System.out.print(i + " ");
        }
    }
}
