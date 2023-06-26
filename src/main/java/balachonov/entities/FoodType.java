package balachonov.entities;

public enum FoodType {
    HOT ("hot"),
    SNACK("snack"),
    COLD("cold"),
    DESSERT("dessert"),
    DRINK("drink");

    private final String TITLE;

    FoodType(String title) {
        this.TITLE = title;
    }

    public String getTitle() {
        return TITLE;
    }
}
