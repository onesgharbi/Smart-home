package models;

import models.Role; // Ensure this import is present

public class Technician extends User {
    public Technician(String username, String password) {
        super(username, password, Role.TECHNICIAN);
    }

    @Override
    public String toString() {
        return "Technician{" +
                "username='" + getUsername() + '\'' +
                '}';
    }
}

