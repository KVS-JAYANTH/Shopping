package com.example.shoppingCart.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @Column(name="order_id")
    private int orderId;

    @Column(name="user")
    private String user;
    @Column(name="mobile")
    private long mobile;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="price")
    private double price;

    public Orders() {}

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", user='" + user + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }

    public Orders(int orderId, String user, long mobile, String email, String address, double price) {
        this.orderId = orderId;
        this.user = user;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}