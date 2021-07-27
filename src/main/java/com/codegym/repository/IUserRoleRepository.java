package com.codegym.repository;

import com.codegym.model.User_role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRoleRepository extends PagingAndSortingRepository<User_role,Long> {
}
