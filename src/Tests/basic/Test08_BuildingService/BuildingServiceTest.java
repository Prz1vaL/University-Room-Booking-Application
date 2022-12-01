package Tests.basic.Test08_BuildingService;

import org.junit.Test;
import service.BuildingService;

import static org.junit.Assert.*;

public class BuildingServiceTest {

    BuildingService buildingService = new BuildingService();

    @Test
    public void addBuilding() {
        buildingService.addBuilding("jack cole", "st andrews", "alpha@gmail.com");
        assertEquals(1, buildingService.buildCount());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            buildingService.addBuilding("jack cole", "st andrews", "alpha@gmail.com");
        });
        String expectedMessage = "Building registered in the System. \n";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        assertEquals(1, buildingService.buildCount());

        Exception exception_1 = assertThrows(IllegalArgumentException.class, () -> {
            buildingService.addBuilding("", "st andrews", "alpha@gmail.com");
        });
        String expectedMessage_1 = "No Building name is given. \n";
        String actualMessage_1 = exception_1.getMessage();

        assertTrue(actualMessage_1.contains(expectedMessage_1));

        Exception exception_2 = assertThrows(IllegalArgumentException.class, () -> {
            buildingService.addBuilding("john honey", "", "alpha@gmail.com");
        });
        String expectedMessage_2 = "Empty Address if given. \n";
        String actualMessage_2 = exception_2.getMessage();

        assertTrue(actualMessage_2.contains(expectedMessage_2));

    }

    @Test
    public void delBuilding() {
        buildingService.addBuilding("jack cole", "st andrews", "alpha@gmail.com");
        buildingService.delBuilding("jack cole");
        assertEquals(0, buildingService.buildCount());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            buildingService.delBuilding("jack cole");
        });
        String expectedMessage = "Building is not in the System.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        buildingService.addBuilding("jack cole", "st andrews", "alpha@gmail.com");
        assertEquals(1, buildingService.buildCount());


    }

    @Test
    public void checkBuilding() {
        buildingService.addBuilding("jack cole", "st andrews", "alpha@gmail.com");
        assertTrue(buildingService.checkBuilding("jack cole"));
        assertEquals(1, buildingService.buildCount());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            buildingService.checkBuilding("john honey");
        });
        String expectedMessage = "Building not in the System. \n";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }
}
