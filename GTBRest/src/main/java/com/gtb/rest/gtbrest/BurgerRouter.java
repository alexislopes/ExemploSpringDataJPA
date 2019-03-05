package com.gtb.rest.gtbrest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.awt.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class BurgerRouter {

    @Bean
    public RouterFunction<ServerResponse> route(BurgerHandler handler){
        return RouterFunctions
                .route(GET("/burger").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/burger/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/burger").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
