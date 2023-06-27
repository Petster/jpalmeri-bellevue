//import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        double FinalIn = 0;
        double WaterIn = 0;
        double InitialIn = 0;

        String Water = JOptionPane.showInputDialog(null, "Enter Amount of Water (kg)", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
        WaterIn = Double.parseDouble(Water);

        String Initial = JOptionPane.showInputDialog(null, "Enter Initial Temperature", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
        InitialIn = Double.parseDouble(Initial);
        
        while(FinalIn <= InitialIn) {
            String Final = JOptionPane.showInputDialog(null, "Enter Final Temperature", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
            FinalIn = Double.parseDouble(Final);
        }

        double result = (WaterIn * (FinalIn - InitialIn) * 4184);

        String finalResult = "Energy Needed to Heat " + WaterIn + " kg of Water From an Initial Heat of " + InitialIn + " to a Final Heat of " + FinalIn + " Would be " + result + " Joules.";

        JOptionPane.showMessageDialog(null, finalResult, "Result", JOptionPane.INFORMATION_MESSAGE);

        /*
        original code
        System.out.println("Temperature Timer");

        Scanner Water = new Scanner(System.in);
        Scanner Initial = new Scanner(System.in);
        Scanner Final = new Scanner(System.in);
        double FinalIn = 0;
        double WaterIn = 0;
        double InitialIn = 0;

        System.out.println("Amount of Water (kg):");
        WaterIn = Water.nextDouble();

        System.out.println("Initial Temperature:");
        InitialIn = Initial.nextDouble();

        while(FinalIn <= InitialIn) {
            System.out.println("Final Temperature:");
            FinalIn = Final.nextDouble();
        }

        double result = (WaterIn * (FinalIn - InitialIn) * 4184);

        System.out.println("Energy Needed to Heat " + WaterIn + " kg of Water From an Initial Heat of " + InitialIn + " to a Final Heat of " + FinalIn + " Would be " + result + " Joules.");
    */
}
}
