package com.ibm.ee.ba.createtaskapplication.api.model;

import org.springframework.stereotype.Component;

@Component
public class Response {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
