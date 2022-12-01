package Tests.basic.Test04_BuildingModel_correct_arguments;

import model.Building.Building;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildingTest {

    Building building = new Building("jack cole", "St Andrews", "alpha@gmail.com", "a");

    @Test
    void getBuildingName() {
        String expected = "jack cole";
        String actual = building.getBuildingName();
        assertEquals(expected, actual);
    }

    @Test
    void getAddress() {
        String expected = "St Andrews";
        String actual = building.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    void getEmail() {
        String expected = "alpha@gmail.com";
        String actual = building.getEmail();
        assertEquals(expected, actual);
    }


    @Test
    void getRoomName() {
        String expected = "a";
        String actual = building.getRoomName();
        assertEquals(expected, actual);
    }
}
