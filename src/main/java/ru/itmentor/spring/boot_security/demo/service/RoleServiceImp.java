package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.repository.RoleRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<Role> listRole(List<String> rolesId) {
        List<Role> roleList = new ArrayList<>();
        for (String id: rolesId) {
            roleList.add(getRoleById(Long.parseLong(id)));
        }
        return roleList;
    }
}
