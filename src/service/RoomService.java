package service;

import model.Room.Room;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * RoomService interacts when called by the controller from view.
 *
 * @author 220031985
 */
public class RoomService implements Serializable {
    private static Map<String, Room> rooms = new HashMap<>();

    /**
     * Constructor of the class.
     */
    public RoomService() {
    }

    /**
     * Adding the room.
     *
     * @param buildingName building name.
     * @param roomName     room name.
     * @param isBooked     state of the room (Redudant).
     */
    //Bug Fix: Only one room is storing for one value in the Terminal???? (Addressed)
    // Bug Fix: If Key is the same, the building is getting replaced with the latest update. (Addressed)
    public void addRoom(String buildingName, String roomName, boolean isBooked) {
        // Bug Fix: Not checking for Duplication (Addressed)
        if (buildingName.isEmpty() || roomName.isEmpty()) {
            throw new IllegalArgumentException("Text Fields cannot be empty. Try Again!");
        } else if (rooms.containsKey(roomName.toUpperCase())) {
            throw new IllegalArgumentException("Room Name registered in the System. \n");
        } else {
            rooms.put(roomName.toUpperCase(), new Room(roomName.toUpperCase(), buildingName.toLowerCase(), isBooked));
        }
    }

    /**
     * Deleting the room.
     *
     * @param buildingName1 Building Name.
     * @param roomName1     Room Name.
     */
    public void delRoom(String buildingName1, String roomName1) {
        String buildingName = buildingName1;
        String roomName = roomName1;
        if (roomName.isEmpty() || buildingName.isEmpty()) {
            throw new IllegalArgumentException("Text Fields cannot be empty!");
        } else if (rooms.isEmpty()) {
            throw new IllegalArgumentException("No Rooms are registered in the System. \n");
        } else if (!rooms.isEmpty()) {
            Set<Entry<String, Room>> setOfEntries = rooms.entrySet();
            Iterator<Entry<String, Room>> iterator = setOfEntries.iterator();
            while (iterator.hasNext()) {
                Entry<String, Room> entry = iterator.next();
                String value = entry.getKey();
                if (value.contains(roomName.toUpperCase())) {
                    iterator.remove();
                }
            }
        } else {
            throw new IllegalArgumentException("Room not registered in the System. \n");
        }
    }


    /**
     * Updating the Room Model if Building is Deleted(Rooms Deleted).
     *
     * @param buildingName building Name.
     */
    //  Exception-Handling: Concurrent Modification in the main thread (Addressed).
    public void delRoomFromBuild(String buildingName) {
        Set<Entry<String, Room>> setOfEntries = rooms.entrySet();
        Iterator<Entry<String, Room>> iterator = setOfEntries.iterator();
        while (iterator.hasNext()) {
            Entry<String, Room> entry = iterator.next();
            String value = entry.getValue().getBuildingName();
            if (value.contains(buildingName.toLowerCase())) {
                iterator.remove();
            }

        }
    }

    /**
     * Viewing all rooms in Buildings present in the system.
     */
    public Map<String, Room> viewRooms() {
        Map<String, Room> viewRooms = new HashMap<>();
        if (rooms.isEmpty()) {
            throw new IllegalArgumentException("No Room are registered in the System. \n");
        } else {
            viewRooms.putAll(rooms);
            return rooms;
        }
    }


    /**
     * Check if room exists in the system.
     *
     * @param roomName Room Name.
     * @return true if exits.
     */
    public boolean checkRoom(String roomName) {
        if (roomName.trim().isEmpty()) {
            throw new IllegalArgumentException("No Rooms are in the System. \n");
        }
        if (rooms.containsKey(roomName.toUpperCase())) {
            return true;
        } else {
            throw new IllegalArgumentException("Room not in the System. \n");
        }
    }


    /**
     * Updating the room status.
     *
     * @param roomName     Room Name.
     * @param buildingName Building Name.
     * @param isBooked     status of the room (redudant).
     */
    // Bug Fix : To Update the room in the building if a booking is done.
    public void updateRoom(String roomName, String buildingName, boolean isBooked) {
        roomName = roomName.toUpperCase();
        Set<Entry<String, Room>> setOfEntries = rooms.entrySet();
        Iterator<Entry<String, Room>> iterator = setOfEntries.iterator();
        while (iterator.hasNext()) {
            Entry<String, Room> entry = iterator.next();
            String key = entry.getKey();

            if (key.contains(roomName)) {
                rooms.replace(roomName, new Room(roomName.toUpperCase(), buildingName.toLowerCase(), isBooked));
            }

        }

    }

    public void roomsBooked() {
        if (rooms.isEmpty()) {
            throw new IllegalArgumentException("No Rooms are Present in the System");
        } else if (!rooms.isEmpty()) {
            for (Map.Entry<String, Room> m : rooms.entrySet()) {
                if (m.getValue().isBooked()) {
                    System.out.println("Rooms: " + m.getValue().getRoomName() + " are booked in" + m.getValue().getBuildingName());
                } else {
                    System.out.println("No Rooms are booked at the moment.");
                }

            }
        }
    }

    /**
     * For test purposes.
     *
     * @return size of the room map.
     */
    public int roomCount() {
        return rooms.size();
    }

    public void roomsFree() {
        if (rooms.isEmpty()) {
            throw new IllegalArgumentException("No Rooms are Present in the System");
        } else {
            for (Map.Entry<String, Room> m : rooms.entrySet()) {
                if (!m.getValue().isBooked()) {
                    System.out.println("Rooms: " + m.getValue().getRoomName() + " are free in " + m.getValue().getBuildingName().toUpperCase());
                }

            }
        }
    }

    /**
     * Saving the data of room Model.
     *
     * @throws IOException throws IOException.
     */
    public void roomSave() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("roomData.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(rooms);
        o.close();
        f.close();

    }

    /**
     * Load the room data.
     *
     * @throws IOException            throws IOException
     * @throws ClassNotFoundException throws ClassNotFoundException.
     */
    public void roomLoad() throws IOException, ClassNotFoundException {
        try {

            FileInputStream fi = new FileInputStream(new File("roomData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            rooms = (Map<String, Room>) oi.readObject();


            oi.close();
            fi.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
