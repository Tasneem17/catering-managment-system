package za.ac.cput.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPayment {
    @NotNull
    @Id
    private String id;
    private String typeID;
    private String amount;

    private UserPayment() {
    }

    private UserPayment(UserPayment.Builder builder) {
        this.id = builder.id;
        this.typeID = builder.typeID;
        this.amount = builder.amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UserPayment{" +
                "id='" + id + '\'' +
                ", typeID='" + typeID + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
    public static class Builder {
        private String id;
        private String typeID;
        private String amount;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTypeID(String typeID) {
            this.typeID = typeID;
            return this;
        }

        public Builder setAmount(String amount) {
            this.amount = amount;
            return this;
        }
        public UserPayment.Builder copy(UserPayment userpayment){
            this.id= userpayment.id;
            this.typeID= userpayment.typeID;
            this.amount= userpayment.amount;
            return this;
        }
        public UserPayment build(){
            return new UserPayment(this);
        }
    }

}
