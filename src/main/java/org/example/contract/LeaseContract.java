package org.example.contract;

import java.time.LocalDate;

import org.example.dealership.Vehicle;

public class LeaseContract extends Contract{

    //================== LEASE CONTRACT PROPERTIES =======================
    private double expectedEndingValue;
    private double leaseFee;

    //================================= LEASE CONTRACT CONSTRUCTOR ============================
    public LeaseContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold){
        super(date, customerName, customerEmail, vehicleSold);

    }

    //======================= SETTERS AND GETTERS ==================================


    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        return price + (price / 2) + (price * .07);
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPayment;
        double interestRate = 4.0 / 36;
        monthlyPayment = getVehicleSold().getPrice() * interestRate / 1 - Math.pow(1 + interestRate, -(3 * 36));
        
        

        return monthlyPayment;
    }

    @Override
    public String saleString(){
        return "LEASE|" + getDate() + "|" + getCustomerName() + 
        "|" + getCustomerEmail() + "|" + getVehicleSold().getVin() + 
        "|" + getVehicleSold().getVin()+ "|" + getVehicleSold().getYear() + 
        "|" + getVehicleSold().getMake() + "|" + getVehicleSold().getModel()+
        "|" + getVehicleSold().getVehicleType() + "|" + getVehicleSold().getColor() +
        "|" + getVehicleSold().getOdometer() + "|" + getVehicleSold().getPrice() + 
        "|" + getExpectedEndingValue() + "|" + getLeaseFee() + 
        "|" + getTotalPrice() + "|" + getMonthlyPayment();
    }
    

}
