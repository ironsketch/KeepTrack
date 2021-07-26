package com.linuxduck.keeptrack.models;

public class Day {
    Long Id;
    String date;

    public Day(){}

    public Day(Long Id, String date){
        this.Id = Id;
        this.date = date;
    }

    public Long getId() {
        return Id;
    }

    public String getDate() {
        return date;
    }
}
