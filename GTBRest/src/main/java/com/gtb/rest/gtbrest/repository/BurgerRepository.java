package com.gtb.rest.gtbrest.repository;

import com.gtb.rest.gtbrest.document.Burger;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BurgerRepository extends ReactiveMongoRepository<Burger, String> {
}
