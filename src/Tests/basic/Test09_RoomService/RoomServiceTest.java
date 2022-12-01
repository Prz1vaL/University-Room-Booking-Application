package Tests.basic.Test09_RoomService;

import org.junit.Test;
import service.RoomService;

import static org.junit.Assert.*;


public class RoomServiceTest {
    RoomService roomService = new RoomService();

    @Test
    public void addRoom() {
        roomService.addRoom("jack cole", "J10", true);
        roomService.addRoom("Powell Hall", "C10", true);
        assertEquals(2, roomService.roomCount());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            roomService.addRoom("jack cole", "J10", true);
            roomService.addRoom("jack cole", "J10", true);
            roomService.addRoom("jack cole", "J10", true);
        });
        String expectedMessage = "Room Name registered in the System. \n";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void delRoom() {
        roomService.addRoom("jack coles", "J101", true);
        assertEquals(3, roomService.roomCount());
        roomService.delRoom("jack coles", "J101");
        assertEquals(2, roomService.roomCount());


    }

    @Test
    public void checkRoom() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            roomService.checkRoom("");
        });
        String expectedMessage1 = "No Rooms are in the System. \n";
        String actualMessage1 = exception1.getMessage();

        assertTrue(actualMessage1.contains(expectedMessage1));

    }
}
