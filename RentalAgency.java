package Assignment1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class RentalAgency {
        private String agencyName;
        private List<Vehicle> fleet;
        private List<RentalTransaction> transactions;

        public RentalAgency(String agencyName) {
            this.agencyName = agencyName;
            this.fleet = new ArrayList<>();
            this.transactions = new ArrayList<>();
        }

        public void addVehicle(Vehicle vehicle) {
            fleet.add(vehicle);
        }

        public void rentVehicle(String vehicleId, Customer customer, int days) {
            Vehicle vehicle = fleet.stream()
                    .filter(v -> v.getVehicleId().equals(vehicleId) && v.isAvailable())
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle not available or does not exist."));
            String transactionId = "TX-" + (transactions.size() + 1);
            RentalTransaction transaction = new RentalTransaction(transactionId, vehicle, customer, days, LocalDate.now());
            transactions.add(transaction);
            vehicle.rent(customer, days);
            System.out.println("Rental processed: " + transaction);
        }

        public void returnVehicle(String vehicleId) {
            Vehicle vehicle = fleet.stream()
                    .filter(v -> v.getVehicleId().equals(vehicleId) && !v.isAvailable())
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle is not rented."));
            vehicle.returnVehicle();
            System.out.println("Vehicle returned: " + vehicle.getModel());
        }

        public List<Vehicle> getAvailableVehicles() {
            return fleet.stream().filter(Vehicle::isAvailable).collect(Collectors.toList());
        }

        public List<RentalTransaction> getTransactionHistory() {
            return new ArrayList<>(transactions);
        }

        public void generateReport() {
            System.out.println("===== Rental Agency Report =====");
            System.out.println("Agency Name: " + agencyName);
            System.out.println("Fleet Size: " + fleet.size());
            System.out.println("Available Vehicles: " + getAvailableVehicles().size());
            System.out.println("Total Transactions: " + transactions.size());
            System.out.println("Transaction History:");
            transactions.forEach(System.out::println);
            System.out.println("================================");
        }
}
