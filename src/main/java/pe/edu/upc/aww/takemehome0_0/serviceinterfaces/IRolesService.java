package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.Role;

import java.util.List;

public interface IRolesService {

    public void insert(Role role);
    public List<Role> list();
}
