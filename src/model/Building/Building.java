package model.Building;

import java.io.Serializable;

/**
 * Building Model.
 *
 * @author 220031985
 */
public class Building implements Serializable {

    private final String buildingName;
    private final String address;

    private final String email;

    private final String roomName;


    /**
     * Self initialization.
     * @param buildingName Building Name.
     * @param address      Building's Address.
     * @param email        Entry done by the User (for Log Purposes).
     * @param roomName     Room's Name.
     */
    public Building(String buildingName, String address, String email, String roomName) {
        this.buildingName = buildingName;
        this.address = address;
        this.roomName = roomName;
        this.email = email;
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
     * Returns the address of the building.
     *
     * @return address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the email of the User.
     *
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the roomName.
     *
     * @return roomName.
     */
    public String getRoomName() {
        return roomName;
    }

}
