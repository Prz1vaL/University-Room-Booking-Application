package service;

import model.Building.Building;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Building Service Layer interacts after being called by the controller from  View.
 *
 * @author 220031985
 */
public class BuildingService implements Serializable {


    private Map<String, Building> buildings = new HashMap<>();

    /**
     * Constructor BuildingService.
     */
    public BuildingService() {
    }

    public Map<String, Building> getBuildings() {
        return buildings;
    }

    /**
     * Adding the Buildings to the Model.
     *
     * @param buildingName Building Name.
     * @param address      Building Address.
     * @param email        Email of  the User (Log Purposes).
     */
    public void addBuilding(String buildingName, String address, String email) {

        if (buildings.containsKey(buildingName.toLowerCase())) {
            throw new IllegalArgumentException("Building registered in the System. \n");
        } else if (buildingName.isEmpty()) {
            throw new IllegalArgumentException(" No Building name is given. \n");
        } else if (address.isEmpty()) {
            throw new IllegalArgumentException("Empty Address if given. \n");
        } else {

            buildings.put(buildingName.toLowerCase(), new Building(buildingName, address, email, null));
        }
    }

    /**
     * View Buildings present in the system.
     *
     * @return
     */
    public Map<String, Building> viewBuildings() {
        Map<String, Building> viewBuildings = new HashMap<>();
        if (buildings.isEmpty()) {
            throw new IllegalArgumentException("No Building are registered in the System. \n");
        } else {
            viewBuildings.putAll(buildings);
            return viewBuildings;
        }
    }


    /**
     * Delete the Building
     *
     * @param buildingName Building Name.
     */
    // Additional Info: Ability to delete room if the building is deleted
    // (Addressed).
    public void delBuilding(String buildingName) {
        if (buildings.containsKey(buildingName.toLowerCase())) {
            buildings.remove(buildingName.toLowerCase());

        } else if (buildingName.isEmpty()) {
            throw new IllegalArgumentException("No Building name is given.");
        } else {
            throw new IllegalArgumentException("Building is not in the System.");
        }
    }

    /**
     * Check if the Building exists.
     *
     * @param buildingName Building Name.
     * @return true if contains.
     */
    public boolean checkBuilding(String buildingName) {

        if (buildings.containsKey(buildingName.toLowerCase())) {
            return true;
        } else {
            throw new IllegalArgumentException("Building not in the System. \n");
        }
    }

    /**
     * Save the Building Data.
     *
     * @throws IOException throws IOException.
     */
    public void buildSave() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("buildingData.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(buildings);
        o.close();
        f.close();

    }

    /**
     * Load the Building Data.
     */
    public void buildLoad() {
        try {

            FileInputStream fi = new FileInputStream(new File("buildingData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            buildings = (Map<String, Building>) oi.readObject();


            //  System.out.println(pr1.toString());

            oi.close();
            fi.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * For test purposes.
     *
     * @return size of the building map.
     */
    public int buildCount() {
        return buildings.size();
    }
}
