package com.tjetc.domain;

public class Goods {
    private int id;
    private String name;
    private String image;
    private double price;

    public Goods() {
    }

    public Goods(int id, String name, String imge, double price) {
        this.id = id;
        this.name = name;
        this.image = imge;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imge) {
        this.image = imge;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
