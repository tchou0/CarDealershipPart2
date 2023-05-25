package org.example.dealership;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    // public Dealership dealership = getDealerships();


    public Dealership getDealerships(){

        Dealership dealership = null;
        ArrayList<Vehicle> vehicles = new ArrayList<>();


        try{
            FileReader fileReader = new FileReader("Dealerships.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            int lineNumber = 0;
            String input; 
            while((input = bufReader.readLine()) != null){
                String[] parts = input.split("\\|");
                if(lineNumber == 0){
                    //GETS INFORMATION FOR DEALSHIP 
                    String name = parts[0];
                    String address = parts[1];
                    String phone = parts[2];

                    dealership = new Dealership(name, address, phone);
                    
                }
                else{
                    //GET INFORMATION FOR VEHICLE
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, 
                                                vehicleType, color, odometer, price);
                    vehicles.add(vehicle);
                }
                lineNumber++;
            }
        }
        catch(IOException e){
            System.out.println("File not found!");
            System.exit(0);
        }
        if(dealership != null){
            for(Vehicle v: vehicles){
                dealership.addVehicle(v);
            }
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership){
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( "Dealerships.csv", false))){
                bufferedWriter.write(
                    dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");

                    for(Vehicle v : dealership.getAllVehicles()){
                        bufferedWriter.write(
                        v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" +
                        v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer()
                        + "|" + v.getPrice() + "\n");
                    }
            }
            catch(IOException e){
                System.out.println("File not found!");
                System.exit(0);
            }
    };
    Vehicle parseVehicle(String string){

        String[] split = string.split("\\|");

        int vin = Integer.parseInt(split[0]);
        int year = Integer.parseInt(split[1]);
        String make = split[2];
        String model = split[3];
        String vehicleType = split[4];
        String color = split[5];
        int odometer = Integer.parseInt(split[6]);
        double price = Double.parseDouble(split[7]);

        Vehicle vehicle = new Vehicle(vin, year, make, model,
                vehicleType, color, odometer, price);
        return vehicle;
    }

    
}






