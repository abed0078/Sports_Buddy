package com.example.sports_buddy;

import android.widget.TextView;

public class MovieModel {
    private String TITLE, DATE, Distance;
    private MovieModel textView;

    public MovieModel() {
    }

    public MovieModel(String TITLE, String DATE, String Distance) {
        this.TITLE = TITLE;
        this.DATE = DATE;
        Distance = Distance;

    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public void setDistance(String distance) {
        Distance = Distance;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getDATE() {
        return DATE;
    }

    public String getDistance() {
        return Distance;
    }


}
