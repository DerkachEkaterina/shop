package com.derkachekaterina.shop.goods;


import com.derkachekaterina.shop.rest.dto.cake.CakeFullInf;
import com.derkachekaterina.shop.rest.dto.cake.Cakes;

public interface CakesService {
    Cakes getCakes();
    CakeFullInf getCake(Long id);
    CakeEntity getCakeEntity(Long id);
    Long addCake(CakeFullInf cake);
    void deleteCake(Long id);
}