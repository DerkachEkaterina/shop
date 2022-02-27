package com.derkachekaterina.shop.rest.controller;


import com.derkachekaterina.shop.goods.AvailabilityOfCake;
import com.derkachekaterina.shop.goods.CakeService;
import com.derkachekaterina.shop.orders.OrderService;
import com.derkachekaterina.shop.orders.OrderStatusData;
import com.derkachekaterina.shop.rest.dto.cake.CakeMoreInfo;
import com.derkachekaterina.shop.rest.dto.orderRequest.OrderForAdmin;
import com.derkachekaterina.shop.users.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController//@Controller + @ResponseBody
@RequestMapping(value = "/admin-panel")//используется для мапинга (связывания)
// с URL для всего класса или для конкретного метода обработчика
public class AdminController {
    private OrderService orderService;
    private UserService userService;
    private CakeService cakeService;

    public AdminController(OrderService orderService, UserService userService, CakeService cakeService) {
        this.orderService = orderService;
        this.userService = userService;
        this.cakeService = cakeService;
    }

    @GetMapping("/admin-menu")//Обрабатывает get-запросы
    public ModelAndView getAdminMenu() {
        return new ModelAndView("menu");
    }


    @GetMapping("/admin-orders")
    public ModelAndView getAdminOrdersList() {
        ModelAndView modelAndView = new ModelAndView("orders");
        modelAndView.addObject("orders", orderService.getOrders());
        return modelAndView;
    }

    @GetMapping("/admin-cakes")
    public ModelAndView getAdminCakesList() {
        ModelAndView modelAndView = new ModelAndView("cakes");
        modelAndView.addObject("cakes", cakeService.getCakes().getCakeList());
        return modelAndView;
    }

    @GetMapping("/admin-users")
    public ModelAndView getAdminUsersList() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }


    @GetMapping("/admin-get-order/{id}")
    public ModelAndView getAdminOrderById(@PathVariable Long id) {//получает определенную часть из URI.
        ModelAndView modelAndView = new ModelAndView("order");
        OrderForAdmin orderForAdmin = orderService.getOrderById(id);
        modelAndView.addObject("order", orderForAdmin);
        System.out.println(orderForAdmin);
        return modelAndView;
    }

    @PostMapping("/admin-get-order/{id}")
    public RedirectView editOrder(@PathVariable Long id, OrderStatusData orderStatusData) {
        orderService.changeStatus(id, orderStatusData.getStatus());
        return new RedirectView(String.format("/admin-panel/admin-get-order/%d", id));
    }

    @GetMapping("/admin-get-order/delete/{id}")
    public RedirectView deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return new RedirectView("/admin-panel/admin-orders");
    }


    @GetMapping("/admin-get-cake/edit")
    public ModelAndView addingCake() {
        ModelAndView modelAndView = new ModelAndView("add-cake");
        modelAndView.addObject("cake", new CakeMoreInfo());
        return modelAndView;
    }

    @GetMapping(value = "cake/{id}")
    public ModelAndView getCakeById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cake");
        modelAndView.addObject("cake",cakeService.getCake(id));
        return modelAndView;
    }

    @GetMapping(value = "/admin-get-cake/delete/{id}")
    public RedirectView deleteCake(@PathVariable Long id){
        cakeService.deleteCake(id);
        return new RedirectView("/admin-panel/admin-cakes");
    }

    @PostMapping(value = "/admin-get-cake/edit")//Обрабатывает пост-запросы
    public RedirectView addCake(CakeMoreInfo cake){
        cake.setAvailabilityOfCake(AvailabilityOfCake.AVAILABLE);
        Long id = cakeService.addCake(cake);
        return new RedirectView("/admin-panel/cake/"+id.toString());
    }

}
