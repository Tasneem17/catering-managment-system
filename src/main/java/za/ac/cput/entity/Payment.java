package za.ac.cput.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
    public int length;
    @NotNull @Id
    private String payment_id;
    private String payment_name;
    private String payment_description;

    private Payment() {}

    //private constructor
    private Payment(Payment.Builder builder) {
        this.payment_id = builder.payment_id;
        this.payment_name = builder.payment_name;
        this.payment_description = builder.payment_description;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public String getPayment_description() {
        return payment_description;
    }

    public void setPayment_description(String payment_description) {
        this.payment_description = payment_description;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id='" + payment_id + '\'' +
                ", payment_name='" + payment_name + '\'' +
                ", payment_description='" + payment_description + '\'' +
                '}';
    }
    public static class Builder {
        private String payment_id;
        private String payment_name;
        private String payment_description;

        public Builder setPayment_id(String payment_id) {
            this.payment_id = payment_id;
            return this;
        }

        public Builder setPayment_name(String payment_name) {
            this.payment_name = payment_name;
            return this;
        }

        public Builder setPayment_description(String payment_description) {
            this.payment_description = payment_description;
            return this;
        }

        public Payment.Builder copy(Payment payment){
            this.payment_id= payment.payment_id;
            this.payment_name = payment.payment_name;
            this.payment_description = payment.payment_description;
            return this;
        }
        public Payment build(){
            return new Payment(this);
        }
    }
}
