package com.salceda.ToDo.Service.Implemetation;

import com.salceda.ToDo.Exception.RoleNotFoundException;
import com.salceda.ToDo.Interface.RoleRepository;
import com.salceda.ToDo.Model.Role;
import com.salceda.ToDo.Service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(long id) throws RoleNotFoundException {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with ID " + id + " not found."));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(long id, Role updatedRole) throws RoleNotFoundException {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with ID " + id + " not found."));
        existingRole.setName(updatedRole.getName());
        return existingRole;
    }

    @Override
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }
}
