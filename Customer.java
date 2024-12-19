package Assignment1;

public class Customer {
        private String name;
        private String contactInfo;

        public Customer(String name, String contactInfo) {
            this.name = name;
            this.contactInfo = contactInfo;
        }

        public String getName() {
            return name;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", contactInfo='" + contactInfo + '\'' +
                    '}';
        }
}
