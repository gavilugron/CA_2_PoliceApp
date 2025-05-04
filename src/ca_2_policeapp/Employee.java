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
    Unit unit;

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
    public enum Unit {
        SPECIAL_DETECTIVE_UNIT,
        PATROL,
        FORENSICS,
        HUMAN_RESOURCES,
        FINANCE,
        SECURITY_AND_INTELLIGENCE,
        ANTI_CORRUPTION_UNIT,
        NATIONAL_CYBER_CRIME_BUREAU
    }

    //Employee object
    public Employee(String name, Rank rank, Unit unit) {
        this.name = name;
        this.rank = rank;
        this.unit = unit;
    }
    // Compare employees alphabetically by name
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}

