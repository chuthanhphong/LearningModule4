package com.codegym.service.tag;

import com.codegym.model.Tag;
import com.codegym.repository.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class TagService implements ITagService{
    @Autowired
    ITagRepository iTagRepository;

    @Override
    public Iterable<Tag> findAll() {
        return iTagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return iTagRepository.findById(id);
    }

    @Override
    public void save(Tag tag) {
        iTagRepository.save(tag);
    }

    @Override
    public void delete(Long id) {
        iTagRepository.deleteById(id);
    }
}
