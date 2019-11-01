package edu.cscc;
import java.util.Scanner;

/* Corey Capelle , 10/29/2019, Lab 8 - Body Mass Index: Application used to
 calculate BMI and used to categorize whether a person’s weight is at a healthy weight for a given height.
*/

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";


    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String classification;

        System.out.println("Calculate BMI");
        lbs = inputWeight();
        inches = inputHeight();

        //Print statements for debugging.
        //System.out.println("Your weight is " + lbs + " lbs");
        //System.out.println("Your height is " + inches + " inches");

        //populate variables used to calculate BMI from below methods
        kgs = convertToKilograms(lbs);
        meters = convertToMeters(inches);
        bmi = calcBMI(kgs, meters);
        classification = bmiClassification(bmi);

        //print out calculated BMI, and bmi classification (handled in methods below)
        System.out.println("Your BMI is: " + bmi);
        System.out.println("Your BMI classification is " + classification);

    }

    //method to validate input for weight and return upon valid entry
    public static double inputWeight() {
        String lbsInput;
        Double weightDouble = 0.0;

        System.out.println("Please enter your weight (in lbs): ");
        do {
            try {
                lbsInput = input.nextLine();
                weightDouble = Double.parseDouble(lbsInput);

            } catch (Exception e) {

            }
            if (weightDouble <= 0) {
                System.out.println(INPUT_ERROR);
            }
        } while (weightDouble <= 0);


        return weightDouble;
    }

    //method to validate input for height and return upon valid entry
    public static double inputHeight() {
        String inchesInput;
        Double heightDouble = 0.0;

        System.out.println("Please enter your height (in inches): ");
        do {
            try {
                inchesInput = input.nextLine();
                heightDouble = Double.parseDouble(inchesInput);

            } catch (Exception e) {

            }
            if (heightDouble <= 0) {
                System.out.println(INPUT_ERROR);
            }
        } while (heightDouble <= 0);


        return heightDouble;
    }

    //method to convert pounds to kilograms
    private static Double convertToKilograms(Double pounds) {
        double kilos;
        kilos = pounds / 2.2046;
        return kilos;
    }

    //method to convert inches to meters
    private static Double convertToMeters(Double Ins) {
        double meters;
        meters = Ins / 39.37;
        return meters;
    }

    //method to calculate bmi
    private static Double calcBMI(Double kilos, Double ms) {
        double bodyMassIndex;
        bodyMassIndex = kilos / (ms * ms);
        return bodyMassIndex;
    }

    //method to determine bmi classification from bmi calculation, and return a string
    private static String bmiClassification (Double bmi) {
        String bmiToString = "";

        if (bmi < 18.5)
            bmiToString = "Underweight";
        else if (bmi < 25.0)
            bmiToString = "Normal";
        else if (bmi < 30.0)
            bmiToString = "Overweight";
        else if (bmi >= 30.0)
            bmiToString = "Obese";

        return bmiToString;
    }
}