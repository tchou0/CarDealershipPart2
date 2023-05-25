package org.example.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {

    public static Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    // ================================== Constructor ========================
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
        
    }

    // ======================================== SETTERS ===================

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // =============================== Getter=========================
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }


    
    public List<Vehicle> getVehiclesByPrice(double min, double max){

        ArrayList<Vehicle> findVehicle = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                findVehicle.add(v);
            }
        }
        return findVehicle;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> findVehicle = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                findVehicle.add(v);
            }
        }
        return findVehicle;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> findVehicle = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                findVehicle.add(v);
            }
        }
        return findVehicle;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> findVehicle = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                findVehicle.add(v);
            }
        }
        return findVehicle;

    }

    public List<Vehicle> getVehiclesByMileage(double min, double max){
        ArrayList<Vehicle> findVehicle = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                findVehicle.add(v);
            }
        }
        return findVehicle;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> findVehicle = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)){
                findVehicle.add(v);
            }
        }
        return findVehicle;
    }

    public List<Vehicle> getAllVehicles(){

        return new ArrayList<>(inventory);
    }

    public void removeVehicle(Vehicle v){

        inventory.remove(v);
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
    }
    public Vehicle getVehicleByVin(int vin){
        Vehicle vehicle = null;
        for(Vehicle v: inventory){
            if(v.getVin() == vin){
                vehicle = v;
            }
        }
        return vehicle;
    }

}
