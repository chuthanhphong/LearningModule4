package com.codegym.service.tag;

import com.codegym.model.Price;
import com.codegym.model.Tag;
import com.codegym.repository.IPriceRepository;
import com.codegym.repository.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService implements ITagService {
    @Autowired
    private ITagRepository tagRepository;

    @Override
    public Iterable<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}
