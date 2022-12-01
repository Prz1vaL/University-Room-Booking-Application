package model.User;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * User Model contains User Records.
 *
 * @author 220031985
 */

public class User implements Serializable {
    private static final String EMAIL_REGEX_PATTERN = "^((?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)]))$";


    private final String name;
    private final String email;


    /**
     * self-Initializing the parameters.
     * @param name  User name.
     * @param email User email.
     */
    public User(String name, String email) {
        this.isValidEmail(email);
        this.name = name;
        this.email = email;
    }

    /**
     * Validating the email.
     * @param email Checking if User email is Valid.
     */
    private void isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);

        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email is given\n");
        }
    }

    /**
     * Get Method for User.
     * @return name of the User.
     */
    public String getName() {
        return name;
    }

    /**
     * Get Method for the email of the user.
     * @return email of the user.
     */
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Email: " + this.email;
    }


}

