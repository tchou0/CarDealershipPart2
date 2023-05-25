package org.example.dealership;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.example.contract.ContractFileManager;
import org.example.contract.LeaseContract;
import org.example.contract.SalesContract;

public class UserInterface {

    Dealership dealership;
    private DealershipFileManager fileManager;
    Vehicle vehicle;
    ContractFileManager contractFileManager;
    SalesContract salesContract;
    LeaseContract leaseContract;

    public UserInterface(){
        this.contractFileManager = new ContractFileManager();
    }

    Scanner scanner = new Scanner(System.in);

    // CREATING THE PRIVATE INIT METHOD ======================

    private void init() {
        fileManager = new DealershipFileManager();
        dealership = fileManager.getDealerships();
    }

    // ======================= DISPLAY ===============================
    public void display() {
        init();
        helper();
    }

    // ====================== HELPER METHOD ======================
    private void helper() {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(ColorCodes.TEXT_PURPLE + "\n*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*= Welcome to "
                    + dealership.getName() + "! =*=*=**=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                    + ColorCodes.ANSI_RESET);
            System.out.print(
                    ColorCodes.TEXT_BLUE + "\n[1] Get by Price\n" +
                            "[2] Get by Make and Model\n" +
                            "[3] Get by Year\n" +
                            "[4] Get by Color\n" +
                            "[5] Get by Mileage\n" +
                            "[6] Get by Vehicle Type\n" +
                            "[7] List All Vehicles\n" +
                            "[8] Add a Vehicle\n" +
                            "[9] Remove a Vehicle\n" +
                            "[10] Sell/Lease a vehicle\n" +
                            "[99] Exit" + ColorCodes.ANSI_RESET);

            System.out.print(ColorCodes.TEXT_YELLOW + "\n\nEnter your choice: " + ColorCodes.ANSI_RESET);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    processGetByPrice();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehicle();
                    break;
                case 8:
                    processAddVehicleRequest();

                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSellOrLeaseRequest();
                    break;

                case 99:
                    System.out.println(ColorCodes.TEXT_RED + "Exiting...\n" + ColorCodes.ANSI_RESET);
                    System.exit(0);
                default:
                    System.out
                            .println(ColorCodes.TEXT_RED + "Invalid choice! Please try again." + ColorCodes.ANSI_RESET);
                    display();
            }

        } while (true);
    }

    // ===================== METHODS ==============================

    public void showVehicles(List<Vehicle> vehicles) {
        System.out.println(ColorCodes.CYAN_BOLD_BRIGHT
                + "\nVIN        YEAR    MAKE                 MODEL                       TYPE           COLOR          MILES           PRICE   "
                + ColorCodes.ANSI_RESET);
        System.out.println(ColorCodes.TEXT_YELLOW
                + "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+"
                + ColorCodes.ANSI_RESET);
        for (Vehicle v : vehicles) {
            System.out.printf(
                    ColorCodes.ANSI_PINK + "%-10d %-7d %-20s %-15s %15s %15s %15d %15.2f \n" + ColorCodes.ANSI_RESET,
                    v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(),
                    v.getOdometer(), v.getPrice());
        }
    }

    public void processGetByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ColorCodes.TEXT_RED + "Type the min price: ");
        int minPrice = scanner.nextInt();
        System.out.print("Type the max price: " + ColorCodes.ANSI_RESET);
        int maxPrice = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        showVehicles(vehicles);

    }

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ColorCodes.TEXT_RED + "Type the make of the vehicle: ");
        String vehicleMake = scanner.next();
        System.out.print("Type the vehicle model: " + ColorCodes.ANSI_RESET);
        String vehicleModel = scanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel);
        showVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ColorCodes.TEXT_RED + "\nType the min vehicle year: ");
        int minYear = scanner.nextInt();
        System.out.print("Type the vehicle max year: " + ColorCodes.ANSI_RESET);
        int maxYear = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        showVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ColorCodes.TEXT_RED + "Enter color: " + ColorCodes.ANSI_RESET);
        String colorname = scanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(colorname);
        showVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ColorCodes.TEXT_RED + "\nType the min vehicle mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Type the vehicle max mileage: " + ColorCodes.ANSI_RESET);
        int maxMileage = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        showVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ColorCodes.TEXT_RED + "\nType the vehicle Model: " + ColorCodes.ANSI_RESET);
        String vehicleType = scanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        showVehicles(vehicles);
    }

    public void processGetAllVehicle() {
        List<Vehicle> allVehicle = dealership.getAllVehicles();
        showVehicles(allVehicle);
    }

    public void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ColorCodes.TEXT_YELLOW + "\nYou're adding a new vehicle!" + ColorCodes.ANSI_RESET);
        System.out.print(ColorCodes.TEXT_RED + "\nEnter Vin: ");
        int vinInput = scanner.nextInt();
        System.out.print("Enter Year: ");
        int yearInput = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Make: ");
        String makeInput = scanner.next();
        System.out.print("Enter Model: ");
        String modelInput = scanner.next();
        System.out.print("Enter Vehicle Type: ");
        String typeInput = scanner.next();
        System.out.print("Enter Vehicle Color: ");
        String colorInput = scanner.next();
        System.out.print("Enter Vehicle's odometer: ");
        int odometerInput = scanner.nextInt();
        System.out.print("Enter Vehicle's price: $" + ColorCodes.ANSI_RESET);
        double priceInput = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vinInput, yearInput, makeInput, modelInput, typeInput, colorInput, odometerInput,
                priceInput);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(dealership);
        System.out.println(ColorCodes.TEXT_RED + "**** Vehicle successfully added!! ****" + ColorCodes.ANSI_RESET);
    }

    public void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ColorCodes.TEXT_YELLOW + "Please input the VIN that you would like to remove: "
                + ColorCodes.ANSI_RESET);
        int vinInput = scanner.nextInt();

        Vehicle v = dealership.getVehicleByVin(vinInput);

        if (v != null) {
            dealership.removeVehicle(v);
            fileManager.saveDealership(dealership);
            System.out
                    .println(ColorCodes.TEXT_RED + "**** Vehicle successfully removed!! ****" + ColorCodes.ANSI_RESET);

        }
    }

    public void processSellOrLeaseRequest() {
        LocalDate date = LocalDate.now();
        
        System.out.println(ColorCodes.TEXT_RED +"\nPlease type the vehicle's Vin #: ");
        int vinNumber = scanner.nextInt();
        scanner.nextLine();
        for(Vehicle v: dealership.getAllVehicles()){
            if(v.getVin() == vinNumber){
                vehicle = v;
            }
        }

            System.out.println("\nPlease type the customer name: \n");
            String name = scanner.nextLine();
        System.out.println("\nType the email address: ");
        String email = scanner.nextLine();
        System.out.println("\nWould you like to sell or lease a vehicle? [Sell/Lease]\n");
        String answer = scanner.next();
        
        if (answer.equalsIgnoreCase("sell")) {
            boolean isFinanced;
            
            System.out.println("\nIs the customer financing? [y/n]");
            String financingOption = scanner.next();
            if(financingOption.equalsIgnoreCase("y")){
                isFinanced = true;
                }
            else{
                isFinanced = false;
            }
                
            salesContract = new SalesContract(date, name, email, vehicle, isFinanced);

            contractFileManager.saveContract(salesContract);
            
            dealership.removeVehicle(vehicle);
            
            fileManager.saveDealership(dealership);
            
            System.out.println("******* Process complete ********");
            
        } else if (answer.equalsIgnoreCase("lease")) {
            leaseContract = new LeaseContract(date, name, email, vehicle);

            contractFileManager.saveContract(leaseContract);
            dealership.removeVehicle(vehicle);
            fileManager.saveDealership(dealership);
        }
        else {
            System.out.println("That is not a valid VIN #");
            System.exit(0);
        }

    }

}
