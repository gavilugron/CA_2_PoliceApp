/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2_policeapp;

/**
 *
 * @author gvilu
 */
public class Employee implements Comparable<Employee> {
    String name;
    Rank rank;
    Department department;

    //Enum options for Ranks
    public enum Rank {
        COMMISSIONER,
        DEPUTY_COMMISSIONER,
        ASSISTANT_COMMISSIONER,
        CHIEF_SUPERINTENDENT,
        SUPERINTENDENT,
        INSPECTOR,
        SERGEANT,
        GARDA
    }
    // Enum options for Departments
    public enum Department {
        INVESTIGATIONS,
        PATROL,
        FORENSICS,
        RH,
        ACCOUNTANT,
        SPY
    }
    //Employee object
    public Employee(String name, Rank rank, Department department) {
        this.name = name;
        this.rank = rank;
        this.department = department;
    }
    // Compare employees alphabetically by name
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}

