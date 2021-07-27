package com.codegym.service.food.order;

import com.codegym.service.food.IGeneralService;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import java.awt.*;

public interface IOrderService extends IGeneralService<Order> {

    List<Order> findByName(String name);
}