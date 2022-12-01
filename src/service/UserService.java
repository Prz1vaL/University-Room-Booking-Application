package service;

import model.User.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User Service Layer interacts when called by the Controller from the View.
 *
 * @author 220031985
 */
public class UserService implements Serializable {


    private Map<String, User> user = new HashMap<>();


    /**
     * Constructor UserService.
     */
    public UserService() {
    }

    /**
     * Saving the User Data.
     *
     * @throws IOException throws IOException.
     */
    public void userSave() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("userData.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(user);
        o.close();
        f.close();

    }

    /**
     * Load the User Data.
     */
    public void userLoad() {
        try {

            FileInputStream fi = new FileInputStream(new File("userData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            user = (Map<String, User>) oi.readObject();


            oi.close();
            fi.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    /**
     * Adding the User to the System.
     *
     * @param email EmailID.
     * @param name  Name.
     */
    public void addUser(String email, String name) {
        if (user.containsKey(email)) {
            throw new IllegalArgumentException("User registered in the System. \n");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("No Name given. \n");
        } else {
            user.put(email, new User(name, email));
        }
    }


    /**
     * Deleting the User.
     *
     * @param email Email_ID.
     */
    public void delUser(String emailID) {
        String email = emailID.trim();
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Given Email is Empty");
        } else if (user.isEmpty()) {
            throw new IllegalArgumentException("No Users registered in the System. \n");
        } else if (user.containsKey(email)) {
            user.remove(email);
        } else {
            throw new IllegalArgumentException(" User not registered in the System. \n");
        }
    }


    /**
     * For test purposes
     *
     * @return Size of the User Map.
     */
    public int getUsersCount() {
        return user.size();

    }

    /**
     * Viewing all users.
     */
    public Map<String, User> viewUsers() {
        Map<String, User> viewUsers = new HashMap<>();
        if (user.isEmpty()) {
            throw new IllegalArgumentException("No Users registered in the System. \n");
        } else {
            viewUsers.putAll(user);
            return viewUsers;
            // System.out.println(user.keySet() +"\n");

        }
    }

    /**
     * Check if user exists or not.
     *
     * @param email Email ID.
     * @return true if exists.
     */
    public boolean checkUser(String email) {
        if (user.containsKey(email)) {
            return true;
        } else {
            throw new IllegalArgumentException("User not registered in the System. \n");
        }
    }


}




