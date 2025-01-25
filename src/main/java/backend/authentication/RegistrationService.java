package backend.authentication;


import models.Role;
import models.User;

import java.util.List;




public class RegistrationService {
    private final List<User> users;




    // Constructor that links to the existing user list
    public RegistrationService(List<User> users) {
        this.users = users;
    }

    // Register a new user
    public boolean registerUser(String username, String password, String  role) {
        if (users.stream().anyMatch(user -> user.getUsername().equals(username))) {
            System.out.println("User with the same username already exists.");
            return false; // User already exists
        }

        // Validate the role
        if (!isValidRole(role)) {
            System.out.println("Invalid role provided: " + role);
            return false; // Invalid role
        }

        Role roleT = null;
        if(role.equals("HOMEOWNER")) {
            roleT=Role.HOMEOWNER;
        }else if(role.equals("SECURITY_GUARD")) {
            roleT=Role.SECURITY_GUARD;
        }else {
            roleT=Role.TECHNICIAN;
        }


        // Add the new user
        users.add(new User(username, password, roleT));
        System.out.println("User registered successfully: " + username);
        return true;
    }

    // Validate if the provided role is acceptable
    private boolean isValidRole(String role) {
        return role.equals("HOMEOWNER") || role.equals("TECHNICIAN") || role.equals("SECURITY_GUARD");
    }
}


