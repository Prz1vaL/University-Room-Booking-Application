package model.Reservation;


import java.io.Serializable;

/**
 * Reservation Model Layer of the application.
 */
public class Reservation implements Serializable {


    private final String bookingID;
    private final String buildingName;
    private final String email;
    private final String room;
    private final String checkInDate;
    private final String checkOutDate;
    private final String checkInTime;
    private final String checkOutTime;

    private final boolean isBooked = false;


    /**
     * Reservation Model.
     * @param bookingID    Booking ID for Reservations (Unique).
     * @param email        Email ID for Booking a Reservation(Identifier).
     * @param buildingName Building Name.
     * @param room         Room Name.
     * @param checkInDate  Check in Date.
     * @param checkOutDate Check out Date
     * @param checkInTime  Check in time.
     * @param checkOutTime Check out time.
     * @param isBooked     Room's status if booked or not (redundant).
     */
    public Reservation(String bookingID, String email, String buildingName, String room, String checkInDate, String checkOutDate, String checkInTime, String checkOutTime, boolean isBooked) {
        this.bookingID = bookingID;
        this.email = email;
        this.buildingName = buildingName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }


    /**
     * Returns the Booking ID.
     *
     * @return BookingID.
     */
    public String getBookingID() {
        return bookingID;
    }

    /**
     * Returns the checkInDate.
     *
     * @return CheckInDate.
     */
    public String getCheckInDate() {
        return this.checkInDate;
    }

    /**
     * Returns the CheckOutDate.
     *
     * @return CheckOutDate.
     */
    public String getCheckOutDate() {
        return this.checkOutDate;
    }

    /**
     * Returns the email.
     *
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the buildingName.
     *
     * @return buildingName.
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Returns rooms.
     *
     * @return room.
     */
    public String getRoom() {
        return room;
    }

    /**
     * Returns the checkInTime.
     *
     * @return checkInTime.
     */
    public String getCheckInTime() {
        return checkInTime;
    }

    /**
     * Returns the checkOutTime.
     *
     * @return CheckOutTime
     */
    public String getCheckOutTime() {
        return checkOutTime;
    }
}

