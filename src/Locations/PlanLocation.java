package Locations;

public enum PlanLocation {
    CHILDCAMP("детский лагерь"),
    STEAMBOAT("теплоход"),
    HOME("дом");
    private final String name;
    PlanLocation(String name) {this.name = name;}

    public String getNameLocation() {
        return this.name;
    }}
