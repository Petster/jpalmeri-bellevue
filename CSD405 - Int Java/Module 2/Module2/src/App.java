/*
    Jason Palmeri
    3/18/22
    Assignment2
    extend the fan class to create classes that accept objects and display them
*/

import java.util.*;

class Fan {
    final int STOPPED = 0;
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int Speed = STOPPED;

    private boolean On = false;

    private double Radius = 6;

    String Color = "White";

    public void setSpeed(int newVal) {
        Speed = newVal;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setOn(boolean newVal) {
        On = newVal;
    }

    public boolean getOn() {
        return On;
    }

    public void setRadius(double newVal) {
        Radius = newVal;
    }

    public double getRadius() {
        return Radius;
    }

    public void setColor(String newVal) {
        Color = newVal;
    }

    public String getColor() {
        return Color;
    }

    public Fan() {
        Speed = STOPPED;
        On = false;
        Radius = 6;
        Color = "White";
    }

    public Fan(int S, boolean O, double R, String C) {
        Speed = S;
        On = O;
        Radius = R;
        Color = C;
    }

    public String toString() {
        String powerStatus = "";
        String fanSpeed = "";
        switch(Speed) {
            case 0:
                fanSpeed = "Stopped";
                break;
            case 1:
                fanSpeed = "Slow";
                break;
            case 2:
                fanSpeed = "Medium";
                break;
            case 3:
                fanSpeed = "Fast";
                break;
        }
        if(On == true) {
            powerStatus = "On";
        } else {
            powerStatus = "Off";
        }
        return "The Fan's State is \nSpeed: " + fanSpeed + "\nPowered " + powerStatus + "\nFan Radius: " + Radius + "\nFan Color: " + Color + "";
    }
}
     
class UseFans extends Fan {
    public UseFans(Fan[] fanCol) {
        for(int i = 0; i < fanCol.length; i++) {
            String powerStatus = "";
            String fanSpeed = "";
            switch(fanCol[i].getSpeed()) {
                case 0:
                    fanSpeed = "Stopped";
                    break;
                case 1:
                    fanSpeed = "Slow";
                    break;
                case 2:
                    fanSpeed = "Medium";
                    break;
                case 3:
                    fanSpeed = "Fast";
                    break;
            }
            if(fanCol[i].getOn() == true) {
                powerStatus = "On";
            } else {
                powerStatus = "Off";
            }
            System.out.println("---------------------------------\nFan " + i + "'s State is \nSpeed: " + fanSpeed + "\nPowered " + powerStatus + "\nFan Radius: " + fanCol[i].getSpeed() + "\nFan Color: " + fanCol[i].getColor() + "");
        }
    }

    public UseFans(Fan singleFan) {
        String powerStatus = "";
        String fanSpeed = "";
        switch(singleFan.getSpeed()) {
            case 0:
                fanSpeed = "Stopped";
                break;
            case 1:
                fanSpeed = "Slow";
                break;
            case 2:
                fanSpeed = "Medium";
                break;
            case 3:
                fanSpeed = "Fast";
                break;
        }
        if(singleFan.getOn() == true) {
            powerStatus = "On";
        } else {
            powerStatus = "Off";
        }
        System.out.println("The Fan's State is \nSpeed: " + fanSpeed + "\nPowered " + powerStatus + "\nFan Radius: " + singleFan.getRadius() + "\nFan Color: " + singleFan.getColor() + "");
    }
}

public class App {
    public static void main(String[] args) {
        Fan[] fanArr;
        fanArr = new Fan[4];
        for(int i = 0; i < fanArr.length; i++) {
            String[] colorArr = {"White", "Red", "Orange", "Blue", "Purple", "Black"};
            Random rand = new Random();
            int randomint = rand.nextInt(4);
            boolean randombool = rand.nextBoolean();
            double randomdoub = rand.nextDouble(100.0);
            int randomcolor = rand.nextInt(colorArr.length);

            fanArr[i] = new Fan(randomint, randombool, randomdoub, colorArr[randomcolor]);
        }
        
        System.out.println("---------Fan Collection---------");
        UseFans fanCollection = new UseFans(fanArr);

        System.out.println("---------Single Fan---------");
        Fan single = new Fan(fanArr[2].getSpeed(), fanArr[2].getOn(), fanArr[2].getRadius(), fanArr[2].getColor());
        UseFans singleFan = new UseFans(single);


    }
}
