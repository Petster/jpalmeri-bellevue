/*
    Jason Palmeri
    6/8/22
    Assignment 11
    Show an example use of the GSON library for parsing JSON
*/

import com.google.gson.*;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Reader;
import java.util.Map;

public class App {

    public static String writeJson() {
        String x = "";
        try {
            User myUser = new User("Jason", "Jason@Example.com", 22);
            Gson g = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter("test.json");

            g.toJson(myUser, writer);
            writer.flush();
            writer.close();

            x = g.toJson(myUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public static void readJson() {
        try {
            Gson g = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            Map<?, ?> myMap = g.fromJson(reader, Map.class);

            for(Map.Entry<?, ?> entry : myMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User createFromJson() {
        User newUser = new User();
        try {
            Gson g = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            newUser = g.fromJson(reader, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("--Creating User's JSON--");
            String output = writeJson();
            System.out.println("Output: " + output);

            System.out.println("--Reading User's JSON--");
            readJson();

            System.out.println("--Creating New User from User's JSON--");
            User newUser = createFromJson();
            System.out.println("New User Details:\nName: " + newUser.name + "\nEmail: " + newUser.email + "\nAge: " + newUser.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
