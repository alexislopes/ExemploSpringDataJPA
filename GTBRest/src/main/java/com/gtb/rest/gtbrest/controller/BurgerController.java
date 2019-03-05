package com.gtb.rest.gtbrest.controller;

import com.gtb.rest.gtbrest.document.Burger;
import com.gtb.rest.gtbrest.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



//@RestController
public class BurgerController {

    @Autowired
    BurgerService service;

    @GetMapping(value = "/burger")
    public Flux<Burger> getBurger(){
        return service.findAll();
    }

    @GetMapping(value = "/burger/{id}" )
    public Mono<Burger> getBurgerById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping(value = "/playlist")
    public Mono<Burger> save(@RequestBody Burger burger){
        return service.save(burger);
    }
}
