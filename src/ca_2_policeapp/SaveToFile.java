/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2_policeapp;


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
            File file = new File("Applicants_Form2.txt");
            FileWriter writer = new FileWriter(file);

            // Write header
            writer.write("firstName,lastName,gender,email,salary,unit,rank,position,station\n");

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
            System.out.println("Employee data saved to Applicants_Form.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}