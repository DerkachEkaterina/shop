package com.derkachekaterina.shop.rest.dto.orderRequest;


import com.derkachekaterina.shop.orders.DeliveryMethod;
import com.derkachekaterina.shop.orders.OrderStatus;
import com.derkachekaterina.shop.orders.PaymentMethod;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Schema(description = "Order's admin data")
public class OrderForAdmin {
    private Long id;
    private String usersName;
    private String usersNumber;
    private String address;
    private LocalDateTime time;
    private DeliveryMethod deliveryMethod;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;
    private Map<Long, Integer> cakes;//id and count of cake in order
    private BigDecimal price;
    private String allCakesNames;
}
