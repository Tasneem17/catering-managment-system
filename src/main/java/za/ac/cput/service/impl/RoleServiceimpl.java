package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Role;
import za.ac.cput.repository.RoleRepository;
import za.ac.cput.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceimpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceimpl(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Optional<Role> read(String s) {
        return this.roleRepository.findById(s);
    }

    @Override
    public boolean delete(Role role) {
        this.roleRepository.delete(role);
        return false;
    }

    public void deleteById(String id){
        this.roleRepository.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
       return this.roleRepository.findAll();
    }
}
