package com.codegym.repository;

import com.codegym.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepository extends PagingAndSortingRepository<Role,Long> {
}
