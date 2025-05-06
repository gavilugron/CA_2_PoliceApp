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
                    // sortAndDisplayNames();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    addNewEmployee();
                    break;
                case 4:
                    generateRandomEmployees();
                    break;
                case 5:
                    displayAllEmployees();
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

