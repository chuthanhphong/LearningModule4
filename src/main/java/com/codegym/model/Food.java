package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String image;
    private String note;
    private int preparedTime;
    private int quantityView;
    private int quantityOrder;
    private int preference;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @ManyToOne
    private Price price;

    @ManyToOne
    private Tag tag;

    @ManyToOne
    private Discount discount;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Restaurant restaurant;

    public Food() {
    }

    public Food(String name, String image, String note, int preparedTime, LocalDateTime createdDate, LocalDateTime modifiedDate, Price price, Tag tag, Discount discount, Type type, Restaurant restaurant) {
        this.name = name;
        this.image = image;
        this.note = note;
        this.preparedTime = preparedTime;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.price = price;
        this.tag = tag;
        this.discount = discount;
        this.type = type;
        this.restaurant = restaurant;
        this.quantityView = 0;
        this.quantityOrder = 0;
        this.preference = 0;
    }

    public Food(String name, String image, String note, int preparedTime, int quantityView, int quantityOrder, int preference, LocalDateTime createdDate, LocalDateTime modifiedDate, Price price, Tag tag, Discount discount, Type type, Restaurant restaurant) {
        this.name = name;
        this.image = image;
        this.note = note;
        this.preparedTime = preparedTime;
        this.quantityView = quantityView;
        this.quantityOrder = quantityOrder;
        this.preference = preference;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.price = price;
        this.tag = tag;
        this.discount = discount;
        this.type = type;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPreparedTime() {
        return preparedTime;
    }

    public void setPreparedTime(int preparedTime) {
        this.preparedTime = preparedTime;
    }

    public int getQuantityView() {
        return quantityView;
    }

    public void setQuantityView(int quantityView) {
        this.quantityView = quantityView;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
