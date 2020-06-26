package entities.constructions;

public enum HouseType {
    WOODEN("Wooden"), BRICK("Brick"), WOODEN_BRICK("Wooden-Brick");

    private final String name;

    HouseType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }

}