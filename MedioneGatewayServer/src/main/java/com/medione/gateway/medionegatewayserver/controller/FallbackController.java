package com.medione.gateway.medionegatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/error")
    public Mono<String> getErrorMessage(){
        return Mono.just("Error occured, please contact support team");
    }

}
