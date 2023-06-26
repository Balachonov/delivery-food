package balachonov.entities;

public enum UserRole {
    ADMIN ("admin"),
    MANAGER("manager"),
    COURIER("courier"),
    USER("user");
    private final String TITLE;

    UserRole(String title) {
        this.TITLE = title;
    }

    public String getTitle() {
        return TITLE;
    }
}
