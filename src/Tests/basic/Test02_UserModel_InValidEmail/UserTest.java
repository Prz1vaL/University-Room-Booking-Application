package Tests.basic.Test02_UserModel_InValidEmail;

import model.User.User;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void getEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("", "");
        });

        String expectedMessage = "Invalid email is given\n";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
