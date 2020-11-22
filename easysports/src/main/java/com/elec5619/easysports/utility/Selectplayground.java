package com.elec5619.easysports.utility;

public class Selectplayground {
    private int id;
    private String address;
    private int rate;
    private String name;
    private int bookin;
    private String img;
    private String imgE;
    private  String imgP;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getBookin() {
        return bookin;
    }

    public int getRate() {
        return rate;
    }

    public String getAddress() {
        return address;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getImgE() {
        return imgE;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBookin(int bookin) {
        this.bookin = bookin;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
