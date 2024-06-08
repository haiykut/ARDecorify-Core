package com.haiykut.ardecorifycore.exceptions.details;

public class AuthenticatonExceptionDetails {
    private String title = "Authentication Exception!";
    private String details;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public AuthenticatonExceptionDetails(String details) {
        this.details = details;
    }

    public AuthenticatonExceptionDetails(){

    }
}
