package com.codegym.repository;

import com.codegym.model.User_role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepository extends PagingAndSortingRepository<User_role,Long> {
}
