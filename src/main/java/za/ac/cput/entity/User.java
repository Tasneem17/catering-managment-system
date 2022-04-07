/*  User.java
    Entity for the User
    Author: Wilbur Deano Smith (220003033)
    Date: 7 April 2022
*/
package za.ac.cput.entity;

public class User
{

    private int userID;
    private String userFirstName;
    private String userLastName;

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public String getUserFirstName()
    {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName)
    {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName()
    {
        return userLastName;
    }

    public void setUserLastName(String userLastName)
    {
        this.userLastName = userLastName;
    }
}
