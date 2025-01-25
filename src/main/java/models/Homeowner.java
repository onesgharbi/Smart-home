package models;


public class Homeowner extends User {
    public Homeowner(String username, String password) {
        super(username, password, Role.HOMEOWNER);
    }

    @Override
    public String toString() {
        return "Homeowner{" +
                "username='" + getUsername() + '\'' +
                '}';
    }
}

