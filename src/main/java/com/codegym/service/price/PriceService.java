package com.codegym.service.price;

import com.codegym.model.Price;
import com.codegym.model.Restaurant;
import com.codegym.repository.IPriceRepository;
import com.codegym.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceService implements IPriceService {
    @Autowired
    private IPriceRepository priceRepository;

    @Override
    public Iterable<Price> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public Optional<Price> findById(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public void save(Price price) {
        priceRepository.save(price);
    }

    @Override
    public void delete(Long id) {
        priceRepository.deleteById(id);
    }
}
