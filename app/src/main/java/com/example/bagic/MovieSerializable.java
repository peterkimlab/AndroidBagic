package com.example.bagic;

import java.io.Serializable;

public class MovieSerializable implements Serializable {

    private String name;
    private double rate;

    public MovieSerializable(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
