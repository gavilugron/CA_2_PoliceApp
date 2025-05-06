/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2_policeapp;

/**
 *
 * @author gvilu
 */
public class Employee {
    // Setting attributes of the Employee class
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private Unit unit;
    private Rank rank;
    private String position;
    private String station;

    // Constructor for new employees
    public Employee(String firstName, String lastName, String gender, String email,
                    double salary, Unit unit, Rank rank, String position, String station) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.unit = unit;
        this.rank = rank;
        this.position = position;
        this.station = station;
    }

}

