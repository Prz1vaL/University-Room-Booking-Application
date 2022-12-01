package Tests.basic.Test10_ReservationService;

import org.junit.Test;
import service.ReservationService;

import static org.junit.Assert.*;

public class ReservationServiceTest {

    ReservationService reservationService = new ReservationService();

    @Test
    public void addReservation() {
        reservationService.addReservation("abc", "alpha@gmail.com", "jack cole", "J10", "12-02-2022", "12-02-2022", "13:00", "14:00", true);
        assertEquals(1, reservationService.resCount());

    }

    @Test
    public void delReservation() {
        reservationService.addReservation("abc", "alpha@gmail.com", "jack cole", "J10", "12-02-2022", "12-02-2022", "13:00", "14:00", true);
        reservationService.delReservation("abc");
        assertEquals(0, reservationService.resCount());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reservationService.addReservation("abc", "alpha@gmail.com", "jack cole", "J10", "12-02-2022", "12-02-2022", "13:00", "14:00", true);
            reservationService.delReservation("abc1");
        });
        String expectedMessage = "No Booking done under this Booking ID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void viewMyRes() {
        reservationService.addReservation("abc", "alpha@gmail.com", "jack cole", "J10", "12-02-2022", "12-02-2022", "13:00", "14:00", true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reservationService.viewMyRes("");
        });
        String expectedMessage = "User has not placed any Reservations.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }

    @Test
    public void checkID() {
        reservationService.addReservation("abc", "alpha@gmail.com", "jack cole", "J10", "12-02-2022", "12-02-2022", "13:00", "14:00", true);
        assertFalse(reservationService.checkID("abc1"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reservationService.checkID("abc");
        });
        String expectedMessage = "No Two Bookings can have the same ID.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkOverlap() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reservationService.addReservation("abc", "alpha@gmail.com", "jack cole", "J10", "12-02-2022", "12-02-2022", "13:00", "14:00", true);
            reservationService.checkOverlap("13:05", "13:35", "J10", "12-02-2022");
        });
        String expectedMessage = "Room is booked by " + "alpha@gmail.com";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


        assertEquals(1, reservationService.resCount());
    }

    @Test
    public void viewResName() {
        reservationService.addReservation("abc", "alpha@gmail.com", "jack cole", "J10", "12-02-2022", "12-02-2022", "13:00", "14:00", true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reservationService.viewResName("");
        });
        String expectedMessage = "EMAIL IS EMPTY. TRY AGAIN!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        reservationService.delReservation("abc");
        assertEquals(0, reservationService.resCount());
        Exception exception_1 = assertThrows(IllegalArgumentException.class, () -> {
            reservationService.viewResName("alpha@gmail.com");
        });
        String expectedMessage_1 = "No Reservations Booked under " + "alpha@gmail.com";
        String actualMessage_1 = exception_1.getMessage();

        assertTrue(actualMessage_1.contains(expectedMessage_1));

    }
}
