/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2_policeapp;
import java.util.*;
/**
 *
 * @author gvilu
 */

ppublic class PoliceStation {
    private SaveToFile<Employee> employees;
    private ArrayList<Rank> ranks;
    private ArrayList<Unit> units;
    private ArrayList<String> positions;
    private ArrayList<String> stations;

    public PoliceStation(ArrayList<Rank> ranks, ArrayList<Unit> units, ArrayList<String> positions, ArrayList<String> stations) {
        this.employees = new SaveToFile<>();
        this.ranks = ranks;
        this.units = units;
        this.positions = positions;
        this.stations = stations;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Rank> getRanks() {
        return ranks;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public Rank findRankByName(String name) {
        for (Rank rank : ranks) {
            if (rank.getName().equalsIgnoreCase(name)) {
                return rank;
            }
        }
        return null;
    }

    public Unit findUnitByName(String name) {
        for (Unit unit : units) {
            if (unit.getName().equalsIgnoreCase(name)) {
                return unit;
            }
        }
        return null;
    }

    public SaveToFile<Employee> getEmployees() {
        return employees;
    }

    public void generateRandomEmployees(int count) {
        Random random = new Random();
        String[] firstNames = {"John", "Mary", "Patrick", "Aoife", "Michael", "Siobhan", "James", "Emma", "Daniel", "Sarah"};
        String[] lastNames = {"Murphy", "Kelly", "O'Sullivan", "Walsh", "Smith", "O'Brien", "Byrne", "Ryan", "O'Connor", "O'Neill"};
        String[] genders = {"Male", "Female"};
        String[] positions = {"Patrol Officer", "Detective", "Specialist", "Supervisor", "Administrator"};
        String[] stations = {"Dublin", "Cork", "Galway", "Limerick", "Waterford"};

        for (int i = 0; i < count; i++) {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String gender = genders[random.nextInt(genders.length)];
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@garda.ie";
            double salary = 30000 + random.nextInt(70000);
            Rank rank = ranks.get(random.nextInt(ranks.size()));
            Unit unit = units.get(random.nextInt(units.size()));
            String position = positions[random.nextInt(positions.length)];
            String station = stations[random.nextInt(stations.length)];

            employees.add(new Employee(firstName, lastName, gender, email, salary, unit, rank, position, station));
        }
    }
}