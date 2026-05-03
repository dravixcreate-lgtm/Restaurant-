package com.theekhamircha;

public class MenuItem {
    private Long id;
    private String name;
    private double price;
    private String img;

    public MenuItem(Long id, String name, double price, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    // Getters are required for the website to read the data
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImg() { return img; }
}
