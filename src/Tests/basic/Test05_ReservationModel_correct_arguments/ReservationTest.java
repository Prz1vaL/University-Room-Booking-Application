package Tests.basic.Test05_ReservationModel_correct_arguments;

import model.Reservation.Reservation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationTest {

    Reservation reservation = new Reservation("101", "alpha@gmail.com", "jack cole", "J.11", "11/02/2022", "11/02/2022", "12:00", "13:00", true);

    @Test
    void getBookingID() {
        String expected = "101";
        String actual = reservation.getBookingID();
        assertEquals(expected, actual);
    }

    @Test
    void getCheckInDate() {
        String expected = "11/02/2022";
        String actual = reservation.getCheckInDate();
        assertEquals(expected, actual);
    }

    @Test
    void getCheckOutDate() {
        String expected = "11/02/2022";
        String actual = reservation.getCheckOutDate();
        assertEquals(expected, actual);
    }

    @Test
    void getEmail() {
        String expected = "alpha@gmail.com";
        String actual = reservation.getEmail();
        assertEquals(expected, actual);
    }

    @Test
    void getBuildingName() {
        String expected = "jack cole";
        String actual = reservation.getBuildingName();
        assertEquals(expected, actual);
    }

    @Test
    void getRoom() {
        String expected = "J.11";
        String actual = reservation.getRoom();
        assertEquals(expected, actual);

    }

    @Test
    void getCheckInTime() {
        String expected = "12:00";
        String actual = reservation.getCheckInTime();
        assertEquals(expected, actual);
    }

    @Test
    void getCheckOutTime() {
        String expected = "13:00";
        String actual = reservation.getCheckOutTime();
        assertEquals(expected, actual);
    }
}
