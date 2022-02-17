package com.derkachekaterina.shop.rest.controller;

import com.derkachekaterina.shop.dto.Cake;
import com.derkachekaterina.shop.dto.CakeFullInf;
import com.derkachekaterina.shop.dto.Cakes;
import com.derkachekaterina.shop.exception.CakeNotFoundException;
import com.derkachekaterina.shop.goods.CakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
//@RequestMapping("v1/cakes")

public class CakeController {
    private final Cakes cakeList = new Cakes();
    private static long idCounter = 0;
    private final CakesService cakesService;

    @Autowired
    public CakeController(CakesService cakesService) {
        List<Cake> tmp = new ArrayList<Cake>();
        cakeList.setCakeList(tmp);
        this.cakesService = cakesService;
    }


   /* public CakeController(){

        //Cakes cakeList = new Cakes();
        Cake cake1 = new Cake();
        cake1.setName("Napoleon");
        cake1.setPrice(new BigDecimal(100));
        cake1.setWeight(new BigDecimal(100));
        cake1.setImage("cake1.jpg");
        cake1.setCalories(new BigDecimal(100));
        cake1.setId(1L);


        Cake cake2 = new Cake();
        cake2.setName("Rose");
        cake2.setId(2L);
        cake2.setPrice(new BigDecimal(200));
        cake2.setWeight(new BigDecimal(200));
        cake2.setImage("cake1.jpg");
        cake2.setCalories(new BigDecimal(200));
        List<Cake> tmp = new ArrayList<Cake>();
        tmp.add(cake1);
        tmp.add(cake2);
        cakeList.setCakeList(tmp);

    }*/

@GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
public Cakes cakes() {
    return cakesService.getCakes();
}

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CakeFullInf getCakeById(@PathVariable Long id) {
        return cakesService.getCake(id);
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> createCake(@RequestBody @Valid Cake newCake) {
        newCake.setId(idCounter);
        idCounter++;
        cakeList.getCakeList().add(newCake);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}