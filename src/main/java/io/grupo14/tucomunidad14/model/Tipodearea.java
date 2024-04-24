package io.grupo14.tucomunidad14.model;

public enum Tipodearea {
    PADDEL(0, "Pistas de pádel"),
    LOCAL(1, "Local"),
    GIMNASIO(2, "Gimnasio");

    private final int value;
    private final String description;

    Tipodearea(int value, String description) {
        this.value = value;
        this.description = description;
    }
    
    

    private Tipodearea() {
        this.value = 0;
        this.description = "";
    }



    public int getValue() {
        return value;
    }


    public static Tipodearea fromValue(int value) {
        for (Tipodearea type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de área no reconocido: " + value);
    }

    public String getDescription() {
        return description;
    }
}
