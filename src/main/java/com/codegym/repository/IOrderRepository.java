package com.codegym.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;

@Repository
public interface IOrderRepository extends PagingAndSortingRepository<Order,Long> {
}