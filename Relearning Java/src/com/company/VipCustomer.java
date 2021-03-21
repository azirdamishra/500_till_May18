package com.company;
//constructors
public class VipCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public VipCustomer(){
        this("Name", 500, "name@email.com");
    }
    public VipCustomer(String name, double creditLimit){
        this(name, creditLimit,"name@email.com");
        this.name = name;
        this.creditLimit = creditLimit;
    }
    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
