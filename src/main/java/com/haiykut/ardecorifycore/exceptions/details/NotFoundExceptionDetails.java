package com.haiykut.ardecorifycore.exceptions.details;

public class NotFoundExceptionDetails {
    private String title = "Not Found Exception!";
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
    public NotFoundExceptionDetails(){
    }
    public NotFoundExceptionDetails(String details){
        this.details = details;
    }
}
