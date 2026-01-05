package Locations;

public enum PlanLocation {
    CHILDCAMP("детский лагерь"),
    STEAMBOAT("теплоход");
    private final String name;
    PlanLocation(String name) {this.name = name;}

    public String getNameLocation() {
        return this.name;
    }}
