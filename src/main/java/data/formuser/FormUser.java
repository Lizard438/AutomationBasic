package data.formuser;

import java.util.Arrays;

public class FormUser {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;
    private final int age;
    private final int experience;
    private final Profession[] profession;
    private final Continent continent;
    private final SeleniumCommands[] commands;
    private final String filePath;
    private final String additional;

    public FormUser(String firstName, String lastName, String email, Gender gender, int age, int experience, Profession[] profession, Continent continent, SeleniumCommands[] commands, String filePath, String additional) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.experience = experience;
        this.profession = profession;
        this.continent = continent;
        this.commands = commands;
        this.filePath = filePath;
        this.additional = additional;
    }

    @Override
    public String toString() {
        return "FormUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", experience=" + experience +
                ", profession=" + Arrays.toString(profession) +
                ", continent=" + continent +
                ", commands=" + Arrays.toString(commands) +
                ", filePath='" + filePath + '\'' +
                ", additional='" + additional + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public Profession[] getProfession() {
        return profession;
    }

    public Continent getContinent() {
        return continent;
    }

    public SeleniumCommands[] getCommands() {
        return commands;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getAdditional() {
        return additional;
    }

    public enum Gender{
        MALE, FEMALE, OTHER
    }

    public enum Profession{
        MANUAL_TESTER, AUTOMATION_TESTER, OTHER
    }

    public enum Continent{
        ASIA ("Asia"),
        EUROPE ("Europe"),
        AFRICA ("Africa"),
        ANTARCTICA ("Antarctica"),
        NORTH_AMERICA ("North America"),
        SOUTH_AMERICA ("South America"),
        AUSTRALIA ("Australia");

        private final String value;

        public String getValue() {
            return value;
        }

        Continent(String value){
            this.value = value;
        }
    }

    public enum SeleniumCommands{
        BROWSER_COMMANDS ("browser-commands"),
        NAVIGATION_COMMANDS ("navigation-commands"),
        SWITCH_COMMANDS ("switch-commands"),
        WAIT_COMMANDS ("wait-commands"),
        WEB_ELEMENT_COMMANDS ("webelemet-commands");

        public String getValue() {
            return value;
        }

        private final String value;

        SeleniumCommands(String value){
            this.value = value;
        }
    }

}
