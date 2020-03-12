package com.example.tourguide.model;

public class Sight {

    private int imageResId;
    private String name;
    private String desc;
    private float rate;

    public Sight(int imageResId, String name, String desc, float rate) {
        this.imageResId = imageResId;
        this.name = name;
        this.desc = desc;
        this.rate = rate;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public float getRate() {
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