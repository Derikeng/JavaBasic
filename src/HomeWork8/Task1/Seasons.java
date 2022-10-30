package HomeWork8.Task1;

public enum Seasons {
    WINTER("Snowy season", 90),
    SPRING("Periods of sunshine and rain", 92),
    SUMMER("Very hot season", 92),
    AUTUMN("Slush and every day it rains", 91);
private final String description;
private final int countOfDays;

    Seasons(String description, int countOfDays) {
        this.description = description;
        this.countOfDays = countOfDays;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public String getDescription() {
        return description;
    }
}
