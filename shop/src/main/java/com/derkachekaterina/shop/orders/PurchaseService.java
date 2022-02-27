package com.derkachekaterina.shop.orders;

import com.derkachekaterina.shop.goods.CakeEntity;



public interface PurchaseService {
    void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity, Integer count);
}
