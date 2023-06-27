/*
    Jason Palmeri
    3/18/22
    Assignment5
    Create 2 programs
    1: Try/Catch Example
    2: File System Writing
*/

import java.util.*;
import java.io.*;

//https://www.logicbig.com/how-to/code-snippets/jcode-java-random-random-words.html
class RandomWord {
    public String createRandomWord(int len) {
        String name = "";
        for (int i = 0; i < len; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + 'a' - 1);
            name += c;
        }
        return name;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        int choice = 1;
        while(choice != 3) {
            System.out.println("1: Program One (ArrayList)\n2: Program Two (File System)\n3: Exit");
            System.out.print("Select a Program: ");
            choice = userIn.nextInt();
            switch(choice) {
                case 1:
                    ProgramOne();
                    break;
                case 2:
                    ProgramTwo();
                    break;
            }
        }
        System.exit(0);
    }

    public static void ProgramOne() {
        System.out.println("-----Program 1-----");
        ArrayList<String> stringList = new ArrayList<String>();

        //create random words
        RandomWord newWord = new RandomWord();
        for (int i = 0; i < 10; i++) {
            String randomWord = newWord.createRandomWord(6);
            stringList.add(randomWord);
        }

        //display words
        int id = 0;
        for (String string : stringList) {
            System.out.println(id + ": " + string);
            id++;
        }

        //user input
        Scanner userIn = new Scanner(System.in);
        System.out.print("Select a Word: ");
        String selectedWord = userIn.nextLine();
        try {
            if(stringList.contains(selectedWord)) {
                System.out.println("Found: " + selectedWord);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Out of Bounds!");
        }
    }

    public static void ProgramTwo() {
        System.out.println("-----Program 2-----");
        String filePath = "Module 5/Module/src/data.file";
        try {
            System.out.println("Creating File...");
            FileOutputStream newFile = new FileOutputStream(filePath, false);
            //create random words
            String wordsAdd = "";
            RandomWord newWord = new RandomWord();
            for (int i = 0; i < 10; i++) {
                String randomWord = newWord.createRandomWord(6);
                if(i == 9) {
                    wordsAdd += randomWord;
                } else {
                    wordsAdd += randomWord + "\n";
                }
            }
            byte[] b = wordsAdd.getBytes();
            newFile.write(b);
            newFile.close();
            System.out.println("File Created...");
            System.out.println("Opening File...");
            File myFile = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            int r = 0;
            while ((r = reader.read()) != -1) {
                System.out.print((char) r);
            }
            System.out.println("\nEnd...");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
