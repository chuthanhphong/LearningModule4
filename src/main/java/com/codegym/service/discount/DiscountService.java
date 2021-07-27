package com.codegym.service.discount;

import com.codegym.model.Discount;
import com.codegym.model.Tag;
import com.codegym.repository.IDiscountRepository;
import com.codegym.repository.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
    private IDiscountRepository discountRepository;

    @Override
    public Iterable<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void delete(Long id) {
        discountRepository.deleteById(id);
    }
}
