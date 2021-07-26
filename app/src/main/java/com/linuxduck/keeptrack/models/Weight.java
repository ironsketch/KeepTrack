package com.linuxduck.keeptrack.models;

public class Weight {
    Long Id;
    String date;
    String time;
    Double weight;

    public Weight(){}

    public Weight(Long Id, String date, String time, Double weight){
        this.Id = Id;
        this.date = date;
        this.time = time;
        this.weight = weight;
    }

    public Long getId() {
        return Id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Double getWeight() {
        return weight;
    }
}
