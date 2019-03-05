package com.gtb.rest.gtbrest;

import com.gtb.rest.gtbrest.document.Burger;
import com.gtb.rest.gtbrest.repository.BurgerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

//@Component
//public class DummyData implements CommandLineRunner {
//
//    private final BurgerRepository burgerRepository;
//
//    DummyData(BurgerRepository burgerRepository){
//        this.burgerRepository = burgerRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        burgerRepository.deleteAll()
//                .thenMany(
//                        Flux.just("x-salada", "x-frango", "x-burger", "x-calabresa", "x-bacon", "x-peixe", "x-linguiça")
//                                .map(nome ->  new Burger(UUID.randomUUID().toString(), nome))
//                                .flatMap(burgerRepository::save)).subscribe(System.out::println);
//
//    }
//}
