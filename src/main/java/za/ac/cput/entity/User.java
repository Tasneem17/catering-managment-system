/*  User.java
    Entity for the User
    Author: Wilbur Deano Smith (220003033)
    Date: 7 April 2022
*/
package za.ac.cput.entity;

import lombok.Builder;

public class User
{

    private int userID;
    private String userFirstName;
    private String userLastName;

    @Builder
    public User(UserBuilder userBuilder)
    {
        this.userID = userBuilder.userID;
        this.userFirstName = userBuilder.userFirstName;
        this.userLastName = userBuilder.userLastName;
    }

    public int getUserID()
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


    public static class UserBuilder
    {
        private int userID;
        private String userFirstName;
        private String userLastName;

        public UserBuilder( int userID)
        {
            this.userID = userID;
        }

        public UserBuilder userFirstName ( String userFirstName)
        {
            this.userFirstName = userFirstName;
            return this;
        }

        public UserBuilder userLastName ( String userLastName)
        {
            this.userLastName = userLastName;
            return this;
        }

        public User build ()
        {
            User user = new User(this);
            return user;
        }
    }
}
