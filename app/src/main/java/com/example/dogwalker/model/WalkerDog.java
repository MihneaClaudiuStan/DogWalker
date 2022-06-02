package com.example.dogwalker.model;

public class WalkerDog {
    private String dogImage;
    private String dogName;
    private String dogDesc;
    private String dogHourPrice;
    private String id;
    private String userName;
    private String dogId;

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

    public String getDogHourPrice() {
        return dogHourPrice;
    }

    public void setDogHourPrice(String dogHourPrice) {
        this.dogHourPrice = dogHourPrice;
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

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public WalkerDog(String dogImage, String dogName, String dogDesc, String dogHourPrice, String restName, String id, String userName, String dogId) {
        this.dogImage = dogImage;
        this.dogName = dogName;
        this.dogDesc = dogDesc;
        this.dogHourPrice = dogHourPrice;
        this.id = id;
        this.userName = userName;
        this.dogId = dogId;
    }

    public WalkerDog() {
    }
}
