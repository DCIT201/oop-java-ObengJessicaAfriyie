package Assignment1;

public class Main {
        public static void main(String[] args) {
            Vehicle car = new Car("C123", "Toyota Camry", 50, true, 5);
            Vehicle motorcycle = new Motorcycle("M456", "Harley Davidson", 30, true, false);
            Vehicle truck = new Truck("T789", "Volvo Truck", 100, true, 20);

            Customer customer = new Customer("Jessy Dan", "jedan.doe@example.com");

            Vehicle[] vehicles = {car, motorcycle, truck};

            for (Vehicle vehicle : vehicles) {
                vehicle.rent(customer, 5);
                System.out.println(vehicle);
                System.out.println("Rental cost: $" + vehicle.calculateRentalCost(5));
                vehicle.returnVehicle();
                System.out.println();
            }
        }
    }
