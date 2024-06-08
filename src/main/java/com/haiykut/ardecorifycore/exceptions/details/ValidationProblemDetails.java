package com.haiykut.ardecorifycore.exceptions.details;

import java.util.Map;

public class ValidationProblemDetails {
    private String title = "Validation Problem!";
    private Map<String, String> errors;
    public String getTitle() {
        return title;
    }

    public ValidationProblemDetails(Map<String, String> errors) {
        this.errors = errors;
    }
    public ValidationProblemDetails(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }


}
