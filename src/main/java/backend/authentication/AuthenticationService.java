package backend.authentication;

import models.Role;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    private final List<User> users;

    public AuthenticationService() {
        this.users = new ArrayList<>();
        // Example Users
        users.add(new User("homeowner01", "password123", Role.HOMEOWNER));
        users.add(new User("technician01", "techPass", Role.TECHNICIAN));
        users.add(new User("security01", "securePass", Role.SECURITY_GUARD));
    }

    public User authenticate(String username, String password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public List<User> getUsers() {
        return users;
    }
}