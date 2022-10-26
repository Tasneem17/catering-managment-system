/*  UserRole.java
    Entity for the UserRole
    Author: Wilbur Deano Smith (220003033)
    Date: 10 April 2022
*/
package za.ac.cput.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(UserRole.UserRoleId.class)
public class UserRole implements Serializable
{
    @Id private String userID;
    @Id private String roleID;

    protected UserRole(){}

    private UserRole(Builder builder)
    {
        this.userID = builder.userID;
        this.roleID  = builder.roleID;
    }

    public String getUserID()
    {
        return userID;
    }

    public String getRoleID()
    {
        return roleID;
    }

    public static class Builder
    {
        private String userID;
        private String roleID;

        public Builder setUserID(String userID)
        {
            this.userID = userID;
            return this;
        }

        public Builder setRoleID(String roleID)
        {
            this.roleID = roleID;
            return this;
        }

        public Builder copy(UserRole userRole)
        {
            this.userID = userRole.userID;
            this.roleID = userRole.roleID;
            return this;
        }

        public UserRole build()
        {
            return new UserRole(this);
        }
    }
    public static class UserRoleId implements Serializable
    {
        private String userID;
        private String roleID;

        public UserRoleId(String userID, String roleID) {
            this.userID = userID;
            this.roleID = roleID;
        }

        public UserRoleId(){}

        public String getUserID() {
            return userID;
        }

        public String getRoleID() {
            return roleID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserRoleId that = (UserRoleId) o;
            return Objects.equals(userID, that.userID) && Objects.equals(roleID, that.roleID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userID, roleID);
        }
    }
}

