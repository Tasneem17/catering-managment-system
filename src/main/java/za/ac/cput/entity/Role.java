/*  Role.java
    Entity for the Role
    Author: Wilbur Deano Smith (220003033)
    Date: 10 April 2022
*/
package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Role implements Serializable
{
    @Id private String roleID;
    private String roleName;
    private String roleDescription;

    protected Role(){}

    private Role(Builder builder)
    {
        this.roleID = builder.roleID;
        this.roleName = builder.roleName;
        this.roleDescription = builder.roleDescription;
    }

    public String getRoleID()
    {
        return roleID;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public String getRoleDescription()
    {
        return roleDescription;
    }

    public static class Builder
    {
        private String roleID;
        private String roleName;
        private String roleDescription;

        public Builder setRoleID(String roleID)
        {
            this.roleID = roleID;
            return this;
        }

        public Builder setRoleName(String roleName)
        {
            this.roleName = roleName;
            return this;
        }

        public Builder setRoleDescription(String roleDescription)
        {
            this.roleDescription = roleDescription;
            return this;
        }

        public Builder copy(Role role)
        {
            this.roleID = role.roleID;
            this.roleName = role.roleName;
            this.roleDescription = role.roleDescription;
            return this;
        }

        public Role build()
        {
            return new Role (this);
        }
    }
}
