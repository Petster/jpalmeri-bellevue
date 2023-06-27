/*
    Jason Palmeri
    3/18/22
    Assignment1
    create a fan class that has setters and getters
*/

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

public class App {
    public static void main(String[] args) {
        Fan fanOne = new Fan();
        System.out.println(fanOne.toString());
        System.out.println("-----------------");
        Fan fanTwo = new Fan(2, true, 12.0, "Purple");
        System.out.println(fanTwo.toString());
    }
}
