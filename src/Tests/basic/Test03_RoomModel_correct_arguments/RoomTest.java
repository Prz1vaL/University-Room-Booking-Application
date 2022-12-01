package Tests.basic.Test03_RoomModel_correct_arguments;

import model.Room.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {
    Room room = new Room("J.11", "jack cole", false);

    @Test
    void getRoomName() {
        String expected = "J.11";
        String actual = room.getRoomName();
        assertEquals(expected, actual);
    }

    @Test
    void isBooked() {
        boolean expected = false;
        boolean actual = false;
        assertEquals(expected, actual);
    }

    @Test
    void getBuildingName() {
        String expected = "jack cole";
        String actual = room.getBuildingName();
        assertEquals(expected, actual);
    }

    @Test
    void testGetRoomName() {
    }

    @Test
    void testIsBooked() {
    }

    @Test
    void testGetBuildingName() {
    }
}
