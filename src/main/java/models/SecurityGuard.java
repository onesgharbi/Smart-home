package models;


public class SecurityGuard extends User {
    public SecurityGuard(String username, String password) {
        super(username, password, Role.SECURITY_GUARD);
    }

    @Override
    public String toString() {
        return "SecurityGuard{" +
                "username='" + getUsername() + '\'' +
                '}';
    }
}

