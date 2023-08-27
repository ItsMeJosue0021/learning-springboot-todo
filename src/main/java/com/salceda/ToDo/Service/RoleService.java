package com.salceda.ToDo.Service;

import com.salceda.ToDo.Model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(long id);
    List<Role> getAllRoles();
    Role updateRole(long id, Role updatedRole);
    void deleteRole(long id);
}
