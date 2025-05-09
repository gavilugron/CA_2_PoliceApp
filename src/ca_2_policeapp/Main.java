package ca_2_policeapp;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    enum MenuOption {
        SORT_AND_DISPLAY("Sort and display first 20 names from \"Applicants_Form.txt\" file"),
        SEARCH_EMPLOYEE("Search for an employee"),
        ADD_EMPLOYEE("Add new employee"),
        GENERATE_RANDOM("Generate random employees"),
        DISPLAY_ALL("Display all employees"),
        SAVE_TO_FILE("Save sorted names to Applicants_Form.txt file"),
        EXIT("Exit");

        private final String description;

        MenuOption(String description) {
            this.description = description.toUpperCase();
        }

        public String getDescription() {
            return description;
        }
    }
    private static PoliceStation policeStation;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializePoliceStation();
        applicantsForm();

        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getIntInput("Select an option between 1-7: ");
            MenuOption selected = MenuOption.values()[choice - 1];

            switch (selected) {
                case SORT_AND_DISPLAY:
                    sortAndDisplayFirst20();
                    break;
                case SEARCH_EMPLOYEE:
//                    searchEmployee
                    break;
                case ADD_EMPLOYEE:
//                    addNewEmployee
                    break;
                case GENERATE_RANDOM:
//                    generateRandomEmployees
                    break;
                case DISPLAY_ALL:
//                    displayAllEmployees
                    break;
                case SAVE_TO_FILE:
//                    saveSortedNamesToFile;
                    break;
                case EXIT:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializePoliceStation() {
        // Initialize ranks
        ArrayList<Rank> ranks = new ArrayList<>();
        ranks.add(new Rank("COMMISSIONER"));
        ranks.add(new Rank("DEPUTY COMMISSIONER"));
        ranks.add(new Rank("ASSISTANT COMMISSIONER"));
        ranks.add(new Rank("CHIEF SUPERINTENDENT"));
        ranks.add(new Rank("SUPERINTENDENT"));
        ranks.add(new Rank("INSPECTOR"));
        ranks.add(new Rank("SERGEANT"));
        ranks.add(new Rank("GARDA"));

        // Initialize units
        ArrayList<Unit> units = new ArrayList<>();
        units.add(new Unit("PATROL UNIT"));
        units.add(new Unit("TRAFFIC UNIT"));
        units.add(new Unit("NARCOTICS UNIT"));
        units.add(new Unit("CRIME PREVENTION"));
        units.add(new Unit("CYBER CRIME"));
        units.add(new Unit("SPECIAL DETECTIVE UNIT"));
        units.add(new Unit("MAYOR CRIMES"));
        units.add(new Unit("SPECIAL OPERATIONS UNIT"));

        initializePositionsAndStations();
        policeStation = new PoliceStation(ranks, units, positions, stations);
    }

    private static ArrayList<String> positions;
    private static ArrayList<String> stations;

    private static void initializePositionsAndStations() {
        positions = new ArrayList<>();
        positions.add("PATROL OFFICER");
        positions.add("DETECTIVE");
        positions.add("SPECIALIST");
        positions.add("SUPERVISOR");
        positions.add("ADMINISTRATOR");
        positions.add("CRIME PREVENTION OFFICER");
        positions.add("SCENES OF CRIME OFFICER");
        positions.add("IMMIGRATION OFFICER");
        positions.add("TRAINING INSTRUCTOR");

        stations = new ArrayList<>();
        stations.add("DUBLIN");
        stations.add("CORK");
        stations.add("GALWAY");
        stations.add("LIMERICK");
        stations.add("WATERFORD");
    }

    private static void applicantsForm() {
        try {
            File file = new File("Applicants_Form.txt");
            Scanner fileScanner = new Scanner(file);

            // Skip header line
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 9) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String gender = parts[2].trim();
                    String email = parts[3].trim();
                    double salary;
                    try {
                        salary = Double.parseDouble(parts[4].replace("€", "").trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping entry due to invalid salary format: " + parts[4]);
                        break;
                    }
                    String unitName = parts[5].trim();
                    String rankName = parts[6].trim();
                    String position = parts[7].trim();
                    String station = parts[8].trim();
                    Unit unit = policeStation.findUnitByName(unitName);
                    Rank rank = policeStation.findRankByName(rankName);

                    if (unit != null && rank != null) {
                        policeStation.addEmployee(new Employee(firstName, lastName, gender, email, salary, unit, rank, position, station));
                    }
                }
            }
            fileScanner.close();
            System.out.println("Initial data loaded successfully from Applicants_Form.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Applicants_Form.txt not found. Starting with empty employee list.");
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n------------------ GARDA SÍOCHÁNA ------------------- \n-------------- HUMAN RESOURCES MANAGER --------------");
        for (int i = 0; i < MenuOption.values().length; i++) {
            System.out.printf((i + 1) + ". " + MenuOption.values()[i].getDescription() + "\n");
        }
    }
    //Sort and Display 1st 20 from Applicants Form
    private static void sortAndDisplayFirst20() {
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            File file = new File("Applicants_Form.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 9) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String gender = parts[2].trim();
                    String email = parts[3].trim();
                    double salary = 0;
                    try {
                        salary = Double.parseDouble(parts[4].replace("€", "").trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format: " + parts[4] + " . \nPlease write a valid salary:");
                    }
                    String rankName = parts[5].trim();
                    String unitName = parts[6].trim();
                    String position = parts[7].trim();
                    String station = parts[8].trim();
                    Rank rank = policeStation.findRankByName(rankName);
                    Unit unit = policeStation.findUnitByName(unitName);
//                        loadInitialData();

                    if (rank != null && unit != null) {
                        employees.add(new Employee(firstName, lastName, gender, email, salary, unit, rank, position, station));
                    }
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Applicants_Form.txt not found.");
            return;
        }

        if (employees.isEmpty()) {
            System.out.println("No employees to sort.");
            return;
        }

        // Bubble Sort by first name
        for (int i = 0; i < employees.size() - 1; i++) {
            for (int j = 0; j < employees.size() - i - 1; j++) {
                if (employees.get(j).getFirstName().compareToIgnoreCase(employees.get(j + 1).getFirstName()) > 0) {
                    Employee temp = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n----- First 20 Sorted Employees from Applicants_Form.txt-----");
        for (int i = 0; i < Math.min(20, employees.size()); i++) {
            System.out.println("--------------------------------------------------------");
            System.out.println("EMPLOYEE NUMBER: " + (i + 1));
            System.out.println("--------------------------------------------------------");
            System.out.println("Name: " + employees.get(i).getFullName() + "\n Gender: " + employees.get(i).getGender()
                    + "\n Email: " + employees.get(i).getEmail() + "\n Salary: " + employees.get(i).getSalary()
                    + "\n Unit:" + employees.get(i).getUnit() + "\n Rank: " + employees.get(i).getRank() + "\n Position: "
                    + employees.get(i).getPosition() + "\n Station: " + employees.get(i).getStation() +
                    "\n--------------------------------------------------------");
        }
    }
//  Sort and Display 1st 20 using App Data
//        private static void sortAndDisplayFirst20() {
//            ArrayList<Employee> employees = new ArrayList<>();
//
//            try {
//                File file = new File("Applicants_Form.txt");
//                Scanner fileScanner = new Scanner(file);
//
//                while (fileScanner.hasNextLine()) {
//                    String line = fileScanner.nextLine();
//                    String[] parts = line.split(",");
//
//                    if (parts.length >= 9) {
//                        String firstName = parts[0].trim();
//                        String lastName = parts[1].trim();
//                        String gender = parts[2].trim();
//                        String email = parts[3].trim();
//                        double salary = 0;
//                        try {
//                            salary = Double.parseDouble(parts[4].replace("€", "").trim());
//                        } catch (NumberFormatException e) {
//                            System.out.println("Invalid salary format: " + parts[4] + " . \nPlease write a valid salary:");
//                        }
//                        String rankName = parts[5].trim();
//                        String unitName = parts[6].trim();
//                        String position = parts[7].trim();
//                        String station = parts[8].trim();
//                        Rank rank = policeStation.findRankByName(rankName);
//                        Unit unit = policeStation.findUnitByName(unitName);
//                        loadInitialData();
//
//                        if (rank != null && unit != null) {
//                            employees.add(new Employee(firstName, lastName, gender, email, salary, unit, rank, position, station));
//                        }
//                    }
//                }
//                fileScanner.close();
//            } catch (FileNotFoundException e) {
//                System.out.println("Applicants_Form.txt not found.");
//                return;
//            }
//
//            if (employees.isEmpty()) {
//                System.out.println("No employees to sort.");
//                return;
//            }
//
//            // Bubble Sort by first name
//            for (int i = 0; i < employees.size() - 1; i++) {
//                for (int j = 0; j < employees.size() - i - 1; j++) {
//                    if (employees.get(j).getFirstName().compareToIgnoreCase(employees.get(j + 1).getFirstName()) > 0) {
//                        Employee temp = employees.get(j);
//                        employees.set(j, employees.get(j + 1));
//                        employees.set(j + 1, temp);
//                    }
//                }
//            }
//
//            System.out.println("\n----- First 20 Sorted Employees from Applicants_Form.txt-----");
//            for (int i = 0; i < Math.min(20, employees.size()); i++) {
//                System.out.println("--------------------------------------------------------");
//                System.out.println("EMPLOYEE NUMBER: " + (i + 1));
//                System.out.println("--------------------------------------------------------");
//                System.out.println("Name: " + employees.get(i).getFullName() + "\n Gender: " + employees.get(i).getGender() + "\n Email: " + employees.get(i).getEmail() + "\n Salary: " + employees.get(i).getSalary() + "\n Unit:" + employees.get(i).getUnit()
//                        + "\n Rank: " + employees.get(i).getRank() + "\n Position: " + employees.get(i).getPosition() + "\n Station: " + employees.get(i).getStation() +
//                        "\n--------------------------------------------------------");
//            }
//        }
// Search an employee by typing the 1st name
    private static void searchEmployee() {
        System.out.print("\nEnter first name to search: ");
        String name = scanner.nextLine().trim();

        ArrayList<Employee> employees = policeStation.getEmployees();
        if (employees.isEmpty()) {
            System.out.println("There are no records, please add some employees first.");
            return;
        }

        // Copy and sort the employee list
        BubbleSort<Employee> employeeArray = new BubbleSort<>();
        employeeArray.addAll(employees);
        employeeArray.bubbleSort();

        // Call binary search with corrected bounds
        int index = employeeArray.binarySearchRecursive(name, 0, employeeArray.size() - 1);

        if (index != -1) {
            Employee found = employeeArray.get(index);
            System.out.println("--------------------------------------------------------");
            System.out.println("EMPLOYEE FOUND: ");
            System.out.println("--------------------------------------------------------");
            System.out.println("Name: " + found.getFullName());
            System.out.println("Rank: " + found.getRank().getName());
            System.out.println("Unit: " + found.getUnit().getName());
            System.out.println("Position: " + found.getPosition());
            System.out.println("Station: " + found.getStation());
            System.out.println("Email: " + found.getEmail());
            System.out.println("Salary: €" + found.getSalary());
        } else {
            System.out.println("--------------------------------------------------------");
            System.out.println("EMPLOYEE NOT FOUND: " + name);
            System.out.println("--------------------------------------------------------");
        }
    }
