package com.gtb.rest.gtbrest.services;

import com.gtb.rest.gtbrest.document.Burger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BurgerService {
    Flux<Burger> findAll();

    Mono<Burger> findById(String id);

    Mono<Burger> save(Burger burger);
}
