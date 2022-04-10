/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 *Entity:UserContact
 */

package za.ac.cput.entity;


public class UserContact {
    private String userId;
    private String contactTypeId;
    private String contactDetails;

    private UserContact(Builder builder){
        this.userId = builder.userId;
        this.contactTypeId = builder.contactTypeId;
        this.contactDetails= builder.contactDetails;


    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(String contactTypeId) {
        this.contactTypeId = contactTypeId;
    }


    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }


    @Override
    public String toString() {
        return "UserContact{" +
                "userId='" + userId + '\'' +
                ", contactTypeId='" + contactTypeId + '\'' +
                ", contactDetails=" + contactDetails +
                '}';
    }

    public static class Builder{

        private String userId;
        private String contactTypeId;
        private  String contactDetails;

        public Builder setUserId(String userId){
            this.userId = userId;
            return this;
        }
        public Builder setContactTypeId(String contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }



        public Builder setContactDetails(String contactDetails){
            this.contactDetails = contactDetails;
            return this;

        }

        public Builder copy(UserContact Event){
            this.userId =Event.userId;
            this.contactTypeId =Event.contactTypeId;
            this.contactDetails = Event.contactDetails;
            return this;
        }
        public UserContact build(){
            return new UserContact(this);


        }
    }
}