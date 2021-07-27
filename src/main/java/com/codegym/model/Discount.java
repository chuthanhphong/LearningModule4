package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private int usages;

    public Discount() {
    }

    public Discount(Long id, String code, int usages) {
        this.id = id;
        this.code = code;
        this.usages = usages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUsages() {
        return usages;
    }

    public void setUsages(int usages) {
        this.usages = usages;
    }
}
