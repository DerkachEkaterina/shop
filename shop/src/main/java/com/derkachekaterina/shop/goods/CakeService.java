package com.derkachekaterina.shop.goods;


import com.derkachekaterina.shop.rest.dto.cake.CakeMoreInfo;
import com.derkachekaterina.shop.rest.dto.cake.Cakes;

public interface CakeService {

    Cakes getCakes();

    CakeMoreInfo getMoreInfo(Long id);

    Long addCake(CakeMoreInfo cake);

    void deleteCake(Long id);

    CakeMoreInfo getCake(Long id);

}
