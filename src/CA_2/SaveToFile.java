/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gvilu
 */

public class SaveToFile<SaveToFile> extends ArrayList<SaveToFile> {
    public void saveSortedNamesToFile() {
        try {
            File file = new File("Applicants_Form.txt");

            // Check if the file already exists to decide whether to write the header
            boolean isNewFile = !file.exists();

            // Open in append mode
            FileWriter writer = new FileWriter(file, true);

            // Write header only if it's a new file
            if (isNewFile) {
                writer.write("firstName,lastName,gender,email,salary,unit,rank,position,station\n");
            }

            for (SaveToFile item : this) {
                if (item instanceof Employee) {
                    Employee emp = (Employee) item;
                    writer.write(emp.getFirstName() + "," +
                            emp.getLastName() + "," +
                            emp.getGender() + "," +
                            emp.getEmail() + "," +
                            "€" + String.format("%.2f", emp.getSalary()) + "," +
                            emp.getUnit().getName() + "," +
                            emp.getRank().getName() + "," +
                            emp.getPosition() + "," +
                            emp.getStation() + "\n");
                }
            }

            writer.close();
            System.out.println("New Employee data appended to Applicants_Form.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}