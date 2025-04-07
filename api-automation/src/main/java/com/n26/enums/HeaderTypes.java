package com.n26.enums;

public enum HeaderTypes {

    APPLICATION_JSON("application/json");

    public final String type;

    HeaderTypes(String type) {
        this.type = type;
    }
    
}
