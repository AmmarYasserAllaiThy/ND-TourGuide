package com.example.tourguide;

public class Sight {

    private int imageResId;
    private String name;
    private String desc;
    private float rate;

    Sight(int imageResId, String name, String desc, float rate) {
        this.imageResId = imageResId;
        this.name = name;
        this.desc = desc;
        this.rate = rate;
    }

    int getImageResId() {
        return imageResId;
    }

    String getName() {
        return name;
    }

    String getDesc() {
        return desc;
    }

    float getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Site{" +
                "imageResId=" + imageResId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", rate=" + rate +
                '}';
    }
}