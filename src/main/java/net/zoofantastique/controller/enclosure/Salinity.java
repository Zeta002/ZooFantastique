package net.zoofantastique.controller.enclosure;

public enum Salinity {
    SALTWATER("eau salée"),
    BRACKISHWATER("eau saumâtre"),
    FRESHWATER("eau douce");

    private String value;

    Salinity(String salinity) {
        this.value = salinity;
    }
}
