package com.company;
//constructors
public class BankAccount {
    private String accNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumer;

    public BankAccount(){
        this("67890", 5.00, "Default Name", "Default address", 11111);
        //the above statement must always be the first line in the empty constructor
        System.out.println("Empty constructor called");
    }
    public BankAccount(String accNumber, double balance, String customerName, String email, int phone){
        System.out.println("Account constructor with parameters called");//called before the latter statements of the empty constr
        this.accNumber = accNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumer = phone;
        //this is actually a better practice than setters because there could be times when the setters are not used
        //don't call setters inside the method --> probably the var has not been initialied or created for the object yet
    }

    public BankAccount(String customerName, String email, int phoneNumer) {
        this("99999", 100.55, customerName, email, phoneNumer); //came up with defaults and only the other ones are input by users
        //initialisation is done in one constructor and the default one calles the initialisation one for value setting of defaults
        this.customerName = customerName;
        this.email = email;
        this.phoneNumer = phoneNumer;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(int phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public void deposit(double monies){
        this.balance += monies;
        System.out.println("Deposit of " + monies + " made. New balance is: " + this.balance);
    }

    public void withdraw(double monies){
        if(monies > this.balance) System.out.println("not sufficient balance in account to withdraw. Acc balance " + this.balance);
        else{
            this.balance -= monies;
            System.out.println("Withdrawal processed. Acc balance now " + this.balance);
        }

    }

}
