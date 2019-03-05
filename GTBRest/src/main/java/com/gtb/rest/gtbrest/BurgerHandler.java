package com.gtb.rest.gtbrest;

import com.gtb.rest.gtbrest.document.Burger;
import com.gtb.rest.gtbrest.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class BurgerHandler {

    @Autowired
    BurgerService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Burger.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), Burger.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<Burger> burger = request.bodyToMono(Burger.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(burger.flatMap(service::save), Burger.class));
    }
}
