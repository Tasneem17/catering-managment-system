/*  User.java
    Entity for the User
    Author: Wilbur Deano Smith (220003033)
    Date: 10 April 2022
*/
package za.ac.cput.entity;

public class User
{
    private String userID;
    private String userFirstName;
    private String userLastName;

    private User(Builder builder)
    {
        this.userID = builder.userID;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
    }

    public String getUserID()
    {
        return userID;
    }

    public String getUserFirstName()
    {
        return userFirstName;
    }

    public String getUserLastName()
    {
        return userLastName;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userID=" + userID +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                '}';
    }

    public static class Builder
    {
        private String userID;
        private String userFirstName;
        private String userLastName;

        public Builder setUserID(String userID)
        {
            this.userID = userID;
            return this;
        }

        public Builder setUserFirstName(String userFirstName)
        {
            this.userFirstName = userFirstName;
            return this;
        }

        public Builder setUserLastName(String userLastName)
        {
            this.userLastName = userLastName;
            return this;
        }

        public Builder copy(User user)
        {
            this.userID = user.userID;
            this.userFirstName = userFirstName;
            this.userLastName = user.userLastName;
            return this;
        }

        public User build()
        {
            return new User(this);
        }
    }
}
