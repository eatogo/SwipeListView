package com.yuqirong.swipelistview.activity;


import java.io.Serializable;

public class Foodlist implements Serializable {
    private int id;
    private int image;
    private String name,name2;
    private int price;

    public Foodlist(int id, int image, String name, String name2, int price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.name2 = name2;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Foodlist() {
        super();
    }

}
