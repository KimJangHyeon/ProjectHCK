package com.hack.hck.meili.Index;

public enum Genre {
    GENRE1("GENRE1"),
    GENRE2("GENRE2"),
    GENRE3("GENRE3"),
    GENRE4("DUMP");

    private final String value;

    Genre(String val) {
        this.value = val;
    }

    public String get() {
        return this.value;
    }

    public String getValue() {
        for (PartyStatus ps : PartyStatus.values()) {
            if (ps.get().equals(this.value))
                return this.value;
        }
        return null;
    }
}
