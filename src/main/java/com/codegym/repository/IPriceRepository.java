package com.codegym.repository;

import com.codegym.model.Price;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepository extends PagingAndSortingRepository<Price,Long> {
}
