package com.example.frebasetorecycler;

public class model {
    String userId,com,currentDate,currentTime;

    public model() {
    }

    public model(String userId, String com, String currentDate, String currentTime) {
        this.userId = userId;
        this.com = com;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
