package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class User_role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="userId" )
    private User user;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public User_role() {
    }

    public User_role(Long id, User user, Role role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
