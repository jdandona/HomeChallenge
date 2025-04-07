package com.n26.enums;

public enum HttpStatusCode {
    STATUS200(200),
    STATUS201(201),
    STATUS404(404);

    public final int code;

    HttpStatusCode(int code) {
        this.code = code;
    }
    
    
}
