package com.hack.hck.meili.Index;

public enum PartyStatus {
    GLOBAL("GLOBAL"),
    PUBLIC("PUBLIC"),
    PRIVATE("PRIVATE");

    private String value;

    PartyStatus(String val) {
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
