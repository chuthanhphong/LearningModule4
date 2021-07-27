package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String note;
    private int preparedTime;
    private int quantityView;
    private int quantityOrder;
    private int preference;
    private LocalDate createDate;
    private LocalDate modifiedDate;
    @ManyToOne
   @JoinColumn(name = "restautantId" )
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "priceId" )
    private Price price;

    @ManyToOne
    @JoinColumn(name = "tagId")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "discountId" )
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    public Food() {
    }

    public Food(Long id, String name, String image, String note, int preparedTime, int quantityView, int quantityOrder, int preference, LocalDate createDate, LocalDate modifiedDate, Restaurant restaurant, Price price, Tag tag, Discount discount, Type type) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.note = note;
        this.preparedTime = preparedTime;
        this.quantityView = quantityView;
        this.quantityOrder = quantityOrder;
        this.preference = preference;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.restaurant = restaurant;
        this.price = price;
        this.tag = tag;
        this.discount = discount;
        this.type = type;
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
}
