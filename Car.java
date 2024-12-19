package Assignment1;

public class Car extends Vehicle{
    private int seatNumber;

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, int seatNumber) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        if (seatNumber <= 0) {
            throw new IllegalArgumentException("Seating capacity must be positive");
        }
        this.seatNumber = seatNumber;
    }
    // Providing Getters and Setters

    public int getSeatCapacity() {
        return seatNumber;
    }

    public void setSeatCapacity(int seatNumber) {
        if(seatNumber <= 0){
    throw new IllegalArgumentException("Number of seat must be positive");
        }
        this.seatNumber = seatNumber;
    }
    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (seatNumber > 5 ? 50 : 0);
    }
    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String toString() {
        return "Car{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", isAvailable=" + isAvailable() +
                ", seatingCapacity=" + seatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car1 = (Car) o;
        return seatNumber == car1.seatNumber;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + seatNumber;
    }

}
