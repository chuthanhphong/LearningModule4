package com.codegym.service.food.order;

import com.codegym.repository.IOrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private IOrderRepository orderRepository;

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

//    @Override
//    public List<Order> findByName(String name) {
//        List<Order> list = new ArrayList<>();
//        for (Order club : orderRepository.findAll()) {
//            if (Order.getName().equals(name)) {
//                list.add(Order);
//            }
//        }
//        return list;
//    }
}