package Assignment1;

public abstract class Vehicle implements Rentable {

    // Private encapsulated fields
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private Customer currentCustomer;
    private int rentalDays;

    // Constructors with validation
    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable ){
        if(vehicleId == null || vehicleId.isEmpty()){
            throw new IllegalArgumentException("Vehicle-id should not be null or empty ");
        }
        if(model==null || model.isEmpty()){
            throw new IllegalArgumentException("model should not be null or empty ");
        }
        if(baseRentalRate < 0){
            throw new IllegalArgumentException("baseRentalRate  should not be null or empty ");
        }
        this.vehicleId=vehicleId;
        this.model=model;
        this.baseRentalRate=baseRentalRate;
        this.isAvailable=isAvailable;
    }
    //Providing Getters

    public String getVehicleId() {
        return vehicleId;
    }
    public String getModel() {
        return model;
    }
    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable(){
        return isAvailableForRental();
    }
    // providing Setters

    public void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle-id should not be null or empty");
        }
        this.vehicleId = vehicleId;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model should not be null or empty");
        }
        this.model = model;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate < 0) {
            throw new IllegalArgumentException("Base rental rate should not be negative");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailable) {
            throw new IllegalStateException("Vehicle is not available for rental.");
        }
        this.currentCustomer = customer;
        this.rentalDays = days;
        this.isAvailable = false;
        System.out.println("Vehicle rented to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        if (isAvailable) {
            throw new IllegalStateException("Vehicle is not currently rented.");
        }
        System.out.println("Vehicle returned by " + currentCustomer.getName() + ".");
        this.currentCustomer = null;
        this.rentalDays = 0;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
    // Abstract methods for rental calculation
    public abstract double calculateRentalCost(int days);
    // Abstract methods for Availability
    public abstract boolean isAvailableForRental();
}




