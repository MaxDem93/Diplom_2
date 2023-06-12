package utils;

import model.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public User random() {
        return new User(RandomStringUtils.randomAlphanumeric(10) + "@gmail.com", "1234512345", "testcase");
    }

    public User generic() {
        return new User("maxim@gmail.com", "1234512345", "testcase");
    }
}
