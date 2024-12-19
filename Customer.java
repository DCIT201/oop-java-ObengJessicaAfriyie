package Assignment1;

public class Customer implements LoyaltyProgram{
        private String name;
        private String contactInfo;
        private int loyaltyPoints;
        private double averageRating;
        private int ratingCount;

        public Customer(String name, String contactInfo) {
            this.name = name;
            this.contactInfo = contactInfo;
            this.loyaltyPoints = 0;
            this.averageRating = 0.0;
            this.ratingCount = 0;
        }

        public String getName() {
            return name;
        }

        public String getContactInfo() {
            return contactInfo;
        }
        @Override
    public void addLoyaltyPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.loyaltyPoints += points;
    }

    @Override
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public void redeemPoints(int points) {
        if (points > loyaltyPoints) {
            throw new IllegalArgumentException("Not enough loyalty points to redeem.");
        }
        this.loyaltyPoints -= points;
    }

    public void rate(double rating) {
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
        this.averageRating = (this.averageRating * ratingCount + rating) / (++ratingCount);
    }

    public double getAverageRating() {
        return averageRating;
    }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", contactInfo='" + contactInfo + '\'' +
                    ", loyaltyPoints=" + loyaltyPoints +
                    ", averageRating=" + averageRating +
                    '}';
        }
}
