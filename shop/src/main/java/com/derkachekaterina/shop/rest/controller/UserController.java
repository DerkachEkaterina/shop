package com.derkachekaterina.shop.rest.controller;


import com.derkachekaterina.shop.exception.UserExistException;
import com.derkachekaterina.shop.goods.CakeService;
import com.derkachekaterina.shop.orders.OrderService;
import com.derkachekaterina.shop.orders.PurchaseService;
import com.derkachekaterina.shop.rest.dto.cake.CakeMoreInfo;
import com.derkachekaterina.shop.rest.dto.cake.Cakes;
import com.derkachekaterina.shop.rest.dto.orderRequest.Order;
import com.derkachekaterina.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated//для групового уровня для проверки уровня метода
//@RequestMapping ("v1/cakes")
public class UserController {
    private final UserService userService;
    private final CakeService cakeService;
    private final PurchaseService purchaseService;
    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, PurchaseService purchaseService, OrderService orderService, CakeService cakeService) {
        this.userService = userService;
        this.cakeService = cakeService;
        this.purchaseService = purchaseService;
        this.orderService = orderService;

    }

    @GetMapping(value = "get-all-cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes() {
        return cakeService.getCakes();
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CakeMoreInfo getCakeById(@PathVariable Long id) {
        return cakeService.getMoreInfo(id);
    }


    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "add-order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void getOrCreateOrder(@RequestBody @Valid Order newOrder) throws UserExistException {
        //может получать фрагмент json-объекта из внешнего интерфейса
        userService.addUser(newOrder.getUser());
        orderService.addOrder(newOrder);
    }

}