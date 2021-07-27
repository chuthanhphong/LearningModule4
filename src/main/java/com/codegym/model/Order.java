package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderTime;
    private String receiverAddress;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    public Order() {
    }

    public Order(Long id, LocalDateTime orderTime, String receiverAddress, User user) {
        this.id = id;
        this.orderTime = orderTime;
        this.receiverAddress = receiverAddress;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
