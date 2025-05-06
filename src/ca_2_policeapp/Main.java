package ca_2_policeapp;


import java.util.Scanner;

public class Main {
    private static PoliceStation policeStation;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializePoliceStation();
        applicantsForm();

        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                   // Sorted names
                    break;
                case 2:
                   //Search specific employee
                    break;
                case 3:
                    //Add new employees
                    break;
                case 4:
                    //Generate Random Employees
                    break;
                case 5:
                    //Display all the employees;
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
