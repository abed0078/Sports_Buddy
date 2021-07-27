package com.example.sports_buddy;


public class UserInformation {
    private String TITLE, DATE,DISTANCE,DESCRIPTION, TIME, NumberOfParticipants,DURATION,MaximumSpeed,MinimumSpeed,Theme,a,b,c,d,e;

    public UserInformation() {
    }

    public UserInformation(String TITLE, String DATE, String DISTANCE, String DESCRIPTION, String TIME, String numberOfParticipants, String DURATION, String maximumSpeed, String minimumSpeed, String theme, String a, String b, String c, String d, String e) {
        this.TITLE = TITLE;
        this.DATE = DATE;
        this.DISTANCE = DISTANCE;
        this.DESCRIPTION = DESCRIPTION;
        this.TIME = TIME;
        NumberOfParticipants = numberOfParticipants;
        this.DURATION = DURATION;
        MaximumSpeed = maximumSpeed;
        MinimumSpeed = minimumSpeed;
        Theme = theme;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getDISTANCE() {
        return DISTANCE;
    }

    public void setDISTANCE(String DISTANCE) {
        this.DISTANCE = DISTANCE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getNumberOfParticipants() {
        return NumberOfParticipants;
    }

    public void setNumberOfParticipants(String numberOfParticipants) {
        NumberOfParticipants = numberOfParticipants;
    }

    public String getDURATION() {
        return DURATION;
    }

    public void setDURATION(String DURATION) {
        this.DURATION = DURATION;
    }

    public String getMaximumSpeed() {
        return MaximumSpeed;
    }

    public void setMaximumSpeed(String maximumSpeed) {
        MaximumSpeed = maximumSpeed;
    }

    public String getMinimumSpeed() {
        return MinimumSpeed;
    }

    public void setMinimumSpeed(String minimumSpeed) {
        MinimumSpeed = minimumSpeed;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}

//return hashcode of object


