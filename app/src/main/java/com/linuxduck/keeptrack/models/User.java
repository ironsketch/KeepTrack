package com.linuxduck.keeptrack.models;

public class User {
    Long Id;
    Double goalWeight;

    public User(){}

    public User(Long Id, Double goalWeight){
        this.Id = Id;
        this.goalWeight = goalWeight;
    }

    public Long getId(){
        return this.Id;
    }

    public Double getGoalWeight(){
        return this.goalWeight;
    }

    public void editGoalWeight(Double goalWeight){
        this.goalWeight = goalWeight;
    }
}
