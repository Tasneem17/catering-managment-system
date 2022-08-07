/* VenueChoice.java
 Entity for the VenueChoice
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class VenueChoice {
    @NotNull
    @Id
    private String venueId;
    private String venueType;

    protected VenueChoice() {
    }

    private VenueChoice(Builder builder) {
        this.venueId = builder.venueId;
        this.venueType = builder.venueType;
    }

    public String getVenueId() {
        return venueId;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    @Override
    public String toString() {
        return "VenueChoice{" +
                "venueId='" + venueId + '\'' +
                ", venueType='" + venueType + '\'' +
                '}';
    }

    public static class Builder {
        private String venueId;
        private String venueType;


        public Builder setVenueId(String venueId) {
            this.venueId = venueId;
            return this;
        }

        public Builder setVenueType(String venueType) {
            this.venueType = venueType;
            return this;
        }

        public Builder copy(VenueChoice venuechoice) {
            this.venueId = venuechoice.venueId;
            this.venueType = venuechoice.venueType;
            return this;
        }

        public VenueChoice build() {
            return new VenueChoice(this);
        }
    }
}