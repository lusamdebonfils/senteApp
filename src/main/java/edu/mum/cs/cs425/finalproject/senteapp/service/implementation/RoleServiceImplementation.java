package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Role;
import edu.mum.cs.cs425.finalproject.senteapp.repository.RoleRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(int Id) {
        return roleRepository.findById(Id).orElse(null);
    }
}
