package com.vijayapps.db_1.model;

public class contact {
    private int id;
    private String name;
    private String phone_number;

    public contact(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public contact(int id, String name, String phone_number) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }

    public contact() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
