package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();
    public Role getRoleById(int Id);

}
