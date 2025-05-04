package ca_2_policeapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PoliceStation {
    private List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() throws IOException, IOException {
        loadApplicants();
        boolean running = true;
        while (running) {
            System.out.println("\nPlease select an option:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.getValue() + ". " + option);
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (MenuOption.fromValue(choice)) {
                case SORT:


            }

            private void newRecruits() throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("Applicants_Form.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(new Employee(line.trim(), null, null));
            }
            reader.close();
            System.out.println("Applicants loaded successfully.");
            }


}
