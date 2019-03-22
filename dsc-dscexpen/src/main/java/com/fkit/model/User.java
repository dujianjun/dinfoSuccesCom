package com.fkit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-03-27  16:44  星期二
 * version 1.0
 */

@Table(name = "t_users")
public class User implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "firstname")
    private  String firstname;

    @Column(name = "lastname")
    private  String lastname;

    @Column(name = "phone")
    private  String phone;

    @Column(name = "email")
    private  String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
