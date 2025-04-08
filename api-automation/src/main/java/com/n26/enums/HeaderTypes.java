package com.n26.enums;

public enum HeaderTypes {

    APPLICATION_JSON("application/json"),
    APPLICATION_XML("application/xml");

    public final String type;

    HeaderTypes(String type) {
        this.type = type;
    }
    
}
