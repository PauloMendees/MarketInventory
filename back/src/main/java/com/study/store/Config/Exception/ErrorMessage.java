package com.study.store.Config.Exception;

import java.util.Date;

public class ErrorMessage {
    private Date currentDate;
    private String error;

    public ErrorMessage(Date currentDate, String error) {
        this.currentDate = currentDate;
        this.error = error;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
