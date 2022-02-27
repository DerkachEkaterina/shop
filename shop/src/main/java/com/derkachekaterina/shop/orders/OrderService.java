package com.derkachekaterina.shop.orders;


import com.derkachekaterina.shop.rest.dto.orderRequest.Order;
import com.derkachekaterina.shop.rest.dto.orderRequest.OrderForAdmin;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    List<OrderForAdmin> getOrders();

    OrderForAdmin getOrderById(Long id);

    void changeStatus(Long id, OrderStatus orderStatus);

    void deleteOrderById(Long id);
}
