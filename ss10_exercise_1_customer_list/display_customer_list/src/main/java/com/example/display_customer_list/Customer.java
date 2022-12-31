package com.example.display_customer_list;

public class Customer {
    private String name;
    private String address;
    private String dateOfBirth;
    private String image;

    public Customer() {
    }

    public Customer(String name, String address, String dateOfBirth, String image) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
