/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author gvilu
 */
public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private Unit unit;
    private Rank rank;
    private String position;
    private String station;

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
    //Methods to access to the attributes of the employee
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public String getEmail()
    {
        return email;
    }

    public double getSalary()
    {
        return salary;
    }

    public Unit getUnit()
    {
        return unit;
    }

    public Rank getRank()
    {
        return rank;
    }

    public String getPosition()
    {
        return position;
    }

    public String getStation()
    {
        return station;
    }

    // To string method
    @Override
    public String toString() {
        return "Name: " + getFullName() + "\n" +
                "Gender: " + gender + "\n" +
                "Email: " + email + "\n" +
                "Salary: €" + salary + "\n" +
                "Rank: " + rank.getName() + "\n" +
                "Unit: " + unit.getName() + "\n" +
                "Position: " + position + "\n" +
                "Station: " + station;
    }
    // Compare to method
    @Override
    public int compareTo(Employee o) {

        return this.firstName.compareTo(o.firstName);
    }
}

