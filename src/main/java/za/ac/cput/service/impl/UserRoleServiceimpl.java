package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserRole;
import za.ac.cput.repository.UserRoleRepository;
import za.ac.cput.service.UserRoleService;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceimpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceimpl(UserRoleRepository userRoleRepository)
    {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return this.userRoleRepository.save(userRole);
    }

    @Override
    public Optional<UserRole> read(UserRole.UserRoleId userRoleId) {
        return this.userRoleRepository.findById(userRoleId);
    }

    @Override
    public boolean delete(UserRole userRole) {
        this.userRoleRepository.delete(userRole);
        return false;
    }

    @Override
    public List<UserRole> findAll() {
        return this.userRoleRepository.findAll();
    }

    @Override
    public UserRole findUserRoleByUserID(String userID) {
        return this.userRoleRepository.findUserRoleByUserID(userID);
    }

    @Override
    public void deleteUserRoleByUserID(String userID) {
        this.userRoleRepository.deleteUserRoleByUserID(userID);
    }
}
