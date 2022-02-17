package com.derkachekaterina.shop.goods;

import com.derkachekaterina.shop.dto.CakeFullInf;
import com.derkachekaterina.shop.dto.Cakes;

public interface CakesService {
    Cakes getCakes();
    CakeFullInf getCake(Long id);
}