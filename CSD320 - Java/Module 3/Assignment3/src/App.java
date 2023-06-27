/*
    Jason Palmeri
    Assignment 3
    1/7/22
    Plays a game of rock paper scissor with the user
*/
import java.util.Scanner;

public class App {

    static String rpsMove(String num) {
        String result = "";
        switch(num) {
            case "1":
                result = "Rock";
                break;
            case "2":
                result = "Paper";
                break;
            case "3":
                result = "Scissors";
                break;  
        }
        return result;
    }

    static int calcWinner(int comp, int user) {
        int winner = 0;
        if(comp == user) {
            winner = 3;
        } else {
            switch(user) {
                case 1:
                    if(comp == 2) {
                        winner = 0;
                    } else {
                        winner = 1;
                    }
                    break;
                case 2:
                    if(comp == 1) {
                        winner = 0;
                    } else {
                        winner = 1;
                    }
                    break;
                case 3:
                    if(comp == 3) {
                        winner = 0;
                    } else {
                        winner = 1;
                    }
                    break;
            }
        }

        return winner;
    }

    public static void main(String[] args) {
        int compMove = (int)(Math.random() * 3 + 1);

        System.out.println("Rock Paper Scissors Game");
        System.out.println("1: Rock | 2: Paper | 3: Scissors");

        //user input
        Scanner userIn = new Scanner(System.in);
        int userMove = 0;
        
        //make sure its a valid number
        while(userMove < 1 || userMove > 3) {
            System.out.println("Your Move:");
            userMove = userIn.nextInt();
        }

        userIn.close();
        //turn move into actual string version
        String compMoveS = rpsMove(String.valueOf(compMove));
        String userMoveS = rpsMove(String.valueOf(userMove));

        System.out.println("Computers Move: " + compMoveS);
        System.out.println("Your Move: " + userMoveS);

        //calculate winner
        int winner = calcWinner(compMove, userMove);

        if(winner == 1) {
            System.out.println("You Win!");
        } else if(winner == 3) {
            System.out.println("It's a Tie!");
        } else {
            System.out.println("You Lost!");
        }
    }
}
