package controller;


import model.Building.Building;
import model.Reservation.Reservation;
import model.Room.Room;
import model.User.User;
import service.BuildingService;
import service.ReservationService;
import service.RoomService;
import service.UserService;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Controller (Booking Resource) will call the Service layer's objects to get or update Models, or other requests.
 *
 * @author 220031985.
 */
public class BookingResource implements Runnable {

    private final UserService userService;
    private final RoomService roomService;
    private final ReservationService reservationService;
    private final BuildingService buildingService;

    public BookingResource(UserService userService, RoomService roomService, ReservationService reservationService, BuildingService buildingService) {
        this.userService = userService;
        this.roomService = roomService;
        this.reservationService = reservationService;
        this.buildingService = buildingService;
    }


    /**
     * Passes value to the service layer.
     *
     * @param email Email is Unique.
     * @param name  Name of the user.
     * @throws IOException if empty or Invalid.
     */
    public void addUser(String email, String name) throws IOException {
        userService.addUser(email, name);

    }

    /**
     * Updates the value to the service layer.
     *
     * @param email Updates the user email to service layer.
     */
    public void delUser(String email) {
        userService.delUser(email);
    }

    /**
     * Calling all users in the model by asking the service layer.
     */
    public Map<String, User> viewUsers() {
        return userService.viewUsers();
    }


    /**
     * The Controller passes the params to the service layer.
     *
     * @param buildingName Add the building name.
     * @param address      Add the Building's address.
     * @param email        User that is adding the building.
     */
    public void addBuilding(String buildingName, String address, String email) {
        buildingService.addBuilding(buildingName, address, email);
    }

    /**
     * THe Controller updates the params to the service layer.
     *
     * @param buildingName Updating the building parameter.
     */
    public void delBuilding(String buildingName) {
        buildingService.delBuilding(buildingName);
    }

    /**
     * Calling the service layer to view all Buildings.
     *
     * @return
     */
    public Map<String, Building> viewBuildings() {
        return buildingService.viewBuildings();

    }


    /**
     * Calling the service layer -> Model from the controller.
     *
     * @param buildingName Adding building name.
     * @param roomName     Adding room name.
     */
    public void addRoom(String buildingName, String roomName, boolean isBooked) {
        roomService.addRoom(buildingName, roomName, isBooked);
    }

    /**
     * Updating the model by invoking service layer from the controller.
     *
     * @param buildingName Updating the buildingName.
     * @param roomName     Updating the roomName.
     */
    public void delRoom(String buildingName, String roomName) {
        roomService.delRoom(buildingName, roomName);
    }

    /**
     * Generating all rooms present in the System
     */
    public Map<String, Room> viewRooms() {
        return roomService.viewRooms();
    }


    /**
     * Checks if the user does exist or not.
     *
     * @param email checking if the user is present in the system.
     * @return If true, User exists.
     */
    public boolean checkUser(String email) {
        return userService.checkUser(email);
    }

    /**
     * Checks if the building exists or not
     *
     * @param buildingName checking if a Building is present in the system.
     * @return if true, Building exists.
     */
    public boolean checkBuilding(String buildingName) {
        return buildingService.checkBuilding(buildingName);
    }

    /**
     * Checks if the room does exist in the System.
     *
     * @param roomName Passes the room to the service layer.
     * @return if true, room Exists.
     */
    public boolean checkRoom(String roomName) {

        return roomService.checkRoom(roomName);
    }

    /**
     * Adding the Reservation of a room in the Building by a User.
     *
     * @param bookingID    Booking Reference ID
     * @param email        User's unique ID.
     * @param buildingName Building that contains the room.
     * @param room         Room that is to be booked.
     * @param checkInDate  The date that is to be booked.
     * @param checkOutDate The date the booking ends.
     * @param checkInTime  Time the user needs to book the room.
     * @param checkOutTime Time the user exits the room.
     * @param isBooked     Boolean value to check if the room is available.
     */
    public void addReservation(String bookingID, String email, String buildingName, String room, String checkInDate, String checkOutDate, String checkInTime, String checkOutTime, boolean isBooked) {
        reservationService.addReservation(bookingID, email, buildingName, room, checkInDate, checkOutDate, checkInTime, checkOutTime, isBooked);
    }

    /**
     * Deleting the booking done by User.
     *
     * @param bookingID Booking reference ID.
     */
    public void delReservation(String bookingID) {
        reservationService.delReservation(bookingID);
    }


    /**
     * To delete Rooms if the Building is deleted.
     *
     * @param buildingName Checks if the building is does exist and deletes the rooms present.
     */
    public void delRoomFromBuild(String buildingName) {
        roomService.delRoomFromBuild(buildingName);
    }

    /**
     * View a particular bookings.
     *
     * @param bookingID if the user has a reservation.
     * @return
     */
    public HashMap<String, Reservation> viewMyRes(String bookingID) {
        return reservationService.viewMyRes(bookingID);
    }

    /**
     * View Bookings by User_email_ID.
     *
     * @param email email_ID.
     * @return
     */
    public Map<String, Reservation> viewResName(String email) {
        return reservationService.viewResName(email);
    }


    /**
     * To see if BookingID exists in the system.
     *
     * @param bookingID makes each booking referenced and unique.
     */
    public void checkID(String bookingID) {
        reservationService.checkID(bookingID);
    }

    /**
     * @param checkInTime  Check In Time of the User.
     * @param checkOutTime Check out Time of the User.
     * @param roomName     Room booked by the User.
     * @param checkInDate  Check In date of the User.
     */
    public void checkOverlap(String checkInTime, String checkOutTime, String roomName, String checkInDate) {
        reservationService.checkOverlap(checkInTime, checkOutTime, roomName, checkInDate);
    }

    /**
     * @param roomName     Room booked by the User
     * @param buildingName Building which holds the Room.
     * @param isBooked     State of the Room (redundant).
     */
    public void updateRoom(String roomName, String buildingName, boolean isBooked) {
        roomService.updateRoom(roomName, buildingName, isBooked);
    }

    /**
     * Calling all Booked Rooms to the View.
     *
     * @return
     */
    public Map<String, Reservation> bookedRooms() {
        return reservationService.roomsBooked();

    }


    /**
     * Saving User Data.
     *
     * @throws IOException Exception Handling.
     */
    public void userSave() throws IOException {
        userService.userSave();
    }

    /**
     * Loading User Data.
     *
     * @throws IOException            throws IOException.
     * @throws ClassNotFoundException throws ClassNotFoundException.
     */
    public void userLoad() throws IOException, ClassNotFoundException {
        userService.userLoad();
    }

    /**
     * Saving Building Data.
     *
     * @throws IOException throws IOException.
     */
    public void buildSave() throws IOException {
        buildingService.buildSave();
    }

    /**
     * Loading Building Data.
     *
     * @throws IOException throws IOException.
     */
    public void buildLoad() throws IOException {
        buildingService.buildLoad();

    }

    /**
     * Saving Room Data.
     *
     * @throws IOException throws IOException.
     */
    public void roomSave() throws IOException {
        roomService.roomSave();

    }

    /**
     * Loading Room Data.
     *
     * @throws IOException            throws IOException
     * @throws ClassNotFoundException throws ClassNotFoundException.
     */
    public void roomLoad() throws IOException, ClassNotFoundException {
        roomService.roomLoad();

    }


    /**
     * Saving the Reservation Data
     *
     * @throws IOException throws IOException.
     */
    public void resSave() throws IOException {
        reservationService.resSave();

    }

    /**
     * Loading the Reservation Data.
     *
     * @throws IOException throws IOException.
     */
    public void resLoad() throws IOException {
        reservationService.resLoad();
    }

    //To implement the following parameters for these types of functions.(Addressed)

    public void isBeforeTime(String checkInTime, String checkOutTime) {
        int cmp = checkInTime.compareTo(checkOutTime);
        if (cmp > 0) {
            throw new IllegalArgumentException("Check In Time cannot be after Check Out Time");
        } else if (cmp == 0) {
            throw new IllegalArgumentException("There must least 5 min per booking ");
        }

    }

    public void checkDay(String checkInDate, String checkOutDate) throws ParseException {
        DateTimeFormatter fIn = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.UK);  // As a habit, specify the desired/expected locale, though in this case the locale is irrelevant.

        LocalDate d1 = LocalDate.parse(checkInDate, fIn);
        LocalDate d2 = LocalDate.parse(checkOutDate, fIn);

        long difference = ChronoUnit.DAYS.between(d1, d2);
        if (difference != 0) {
            throw new IllegalArgumentException("Cannot book a room over a day.");
        }
    }

    public void LeastBy5(String checkInTime, String checkOutTime) {
        String minIn = checkInTime.substring(3);
        String minOut = checkOutTime.substring(3);
        int minIn1 = Integer.parseInt(minIn);
        int minOut1 = Integer.parseInt(minOut);
        String hrIn = checkInTime.substring(0, checkInTime.length() - 3);
        String hrOut = checkOutTime.substring(0, checkOutTime.length() - 3);
        int hrIn1 = Integer.parseInt(hrIn);
        int hrOut1 = Integer.parseInt(hrOut);
        int dif = hrOut1 - hrIn1;
        int dif60 = dif * 60;
        //Bug-Fix: On lower numbers, the value adds (Addressed).
        int totalMin = minOut1 - minIn1;
        int totalTime = dif60 + totalMin;
        if (totalTime < 5) {
            throw new IllegalArgumentException("There must least 5 min per booking ");
        } else if ((totalTime % 5) != 0) {
            throw new IllegalArgumentException("Booking length must be a multiple of 5 minutes.");
        }

    }


    public void isDateValid(String date) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        {
            try {
                LocalDate.parse(date, f);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Error" + e);
            }
        }

    }


    /**
     * To check if input is of the valid time format.
     *
     * @param input Time.
     */
    public void validateTime(String input) {
        if (input.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
        } else {
            throw new IllegalArgumentException("Invalid Time Format");
        }
    }


    /**
     *
     */
    @Override
    public void run() {

    }
}
