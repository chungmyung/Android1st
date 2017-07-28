package com.chungmyung.myapplication.Adapterview;

/**
 * 모델 클래스 Created by user on 2017-07-26.
 */

public class People {
    private String name;
    private String phone;
    private String email;
    private int picture;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() { return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public People(String name, String phone, String email, int picture) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.picture = picture;
    }

    public People(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("People{");
        sb.append("name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", picture=").append(picture);
        sb.append('}');
        return sb.toString();
    }
}
