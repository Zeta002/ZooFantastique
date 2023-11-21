package net.zoofantastique.controller.enclosure;

public enum Salinity {
    SALTWATER("eau salée"),
    BRACKISHWATER("eau saumâtre"),
    FRESHWATER("eau douce");

    private String value;

    Salinity(String salinity) {
        this.value = salinity;
    }

    // Getter et Setter
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void decreaseSalinity() {
        switch (this) {
            case SALTWATER:
                this.setValue(BRACKISHWATER.getValue());
                break;
            case BRACKISHWATER:
                this.setValue(FRESHWATER.getValue());
                break;
            case FRESHWATER:
                break;
        }
    }

    public void inscreaseSalinity() {
        switch (this) {
            case SALTWATER:
                break;
            case BRACKISHWATER:
                this.setValue(SALTWATER.getValue());
                break;
            case FRESHWATER:
                this.setValue(BRACKISHWATER.getValue());
                break;
        }
    }
}
