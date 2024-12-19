package Assignment1;

import java.time.LocalDate;
public class RentalTransaction {
    // encapsulation
    private String transactionId;
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalCost;

        public RentalTransaction(String transactionId, Vehicle vehicle, Customer customer, int rentalDays, LocalDate rentalDate) {
            if (rentalDays <= 0) {
                throw new IllegalArgumentException("Rental days must be positive.");
            }
            this.transactionId = transactionId;
            this.vehicle = vehicle;
            this.customer = customer;
            this.rentalDays = rentalDays;
            this.rentalDate = rentalDate;
            this.returnDate = rentalDate.plusDays(rentalDays);
            this.totalCost = vehicle.calculateRentalCost(rentalDays);
        }

        public String getTransactionId() {
            return transactionId;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public Customer getCustomer() {
            return customer;
        }

        public LocalDate getRentalDate() {
            return rentalDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public double getTotalCost() {
            return totalCost;
        }

        @Override
        public String toString() {
            return "RentalTransaction{" +
                    "transactionId='" + transactionId + '\'' +
                    ", vehicle=" + vehicle.getModel() +
                    ", customer=" + customer.getName() +
                    ", rentalDays=" + rentalDays +
                    ", rentalDate=" + rentalDate +
                    ", returnDate=" + returnDate +
                    ", totalCost=" + totalCost +
                    '}';
        }
}
