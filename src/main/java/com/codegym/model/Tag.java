package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private int quantityAdd;
    private int quantityView;

    public Tag() {
    }

    public Tag(Long id, String name, String slug, int quantityAdd, int quantityView) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.quantityAdd = quantityAdd;
        this.quantityView = quantityView;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getQuantityAdd() {
        return quantityAdd;
    }

    public void setQuantityAdd(int quantityAdd) {
        this.quantityAdd = quantityAdd;
    }

    public int getQuantityView() {
        return quantityView;
    }

    public void setQuantityView(int quantityView) {
        this.quantityView = quantityView;
    }
}
