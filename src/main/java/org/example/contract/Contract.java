package org.example.contract;

import java.time.LocalDate;

import org.example.dealership.Vehicle;

public abstract class Contract {

    private LocalDate date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold){
        this.date = date;
        this. customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
    }
    public String getCustomerEmail(){
        return customerEmail;
    }

    public void setVehicleSold(Vehicle vehicleSold){
        this.vehicleSold = vehicleSold;
    }
    public Vehicle getVehicleSold(){
        return vehicleSold;
    }


    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public abstract String saleString();
}
