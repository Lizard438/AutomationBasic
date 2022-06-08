package data.formuser;

public class FormUserBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private FormUser.Gender gender;
    private int age;
    private int experience;
    private FormUser.Profession[] profession;
    private FormUser.Continent continent;
    private FormUser.SeleniumCommands[] commands;
    private String filePath;
    private String additional;

    public FormUserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FormUserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FormUserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public FormUserBuilder gender(FormUser.Gender gender) {
        this.gender = gender;
        return this;
    }

    public FormUserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public FormUserBuilder experience(int experience) {
        this.experience = experience;
        return this;
    }

    public FormUserBuilder profession(FormUser.Profession... profession) {
        this.profession = profession;
        return this;
    }

    public FormUserBuilder continent(FormUser.Continent continent) {
        this.continent = continent;
        return this;
    }

    public FormUserBuilder commands(FormUser.SeleniumCommands... commands) {
        this.commands = commands;
        return this;
    }

    public FormUserBuilder filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public FormUserBuilder additional(String additional) {
        this.additional = additional;
        return this;
    }

    public FormUser build(){
        return new FormUser(
                firstName,
                lastName,
                email,
                gender,
                age,
                experience,
                profession,
                continent,
                commands,
                filePath,
                additional);
    }
}
