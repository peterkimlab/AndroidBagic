package com.example.bagic;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieParcelable implements Parcelable {

    private String name;
    private double rate;

    public MovieParcelable(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    protected MovieParcelable(Parcel in) {
        this.name = in.readString();
        this.rate = in.readDouble();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeDouble(this.rate);
    }

    public static final Parcelable.Creator<MovieParcelable> CREATOR = new Parcelable.Creator<MovieParcelable>() {

        @Override
        public MovieParcelable createFromParcel(Parcel source) {
            return new MovieParcelable(source);
        }

        @Override
        public MovieParcelable[] newArray(int size) {
            return new MovieParcelable[size];
        }
    };
}