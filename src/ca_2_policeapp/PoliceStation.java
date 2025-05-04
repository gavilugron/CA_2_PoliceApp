package ca_2_policeapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class PoliceStation {
    private final List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() throws IOException, IOException {
        loadApplicants();
        //boolean running = true;
        while (true) {
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
            BufferedReader reader = new BufferedReader(new FileReader("New_Recruits.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(new Employee(line.trim(), null, null));
            }
            reader.close();
            System.out.println("New Recruits loaded successfully.");
            }

            
            // Non-recursive binary search on String
            MyArrayList<String> mylist2;
            mylist2 = new MyArrayList<String>();

            mylist2.add("United States");
            mylist2.add("Ireland");
            mylist2.add("China");
            mylist2.add("Sweden");
            mylist2.add("Norway");
            mylist2.add("Finland");
            mylist2.add("Denmark");
            mylist2.add("Germany");
            mylist2.add("France");
            mylist2.add("Austria");

            // Sorting the String list before binary search
            int pos;
            Collections.sort(mylist2);

            String key3 = "Norway";

            //startTime = System.nanoTime();
            pos = mylist2.binarySearch_nonRecursive(key3, 0, mylist2.size() - 1);
            //endTime = System.nanoTime();
            //System.out.println("Non-recursive search (String) took " + (endTime - startTime) + " ns");

            if (pos == -1) {
                System.out.println("The country name using Binary search non recursive : " + key3 + " NOT found!");
            } else {
                System.out.println("The country name using Binary search non recursive : " + key3 + " found at position " + pos + "!");
            }

}
