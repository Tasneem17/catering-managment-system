package za.ac.cput.service;

import za.ac.cput.entity.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole, UserRole.UserRoleId>{

    List<UserRole> findAll();
    UserRole findUserRoleByUserID(String userID);
    void deleteUserRoleByUserID(String userID);
}
