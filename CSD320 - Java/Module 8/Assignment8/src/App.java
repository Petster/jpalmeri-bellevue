/*
    Jason Palmeri
    Assignment 8
    1/25/22
    Multiple Methods with different needs
    -yearlyService(no parameters) - Will return the standard service charge.
    -yearlyService(one parameter) - Will return the standard service charge with an added oil change fee.
    -yearlyService(two parameters) - Will return the standard service charge with an added oil change fee and a tire rotation charge.
    -yearlyService(three parameters) - Will return the standard service charge with an added oil change fee, a tire rotation charge, along with a coupon amount that will be deducted from the total cost.
*/

import java.util.Random;

public class App {

    static double yearlyService() {
        return 150.00;
    }

    static double yearlyService(double x) {
        return 150.00 + x;
    }

    static double yearlyService(double x, double y) {
        return 150.00 + x + y;
    }

    static double yearlyService(double x, double y, double z) {
        double price = (150.00 + x + y) - z;
        return price;
    }
    public static void main(String[] args) {
        Random randNum = new Random();
        double maxOil, maxTire, maxCoupon;

        for(int i = 0; i < 2; i++) {
            maxOil = randNum.nextDouble(150.00);
            maxTire = randNum.nextDouble(200.00);
            maxCoupon = randNum.nextDouble(50.00);
            System.out.println("Oil Cost: $" + String.format("%.2f", maxOil) + " | Tire Cost: $" + String.format("%.2f", maxTire) + " | Coupon: $" + String.format("%.2f", maxCoupon));
            System.out.println("Service Charge: $" + String.format("%.2f", yearlyService()));
            System.out.println("Service Charge + Oil Change: $" + String.format("%.2f", yearlyService(maxOil)));
            System.out.println("Service Charge + Oil Change + Tire Rotation: $" + String.format("%.2f", yearlyService(maxOil, maxTire)));
            System.out.println("Service Charge + Oil Change + Tire Rotation (with coupon): $" + String.format("%.2f", yearlyService(maxOil, maxTire, maxCoupon)));
            System.out.println();
        }
    }
}
