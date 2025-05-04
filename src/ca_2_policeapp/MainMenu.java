package ca_2_policeapp;
//Implementing Enum for Main menu options
public enum MainMenu {
    SORT(1),
    SEARCH(2),
    ADD_RECORDS(3),
    GENERATE_RANDOM(4),
    EXIT(5);


    private final int value;
    MainMenu(int value) { this.value = value; }
    public int getValue() { return value; }

    public static MainMenu fromValue(int value) {
        for (MainMenu option : values()) {
            if (option.value == value) return option;
        }
        throw new IllegalArgumentException("Invalid option: " + value);
    }
}
