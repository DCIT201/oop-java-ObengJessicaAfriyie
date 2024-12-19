package Assignment1;

    public class Truck extends Vehicle {
        private double numberOfLoad;

        public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable, double numberOfLoad) {
            super(vehicleId, model, baseRentalRate, isAvailable);
            if (numberOfLoad <= 0) {
                throw new IllegalArgumentException("number of loads  must be positive");
            }
            this.numberOfLoad = numberOfLoad;
        }

        public double getLoadCapacity() {
            return numberOfLoad;
        }

        public void setLoadCapacity(double loadCapacity) {
            if (numberOfLoad <= 0) {
                throw new IllegalArgumentException("number of loads must be positive");
            }
            this.numberOfLoad = numberOfLoad;
        }

        @Override
        public double calculateRentalCost(int days) {
            return getBaseRentalRate() * days + numberOfLoad * 10;
        }

        @Override
        public boolean isAvailableForRental() {
            return isAvailable();
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "vehicleId='" + getVehicleId() + '\'' +
                    ", model='" + getModel() + '\'' +
                    ", baseRentalRate=" + getBaseRentalRate() +
                    ", isAvailable=" + isAvailable() +
                    ", loadCapacity=" + numberOfLoad +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Truck)) return false;
            if (!super.equals(o)) return false;
            Truck truck1 = (Truck) o;
            return Double.compare(truck1.numberOfLoad, numberOfLoad) == 0;
        }

        @Override
        public int hashCode() {
            return 31 * super.hashCode() + Double.hashCode(numberOfLoad);
        }
    }

