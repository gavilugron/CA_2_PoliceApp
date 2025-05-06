package ca_2_policeapp;

public class Garda {
    private String name;

    public Garda(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

