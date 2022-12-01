package Tests.basic.Test01_UserModel_correct_arguments;

import model.User.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    // create User Instance
    User user = new User("alpha", "alpha@gmail.com");

    @Test
    void getName() {
        String expected = "alpha";
        String actual = user.getName();
        assertEquals(expected, actual);
    }

    @Test
    void getEmail() {
        String expected = "alpha@gmail.com";
        String actual = user.getEmail();
        assertEquals(expected, actual);
    }
}
