package za.ac.cput.service;

import za.ac.cput.entity.Role;

import java.util.List;

public interface RoleService extends IService<Role, String>{

    void deleteById(String id);

    List<Role> findAll();
}
