/*
    Jason Palmeri
    Assignment 7
    1/24/22
    Password String Checker

    A password must have at least eight characters.
    A password must contain both letters and digits.
    A password must contain at least one uppercase character.
    A password must contain at least one lowercase character.
*/
import java.util.Scanner;
public class App {

    static String passwordCheck(String pass) {
        String output = "";
        int passLength = pass.length();
        String numRegex   = ".*[0-9].*";
        String letRegex = ".*[A-Z].*";
        boolean containsUpper = false;
        boolean containsLower = false;

        for(int i = 0; i < passLength; i++) {
            if(containsUpper != true) {
                if(Character.isUpperCase(pass.charAt(i))) {
                    containsUpper = true;
                }
            }
            if(containsLower != true) {
                if(Character.isLowerCase(pass.charAt(i))) {
                    containsLower = true;
                }
            }
        }

        if(passLength < 8) {
            output = "Error: Password length is " + passLength + ", when it should be greater than 8";
        } else if(!pass.matches(numRegex) && !pass.matches(letRegex)) {
            output = "Error: Password does not contain both letters and numbers";
        } else if(containsUpper == false) {
            output = "Error: Password does not contain an Uppercase Letter";
        } else if(containsLower == false) {
            output = "Error: Password does not contain a Lowercase Letter";
        } else {
            output = "Password meets the requirements.";
        }
        return output;
    }

    public static void main(String[] args) {

        Scanner userin = new Scanner(System.in);
        System.out.println("Enter a Password");
        String Password = userin.nextLine();

        System.out.println(passwordCheck(Password));
    }
}
