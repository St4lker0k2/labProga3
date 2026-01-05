package Locations;

public enum Location {
    KITCHEN("кухня"),
    ROOF("крыша"),
    STREET("улица"),
    MALYSHS_ROOM("комната Малыша"),
    LIVING_ROOM("спальня");
    private final String name;

    Location(String name) {this.name = name;}

    public String getNameLocation() {
        return this.name;
    }
}
