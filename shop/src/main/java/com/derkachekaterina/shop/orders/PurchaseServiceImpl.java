package com.derkachekaterina.shop.orders;


import com.derkachekaterina.shop.goods.CakeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//используется для маркировки компонентов бизнес-уровня
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity, Integer count) {
        PurchaseEntity purchase = new PurchaseEntity();
        purchase.setNumber(count);
        purchase.setOrder(orderEntity);
        purchase.setCake(cakeEntity);
        purchaseRepository.saveAndFlush(purchase);
    }
}
