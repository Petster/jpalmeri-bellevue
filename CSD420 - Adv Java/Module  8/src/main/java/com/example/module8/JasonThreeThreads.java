package com.example.module8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Random;
import java.lang.Character;
import java.lang.Thread;

import java.io.IOException;

class letterThread extends JasonThreeThreads implements Runnable {
    public static String randomLetter() {
        Random rand = new Random();

        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int randInt = rand.nextInt(chars.length());

        char sub = chars.charAt(randInt);

        return Character.toString(sub);
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            String let = randomLetter();
            //System.out.println(Thread.currentThread().getName() + " (" + i + ")" + " : " + let);
            letterString += let;
        }
        //System.out.println(letterString);

        System.out.println(Thread.currentThread().getName() + " is now complete");
    }
}

class numberThread extends JasonThreeThreads implements Runnable {
    public static int randomNumber() {
        Random rand = new Random();

        int randInt = rand.nextInt(0, 9);

        return randInt;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            int num = randomNumber();
            //System.out.println(Thread.currentThread().getName() + " (" + i + ")" + " : " + num);
            numberString += num;
        }
        System.out.println(Thread.currentThread().getName() + " is now complete");
    }
}

class symbolThread extends JasonThreeThreads implements Runnable {
    public static String randomSymbol() {
        Random rand = new Random();

        String chars = "!@#$%^&*()_+-=`~[]{}\\|'\";:?/>.<,";

        int randInt = rand.nextInt(chars.length());

        char sub = chars.charAt(randInt);

        return Character.toString(sub);
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            String sym = randomSymbol();
            //System.out.println(Thread.currentThread().getName() + " (" + i + ")" + " : " + randomSymbol());
            symbolString += sym;
        }
        System.out.println(Thread.currentThread().getName() + " is now complete");
    }
}

public class JasonThreeThreads extends Application {
    public static String letterString = "";
    public static String numberString = "";
    public static String symbolString = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JasonThreeThreads.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Jason Palmeri - Module 8");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        letterThread lt = new letterThread();
        numberThread nt = new numberThread();
        symbolThread st = new symbolThread();

        Thread lThread = new Thread(lt);
        Thread nThread = new Thread(nt);
        Thread sThread = new Thread(st);

        lThread.setName("Thread 1");
        nThread.setName("Thread 2");
        sThread.setName("Thread 3");

        lThread.start();
        lThread.join();
        //System.out.println(letterString);

        nThread.start();
        nThread.join();
        //System.out.println(numberString);

        sThread.start();
        sThread.join();
        //System.out.println(symbolString);

        launch();
    }
}