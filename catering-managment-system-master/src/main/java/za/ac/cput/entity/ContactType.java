/* ContactType.java
 Entity for the ContactType
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.entity;

public class ContactType {
    private String contactTypeId;
    private String contactTypeName;
    private String contactTypeDescription;

    private ContactType() {}

    private ContactType(Builder builder){
        this.contactTypeId = builder.contactTypeId;
        this.contactTypeName = builder.contactTypeName;
        this.contactTypeDescription = builder.contactTypeDescription;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(String contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getContactTypeName() {
        return contactTypeName;
    }

    public void setContactTypeName(String contactTypeName) {
        this.contactTypeName = contactTypeName;
    }

    public String getContactTypeDescription() {
        return contactTypeDescription;
    }

    public void setContactTypeDescription(String contactTypeDescription) {
        this.contactTypeDescription = contactTypeDescription;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "contactTypeId='" + contactTypeId + '\'' +
                ", contactTypeName='" + contactTypeName + '\'' +
                ", contactTypeDescription='" + contactTypeDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String contactTypeId;
        private String contactTypeName;
        private String contactTypeDescription;

        public Builder setContactTypeId(String contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }

        public Builder setContactTypeName(String contactTypeName) {
            this.contactTypeName = contactTypeName;
            return this;
        }

        public Builder setContactTypeDescription(String contactTypeDescription) {
            this.contactTypeDescription = contactTypeDescription;
            return this;
        }

        public Builder copy(ContactType contactType) {
            this.contactTypeId = contactType.contactTypeId;
            this.contactTypeName = contactType.contactTypeName;
            this.contactTypeDescription = contactType.contactTypeDescription;
            return this;
        }

        public ContactType build(){
            return new ContactType(this);
        }
    }

}
