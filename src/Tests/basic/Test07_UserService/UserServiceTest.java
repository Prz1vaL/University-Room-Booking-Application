package Tests.basic.Test07_UserService;

import model.User.User;
import org.junit.Test;
import service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {

    UserService userService = new UserService();

    User user = new User("alpha", "a@gmail.com");

    @Test
    public void addUser() {
        String expected = "alpha";
        String actual = user.getName();
        assertEquals(expected, actual);
        userService.addUser("a@gmail.com", "alpha");
        assertEquals(1, userService.getUsersCount());

    }

    @Test
    public void delUser() {
        userService.addUser("a@gmail.com", "alpha");
        userService.addUser("b@gmail.com", "beta");
        assertEquals(2, userService.getUsersCount());
        userService.delUser("a@gmail.com");
        assertEquals(1, userService.getUsersCount());

    }


    @Test
    public void checkUser() {
        userService.addUser("a@gmail.com", "alpha");
        boolean check = userService.checkUser("a@gmail.com");
        assertTrue(check);

    }
}
