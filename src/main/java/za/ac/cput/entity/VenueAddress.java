/* VenueAddress.java
 Entity for the VenueAddress
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

public class VenueAddress {
    @NotNull
    @Id
    private String venueAddressArea;
    private String venueAddressCity;
    private String venueAddressStreet;

    protected VenueAddress() {}

    private VenueAddress(Builder builder){
        this.venueAddressArea = builder.venueAddressArea;
        this.venueAddressCity = builder.venueAddressCity;
        this.venueAddressStreet = builder.venueAddressStreet;
    }

    public String getVenueAddressArea() {
        return venueAddressArea;
    }

    public void setVenueAddressArea(String venueAddressArea) {
        this.venueAddressArea = venueAddressArea;
    }

    public String getVenueAddressCity() {
        return venueAddressCity;
    }

    public void setVenueAddressCity(String venueAddressCity) {
        this.venueAddressCity = venueAddressCity;
    }

    public String getVenueAddressStreet() {
        return venueAddressStreet;
    }

    public void setVenueAddressStreet(String venueAddressStreet) {
        this.venueAddressStreet = venueAddressStreet;
    }

    @Override
    public String toString() {
        return "VenueAddress{" +
                "venueAddressArea='" + venueAddressArea + '\'' +
                ", venueAddressCity='" + venueAddressCity + '\'' +
                ", venueAddressStreet='" + venueAddressStreet + '\'' +
                '}';
    }

    public static class Builder {
        private String venueAddressArea;
        private String venueAddressCity;
        private String venueAddressStreet;

        public Builder setVenueAddressArea(String venueAddressArea) {
            this.venueAddressArea = venueAddressArea;
            return this;
        }

        public Builder setVenueAddressCity(String venueAddressCity) {
            this.venueAddressCity = venueAddressCity;
            return this;
        }

        public Builder setVenueAddressStreet(String venueAddressStreet) {
            this.venueAddressStreet = venueAddressStreet;
            return this;
        }

        public Builder copy(VenueAddress venueaddress) {
            this.venueAddressArea = venueaddress.venueAddressArea;
            this.venueAddressCity = venueaddress.venueAddressCity;
            this.venueAddressStreet = venueaddress.venueAddressStreet;
            return this;
        }

        public VenueAddress build(){
            return new VenueAddress(this);
        }
    }

}