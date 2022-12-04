
public class Personality {
    private final String firstName;
    private final String lastName;
    private final Integer year;

    public Personality(String firstName, String lastName, Integer year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Name : " + firstName + "| "
                + "Surname : " + lastName + " | "
                + " Year of birth : " + year;
    }

    public static class PersonalityBuilder {
        private String firstName;
        private String lastName;
        private Integer year;

        public PersonalityBuilder setName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonalityBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonalityBuilder setYear(Integer year) {
            this.year = year;
            return this;
        }

        public Personality build() {
            return new Personality(firstName, lastName, year);
        }
    }
}
