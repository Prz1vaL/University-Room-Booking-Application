package model.Room;

import java.io.Serializable;

/**
 * This is the Room Model.
 */
public class Room implements Serializable {


    private final boolean isBooked;
    private final String roomName;
    private final String buildingName;

    /**
     * Stores the following parameters.
     * @param roomName     Name of the room.
     * @param buildingName Name of the building the room is in.
     * @param isBooked     State of the room if booked or not.
     */
    public Room(String roomName, String buildingName, boolean isBooked) {
        this.roomName = roomName;
        this.buildingName = buildingName;
        this.isBooked = isBooked;
    }

    /**
     * Returns the roomName.
     *
     * @return roomName.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Returns the state of the Room (redundant).
     *
     * @return isBooked.
     */
    public boolean isBooked() {
        return isBooked;
    }

    /**
     * Returns the buildingName.
     *
     * @return buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }


}
