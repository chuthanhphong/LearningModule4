package com.codegym.repository;

import com.codegym.model.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends PagingAndSortingRepository<Tag,Long> {
}
