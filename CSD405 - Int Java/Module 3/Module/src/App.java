/*
    Jason Palmeri
    3/18/22
    Assignment3
    Create a class titled Integer
*/

import java.util.*;

class TheInteger {
    int Jason;

    public TheInteger() {
        Jason = 1;
    }

    public TheInteger(int n) {
        Jason = n;
    }

    public void setJason(int newVal) {
        Jason = newVal;
    }

    public int getJason() {
        return Jason;
    }

    public boolean isEven() {
        if(Jason % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOdd() {
        if(Jason % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isPrime() {
        boolean flag = false;
        for(int i = 2; i <= Jason / 2; ++i) {
            if(Jason % i == 0) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEven(int n) {
        if(n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOdd(int n) {
        if(n % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPrime(int n) {
        boolean flag = false;
        for(int i = 2; i <= n / 2; ++i) {
            if(n % i == 0) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEven(Integer n) {
        if(n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOdd(Integer n) {
        if(n % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPrime(Integer n) {
        boolean flag = false;
        for(int i = 2; i <= n / 2; ++i) {
            if(n % i == 0) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(int n) {
        Integer one = Integer.valueOf(Jason);
        Integer two = Integer.valueOf(n);
        if(one.equals(two)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Integer n) {
        Integer one = Integer.valueOf(Jason);
        Integer two = Integer.valueOf(n);
        if(one.equals(two)) {
            return true;
        } else {
            return false;
        }
    }
}

class DisplayInt extends TheInteger {
    public DisplayInt(TheInteger n) {
            Random rand = new Random();
            int maxR = 100;
            int randomInt = rand.nextInt(maxR);
            System.out.println("Is Even: " + n.isEven());
            System.out.println("Is Odd: " + n.isOdd());
            System.out.println("Is Prime: " + n.isPrime());
            System.out.println(randomInt + " Is Static Even? " + TheInteger.isEven(randomInt));
            System.out.println(randomInt + " Is Static Odd? " + TheInteger.isOdd(randomInt));
            System.out.println(randomInt + " Is Static Prime? " + TheInteger.isPrime(randomInt));
            System.out.println(randomInt + " Is Static Even Integer? " + TheInteger.isEven(randomInt));
            System.out.println(randomInt + " Is Static Odd Integer? " + TheInteger.isOdd(randomInt));
            System.out.println(randomInt + " Is Static Prime Integer? " + TheInteger.isPrime(randomInt));
            System.out.println(randomInt + " Equals? " + n.equals(randomInt));
            System.out.println(randomInt + " Equals Integer? " + n.equals(randomInt));
    }
}

public class App {
    public static void main(String[] args) {
       TheInteger testOne = new TheInteger(15);
       TheInteger testTwo = new TheInteger(15);
       TheInteger testThree = new TheInteger(2);

       System.out.println("-----Test 1-----");
       DisplayInt o = new DisplayInt(testOne);

       System.out.println("-----Test 2-----");
       DisplayInt t = new DisplayInt(testTwo);

       System.out.println("-----Test 3-----");
       DisplayInt th = new DisplayInt(testThree);
    }
}
