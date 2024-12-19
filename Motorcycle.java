package Assignment1;

public class Motorcycle extends Vehicle {
        private boolean hasSaddleBag;

        public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable, boolean hasSaddleBag) {
            super(vehicleId, model, baseRentalRate, isAvailable);
            this.hasSaddleBag = hasSaddleBag;
        }

        public boolean hasSaddleBag() {
            return hasSaddleBag;
        }

        public void setHasSidecar(boolean hasSaddleBag) {
            this.hasSaddleBag = hasSaddleBag;
        }

        @Override
        public double calculateRentalCost(int days) {
            return getBaseRentalRate() * days + (hasSaddleBag ? 15 : 0);
        }

        @Override
        public boolean isAvailableForRental() {
            return isAvailable();
        }

        @Override
        public String toString() {
            return "Motorcycle{" +
                    "vehicleId='" + getVehicleId() + '\'' +
                    ", model='" + getModel() + '\'' +
                    ", baseRentalRate=" + getBaseRentalRate() +
                    ", isAvailable=" + isAvailable() +
                    ", hasSaddleBag=" + hasSaddleBag +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Motorcycle)) return false;
            if (!super.equals(o)) return false;
            Motorcycle m1 = (Motorcycle) o;
            return hasSaddleBag == m1.hasSaddleBag;
        }

        @Override
        public int hashCode() {
            return 31 * super.hashCode() + (hasSaddleBag ? 1 : 0);
        }
    }



