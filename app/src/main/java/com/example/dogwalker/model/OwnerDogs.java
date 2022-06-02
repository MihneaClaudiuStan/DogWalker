package com.example.dogwalker.model;

public class OwnerDogs {
    private String dogImage;
    private String dogName;
    private String dogDesc;
    private String restName;
    private String doghourprice;
    private String id;
    private String userName;

    public String getDogImage() {
        return dogImage;
    }

    public void setDogImage(String dogImage) {
        this.dogImage = dogImage;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogDesc() {
        return dogDesc;
    }

    public void setDogDesc(String dogDesc) {
        this.dogDesc = dogDesc;
    }

    public String getDoghourprice() {
        return doghourprice;
    }

    public void setDoghourprice(String doghourprice) {
        this.doghourprice = doghourprice;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OwnerDogs(String foodImage, String foodName, String foodDesc, String foodPrice, String restName, String id, String userName) {
        this.dogImage = foodImage;
        this.dogName = foodName;
        this.dogDesc = foodDesc;
        this.doghourprice = foodPrice;
        this.restName = restName;
        this.id = id;
        this.userName = userName;
    }

    public OwnerDogs() {
    }
}
