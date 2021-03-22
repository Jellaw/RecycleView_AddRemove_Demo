package com.example.recycleview_addremove_demo;

public class Cat {
    private int img;
    private String name;
    private String cost;

    public Cat(int img, String name, String cost) {
        this.img = img;
        this.name = name;
        this.cost = cost;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
