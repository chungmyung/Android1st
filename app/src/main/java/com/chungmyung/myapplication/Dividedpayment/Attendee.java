package com.chungmyung.myapplication.Dividedpayment;

/**
 * Created by user on 2017-08-16.
 */

public class Attendee {
    private String name;
    private String phone;
    private String email;
    private String amount;

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

    public String getEmail() {
        return email;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Attendee(String name, String phone, String email, String amount) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.amount = amount;
    }

    public Attendee(String name, String email, String amount) {
        this.name = name;
        this.email = email;
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Attendee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


