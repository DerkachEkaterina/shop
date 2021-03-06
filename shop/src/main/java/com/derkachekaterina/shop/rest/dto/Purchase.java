package com.derkachekaterina.shop.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Purchase {
    @NotNull
    Long id;

    @NotNull
    Integer num;
}
