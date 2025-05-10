/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.*;
/**
 *
 * @author gvilu
 */

public class PoliceStation {
    private SaveToFile<Employee> employees;
    private ArrayList<Rank> ranks;
    private ArrayList<Unit> units;
    private ArrayList<String> positions;
    private ArrayList<String> stations;
    //Array List of employees
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

    // Getter methods for employees
    public SaveToFile<Employee> getEmployees() {
        return employees;
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

    //Method to randomize employees
    public void generateRandomEmployees(int count) {
        Random random = new Random();
        String[] firstNames =
                {
                        "JOHN", "EMMA", "LIAM", "OLIVIA", "NOAH", "AVA", "ELIJAH", "SOPHIA",
                        "WILLIAM", "MIA", "JAMES", "CHARLOTTE", "BENJAMIN", "AMELIA", "LUCAS",
                        "ISABELLA", "HENRY", "EVELYN", "ALEXANDER", "HARPER", "LIAM", "NOAH", "JAMES", "DANIEL", "JACK",
                        "MICHAEL", "MATTHEW", "CONNOR", "SEAN", "RYAN", "KEVIN", "PATRICK", "BRENDAN", "DYLAN", "AIDAN", "EOIN",
                        "CIARAN", "SHANE", "COLIN", "NIALL", "EMMA", "SOPHIE", "AOIFE", "SARAH", "GRACE", "EMILY", "CHLOE", "KATIE",
                        "ELLA", "LEAH", "AMY", "NIAMH", "ANNA", "EIMEAR", "CAOIMHE", "RACHEL", "LAURA", "ORLA", "SIOBHAN", "ROISIN"

                };
        String[] lastNames =
                {
                        "MURPHY", "BYRNE", "WALSH", "OCONNOR", "DOYLE", "MCCARTHY", "GALLAGHER", "DUNNE", "FITZGERALD", "KELLY",
                        "OBRIEN", "FLYNN", "SHEEHAN", "KAVANAGH", "MURRAY", "QUINN", "KEANE", "BRADY", "REILLY", "CLARKE",
                        "LYNCH", "CASEY", "HAYES", "POWER", "NOLAN", "KENNEDY", "HUGHES", "CAHILL", "BRENNAN", "MAGUIRE",
                        "BOYLE", "MOORE", "MORAN", "FARRELL", "CARROLL", "GREENE", "HEALY", "COLLINS", "REDMOND", "FINN", "MCGRATH",
                        "OLOUGHLIN", "SCANLON", "BURKE", "CONNOLLY", "MULCAHY", "MCLOUGHLIN", "OCRAIG", "DEVLIN", "SULLIVAN",
                        "MCMAHON", "OFLAHERTY", "MCNAMARA", "OCEALLAIGH", "OHEHIR", "COSTELLO", "HANNIGAN", "KIRWAN", "MCGOVERN", "OQUINN",
                        "MAHONY", "MULVIHILL", "OHALEY", "CREGAN", "FITZPATRICK", "OHOULIHAN", "OCRAINE", "DELANEY", "LEE"

                };
        String[] genders = {"Male", "Female"};
        String[] positions =
                {
                        "Patrol Officer", "Detective", "Specialist", "Supervisor", "Administrator",
                        "Crime Prevention Officer", "Scenes of Crime Officer", "Immigration Officer",
                        "Training Instructor", "Garda National Drugs and Organised Crime Bureau Officer"
                };
        String[] stations = {"Dublin", "Cork", "Galway", "Limerick", "Waterford"};

        for (int i = 0; i < count; i++) {
            String firstName = firstNames[random.nextInt(firstNames.length)].toUpperCase();
            String lastName = lastNames[random.nextInt(lastNames.length)].toUpperCase();
            String gender = genders[random.nextInt(genders.length)].toUpperCase();
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@garda.ie";

            // salary between €3000 and €10000
            double salary = 3000 + random.nextInt(10000);

            Rank rank = ranks.get(random.nextInt(ranks.size()));
            Unit unit = units.get(random.nextInt(units.size()));
            String position = positions[random.nextInt(positions.length)].toUpperCase();
            String station = stations[random.nextInt(stations.length)].toUpperCase();

            employees.add(new Employee(firstName, lastName, gender, email, salary, unit, rank, position, station));
        }
    }
}

