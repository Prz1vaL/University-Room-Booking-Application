package service;


import model.Reservation.Reservation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Reservation Service Layer interacts when called by the controller from the view.
 *
 * @author 220031985.
 */
// Bug Fix: If user is the key, they cannot make more than one booking (Addressed).
public class ReservationService implements Serializable {


    private Map<String, Reservation> reservation = new HashMap<>();


    /**
     * Constructor of the class (Declaration).
     */
    public ReservationService() {
    }


    /**
     * @param bookingID    BookingID.
     * @param email        Email of the User.
     * @param buildingName Building Name.
     * @param room         Room Name.
     * @param checkInDate  Check In Date.
     * @param checkOutDate Check Out Date.
     * @param checkInTime  Check In TIme.
     * @param checkOutTime Check Out Time.
     * @param isBooked     state of the room (redudant).
     */
    // Bug Fix: Rewrite the method as keeping bookingID as the key. (Addressed)
    public void addReservation(String bookingID, String email, String buildingName, String room, String checkInDate, String checkOutDate, String checkInTime, String checkOutTime, boolean isBooked) {
        if (bookingID.trim().isEmpty() || email.trim().isEmpty() || buildingName.trim().isEmpty() || checkInDate.trim().isEmpty() || checkInDate.trim().isEmpty() || checkOutDate.trim().isEmpty() || checkInTime.trim().isEmpty() || checkOutTime.trim().isEmpty()) {
            throw new IllegalArgumentException("Texts Fields cannot be empty");
        }
        reservation.put(bookingID, new Reservation(bookingID, email, buildingName, room, checkInDate, checkOutDate, checkInTime, checkOutTime, isBooked));

    }

    /**
     * Deleting a Reservation of a User.
     *
     * @param bookingID Booking ID.
     */
    public void delReservation(String bookingID) {
        if (reservation.containsKey(bookingID)) {
            reservation.remove(bookingID);
        } else if (reservation.isEmpty()) {
            throw new IllegalArgumentException("No Bookings present in the System.");
        } else {
            throw new IllegalArgumentException("No Booking done under this Booking ID.");
        }

    }


    /**
     * Viewing Reservation of an individual User (Booking ID).
     *
     * @param bookingID Booking ID.
     */
    // Bug Fix: Rewrite the method as keeping BookingID as the key or email address as value. (Addressed)
    public HashMap<String, Reservation> viewMyRes(String bookingID) {
        HashMap<String, Reservation> bookingIDRes = new HashMap<String, Reservation>();
        if (reservation.isEmpty()) {
            throw new IllegalArgumentException("No Reservations Booked under " + bookingID);
        } else if (reservation.containsKey(bookingID)) {
            for (Map.Entry<String, Reservation> m : reservation.entrySet()) {
                if (m.getKey().equals(bookingID)) {
                    bookingIDRes.put(m.getKey(), m.getValue());
                }
            }
        } else {
            throw new IllegalArgumentException("User has not placed any Reservations.");
        }
        return bookingIDRes;
    }

    /**
     * To check out the Booking ID.
     *
     * @param bookingID Booking ID given by User.
     * @return
     */
    public boolean checkID(String bookingID) {
        if (bookingID.trim().isEmpty()) {
            throw new IllegalArgumentException("Text Fields cannot be Empty.");
        } else if (reservation.containsKey(bookingID)) {
            throw new IllegalArgumentException("No Two Bookings can have the same ID.");
        } else if (bookingID.isEmpty()) {
            throw new IllegalArgumentException(("Booking ID cannot be empty"));
        }
        return false;
    }

    /**
     * Checking for Overlap Conditions.
     *
     * @param checkInTime  Check In Time.
     * @param checkOutTime Check Out Time.
     * @param roomName     Room Name.
     * @param checkInDate  Check In Date.
     */
    public void checkOverlap(String checkInTime, String checkOutTime, String roomName, String checkInDate) {
        for (Map.Entry<String, Reservation> m : reservation.entrySet()) {
            if (m.getValue().getRoom().contains(roomName) && m.getValue().getCheckInDate().contains(checkInDate)) {
                int cmp1 = checkOutTime.compareTo(m.getValue().getCheckOutTime());
                int cmp2 = checkInTime.compareTo(m.getValue().getCheckInTime());
                if (cmp1 <= 0 && cmp2 >= 0) {
                    throw new IllegalArgumentException("Room is booked by " + m.getValue().getEmail());
                }
                if (m.getValue().getCheckInTime().equals(checkInTime) || m.getValue().getCheckOutTime().equals(checkOutTime)) {
                    throw new IllegalArgumentException("Room is booked by " + m.getValue().getEmail());
                }
            }


        }


    }

    /**
     * Viewing all Rooms Booked (Assertion : All other rooms that are not printed in this method is free to be booked).
     *
     * @return
     */
    public Map<String, Reservation> roomsBooked() {
        if (reservation.isEmpty()) {
            throw new IllegalArgumentException("No Booked Rooms");
        } else {
            Map<String, Reservation> bookedRooms = new HashMap<>();
            bookedRooms.putAll(reservation);
            return bookedRooms;
        }
    }


    /**
     * Viewing Reservation of a user by email_ID.
     *
     * @param email email_ID.
     * @return
     */
    // Bug Fix : This for - loop is not working at the moment. (Addressed)
    public Map<String, Reservation> viewResName(String email) {
        HashMap<String, Reservation> viewResID = new HashMap<String, Reservation>();
        if (email.isEmpty()) {
            throw new IllegalArgumentException("EMAIL IS EMPTY. TRY AGAIN!");
        } else if (reservation.isEmpty()) {
            throw new IllegalArgumentException("No Reservations Booked under " + email);
        } else if (!reservation.isEmpty()) {
            for (Map.Entry<String, Reservation> m : reservation.entrySet()) {
                if (m.getValue().getEmail().contains(email)) {
                    viewResID.put(m.getKey(), m.getValue());
                }
            }
        } else {
            throw new IllegalArgumentException("User has not placed any Reservations.");
        }
        return viewResID;

    }

    /**
     * Saving Reservation Data.
     *
     * @throws IOException
     */
    public void resSave() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("resData.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(reservation);
        o.close();
        f.close();

    }

    /**
     * Loading Reservation Data.
     */
    public void resLoad() {
        try {

            FileInputStream fi = new FileInputStream(new File("resData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            reservation = (Map<String, Reservation>) oi.readObject();


            oi.close();
            fi.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * For testing purposes.
     *
     * @return size of the Reservation map.
     */
    public int resCount() {
        return reservation.size();


    }
}
