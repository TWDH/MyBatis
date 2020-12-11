package com.itheima.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String uid;
    private Double money;

    //多对一（mybatis成为一对一）的映射：一个账户~一个用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", money=" + money +
                '}';
    }
}
