/* Venue.java
 Entity for the Venue
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Venue {
    @NotNull
    @Id
    private String venueId;
    private String venueName;
    private String venueDescription;
    private double venuePrice;

    protected Venue() {}

    private Venue(Venue.Builder builder){
        this.venueId = builder.venueId;
        this.venueName = builder.venueName;
        this.venueDescription = builder.venueDescription;
        this.venuePrice = builder.venuePrice;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueDescription() {
        return venueDescription;
    }

    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }

    public double getVenuePrice() {
        return venuePrice;
    }

    public void setVenuePrice(double venuePrice) {
        this.venuePrice = venuePrice;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId='" + venueId + '\'' +
                ", venueName='" + venueName + '\'' +
                ", venueDescription='" + venueDescription + '\'' +
                ", venuePrice=" + venuePrice +
                '}';
    }

    public static class Builder {
        private String venueId;
        private String venueName;
        private String venueDescription;
        private double venuePrice;

        public Builder setVenueId(String venueId) {
            this.venueId = venueId;
            return this;
        }

        public Builder setVenueName(String venueName) {
            this.venueName = venueName;
            return this;
        }

        public Builder setVenueDescription(String venueDescription) {
            this.venueDescription = venueDescription;
            return this;
        }

        public Builder setVenuePrice(double venuePrice) {
            this.venuePrice = venuePrice;
            return this;
        }

        public Builder copy(Venue venue) {
            this.venueId = venue.venueId;
            this.venueName = venue.venueName;
            this.venueDescription = venue.venueDescription;
            this.venuePrice = venue.venuePrice;
            return this;
        }

        public Venue build(){
            return new Venue(this);
        }
    }

}
