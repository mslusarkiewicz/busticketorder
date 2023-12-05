package com.sii.busticketorder.model;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private double price;

    Route(){
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }
}
