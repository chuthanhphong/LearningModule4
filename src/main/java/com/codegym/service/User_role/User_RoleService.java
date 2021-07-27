package com.codegym.service.User_role;

import com.codegym.model.User_role;
import com.codegym.repository.IRoleRepository;
import com.codegym.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class User_RoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Override
    public Iterable<User_role> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<User_role> findById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public void save(User_role user_role) {
        userRoleRepository.save(user_role);
    }

    @Override
    public void delete(Long id) {
        userRoleRepository.deleteById(id);
    }
}
