package pe.edu.upc.aww.takemehome0_0.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.Role;
import pe.edu.upc.aww.takemehome0_0.repositories.IRoleRepository;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.IRolesService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRolesService {

    @Autowired
    private IRoleRepository rR;

    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

}
