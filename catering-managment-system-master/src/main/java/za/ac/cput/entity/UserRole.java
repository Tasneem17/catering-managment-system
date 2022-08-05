/*  UserRole.java
    Entity for the UserRole
    Author: Wilbur Deano Smith (220003033)
    Date: 10 April 2022
*/
package za.ac.cput.entity;

public class UserRole
{
    private String userID;
    private String roleID;

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
}

