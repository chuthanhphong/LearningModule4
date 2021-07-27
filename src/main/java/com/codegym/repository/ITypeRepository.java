package com.codegym.repository;

import com.codegym.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITypeRepository extends PagingAndSortingRepository<Type,Long> {
}
