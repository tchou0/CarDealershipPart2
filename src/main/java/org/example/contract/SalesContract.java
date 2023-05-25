package org.example.contract;

import java.time.LocalDate;

import org.example.dealership.Vehicle;

public class SalesContract extends Contract {



//=========================== CONSTRUCTOR FOR SALES CONTRACT =======================
    public SalesContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isfinanced){
    super(date,customerName,customerEmail,vehicleSold);
    //isfinanced is if the person wants to make a monthly payment
    this.isfinanced = isfinanced;
}

//============================== SALES CONTRACT PROPERTIES ============================
    double salesTax = .05;
    double recordingFee = 100;
    double processingFee;
    boolean isfinanced;

       //======================= SETTERS AND GETTERS =======================
    public double getSalesTax() {
        return getVehicleSold().getPrice() * salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean getIsfinanced() {
        return isfinanced;
    }

    public void setIsfinanced(boolean isfinanced) {
        this.isfinanced = isfinanced;
    }

    //========================== METHODS TO GET PRICE AND MONTHLY PAYMENT ===============
    @Override
    public double getTotalPrice(){
        if(getVehicleSold().getPrice() <= 10000){
            processingFee = 295;
        }
        else{
            processingFee = 495;
        }
        return getVehicleSold().getPrice() + getSalesTax() + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPayment;
        if(getIsfinanced()) {
            if(getVehicleSold().getPrice() <= 10000){
                double interestRate = (4.25/48);
                monthlyPayment = (getTotalPrice() * (interestRate)) / (1 - Math.pow(1 + (interestRate), -(4 * 48)));
            }
            else{
                double interestRate = (5.25/24);
                monthlyPayment = (getTotalPrice() * (interestRate)) / (1 - Math.pow(1 + (interestRate), -(2 * 24)));
            }
        }
        else{
            monthlyPayment = 0.0;
        }
        return monthlyPayment;
    }

    public String saleString(){
        return "SALE|" + getDate() + "|" + getCustomerName() + 
        "|" + getCustomerEmail() + "|" + getVehicleSold().getVin() + 
        "|" + getVehicleSold().getVin()+ "|" + getVehicleSold().getYear() + 
        "|" + getVehicleSold().getMake() + "|" + getVehicleSold().getModel()+
        "|" + getVehicleSold().getVehicleType() + "|" + getVehicleSold().getColor() +
        "|" + getVehicleSold().getOdometer() + "|" + getVehicleSold().getPrice() + 
        "|" + getSalesTax() + "|" + getRecordingFee() + "|" + getProcessingFee() + 
        "|" + getTotalPrice() + "|" + (getIsfinanced() ? "Yes" : "No")+
        "|" + getMonthlyPayment();
    }

}
