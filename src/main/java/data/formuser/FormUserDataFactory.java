package data.formuser;

import com.github.javafaker.Faker;
import com.github.javafaker.Options;

import java.io.IOException;
import java.nio.file.Files;

import static data.formuser.FormUser.Profession.AUTOMATION_TESTER;
import static data.formuser.FormUser.Profession.MANUAL_TESTER;
import static data.formuser.FormUser.SeleniumCommands.*;


public class FormUserDataFactory {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 70;
    private static final int MIN_EXPERIENCE = 1;
    private static final int MAX_EXPERIENCE = 7;


    private static final Faker faker = new Faker();
    private static final Options options = faker.options();

    public static FormUser createValidUser() throws IOException {
        return new FormUserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .gender(options.option(FormUser.Gender.class))
                .age(faker.number().numberBetween(MIN_AGE, MAX_AGE))
                .experience(faker.number().numberBetween(MIN_EXPERIENCE, MAX_EXPERIENCE))
                .profession(AUTOMATION_TESTER)
                .continent(options.option(FormUser.Continent.class))
                .commands(WAIT_COMMANDS, NAVIGATION_COMMANDS)
                .filePath(Files.createTempFile("hello", ".file").toAbsolutePath().toString())
                .additional(faker.lorem().paragraph())
                .build();
    }

    public static FormUser createUserWithoutFirstName() throws IOException {
        return new FormUserBuilder()
                .firstName("")
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .gender(options.option(FormUser.Gender.class))
                .age(faker.number().numberBetween(MIN_AGE, MAX_AGE))
                .experience(faker.number().numberBetween(MIN_EXPERIENCE, MAX_EXPERIENCE))
                .profession(AUTOMATION_TESTER, MANUAL_TESTER)
                .continent(options.option(FormUser.Continent.class))
                .commands(NAVIGATION_COMMANDS)
                .filePath(Files.createTempFile("hello", ".file").toAbsolutePath().toString())
                .additional(faker.lorem().paragraph())
                .build();
    }

    public static FormUser createUserWithAgeBelow() throws IOException {
        return new FormUserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .gender(options.option(FormUser.Gender.class))
                .age(17)
                .experience(faker.number().numberBetween(MIN_EXPERIENCE, MAX_EXPERIENCE))
                .profession(AUTOMATION_TESTER)
                .continent(options.option(FormUser.Continent.class))
                .commands(SWITCH_COMMANDS, NAVIGATION_COMMANDS)
                .filePath(Files.createTempFile("hello", ".file").toAbsolutePath().toString())
                .additional(faker.lorem().paragraph())
                .build();
    }

    public static FormUser createUserWithInvalidEmail() throws IOException {
        return new FormUserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email("invalidEmail")
                .gender(options.option(FormUser.Gender.class))
                .age(faker.number().numberBetween(MIN_AGE, MAX_AGE))
                .experience(faker.number().numberBetween(MIN_EXPERIENCE, MAX_EXPERIENCE))
                .profession(AUTOMATION_TESTER)
                .continent(options.option(FormUser.Continent.class))
                .commands(BROWSER_COMMANDS)
                .filePath(Files.createTempFile("hello", ".file").toAbsolutePath().toString())
                .additional(faker.lorem().paragraph())
                .build();
    }

    public static FormUser createUserWithoutProfession() throws IOException {
        return new FormUserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .gender(options.option(FormUser.Gender.class))
                .age(faker.number().numberBetween(MIN_AGE, MAX_AGE))
                .experience(faker.number().numberBetween(MIN_EXPERIENCE, MAX_EXPERIENCE))
                .profession()
                .continent(options.option(FormUser.Continent.class))
                .commands(WAIT_COMMANDS, NAVIGATION_COMMANDS)
                .filePath(Files.createTempFile("hello", ".file").toAbsolutePath().toString())
                .additional(faker.lorem().paragraph())
                .build();
    }

    public static FormUser createUserWithoutFile(){
        return new FormUserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .gender(options.option(FormUser.Gender.class))
                .age(faker.number().numberBetween(MIN_AGE, MAX_AGE))
                .experience(faker.number().numberBetween(MIN_EXPERIENCE, MAX_EXPERIENCE))
                .profession(AUTOMATION_TESTER)
                .continent(options.option(FormUser.Continent.class))
                .commands(WAIT_COMMANDS, NAVIGATION_COMMANDS)
                .filePath("")
                .additional(faker.lorem().paragraph())
                .build();
    }
}
