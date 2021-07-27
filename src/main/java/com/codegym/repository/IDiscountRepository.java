package com.codegym.repository;

import com.codegym.model.Discount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscountRepository extends PagingAndSortingRepository<Discount,Long> {
}
