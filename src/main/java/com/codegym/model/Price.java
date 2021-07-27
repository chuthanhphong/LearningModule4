package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int originPrice;
    private int discountPrice;
    private int serviceFee;
    private String serviceDescription;
    private String serviceType;

    public Price() {
    }

    public Price( int originPrice, int discountPrice, int serviceFee, String serviceDescription, String serviceType) {
        this.originPrice = originPrice;
        this.discountPrice = discountPrice;
        this.serviceFee = serviceFee;
        this.serviceDescription = serviceDescription;
        this.serviceType = serviceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(int serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
