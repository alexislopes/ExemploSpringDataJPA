package com.gtb.rest.gtbrest.services;

import com.gtb.rest.gtbrest.document.Burger;
import com.gtb.rest.gtbrest.repository.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BurgerServiceImpl implements BurgerService {

    @Autowired
    private BurgerRepository burgerRepository;

    @Override
    public Flux<Burger> findAll() {
        return burgerRepository.findAll();
    }

    @Override
    public Mono<Burger> findById(String id) {
        return burgerRepository.findById(id);
    }

    @Override
    public Mono<Burger> save(Burger burger) {
        return burgerRepository.save(burger);
    }
}
