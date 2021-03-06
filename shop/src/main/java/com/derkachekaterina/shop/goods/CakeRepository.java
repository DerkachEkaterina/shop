package com.derkachekaterina.shop.goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<CakeEntity, Long> {
    boolean existsCakeEntityByName(String name);

}
