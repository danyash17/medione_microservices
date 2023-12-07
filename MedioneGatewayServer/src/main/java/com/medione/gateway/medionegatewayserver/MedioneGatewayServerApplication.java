package com.medione.gateway.medionegatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableDiscoveryClient
public class MedioneGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedioneGatewayServerApplication.class, args);
    }

    @Bean
    public RouteLocator medioneRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p ->
                        p.path("/medione/doctor/**")
                                .filters(f -> f.rewritePath("/medione/(?<remaining>.*)", "/medioneapi/${remaining}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                        .circuitBreaker(config -> config.setName("doctorCB")
                                                .setFallbackUri("forward:/error")))
                                .uri("http://mmdoctor:8081"))
                .route(p ->
                        p.path("/medione/patient/**")
                                .filters(f -> f.rewritePath("/medione/(?<remaining>.*)", "/medioneapi/${remaining}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                        .retry(retryConfig -> retryConfig.setRetries(3).setMethods(HttpMethod.GET)
                                                .setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true)))
                                .uri("http://mmpatient:8082"))
                .route(p ->
                        p.path("/medione/visits/**")
                                .filters(f -> f.rewritePath("/medione/(?<remaining>.*)", "/medioneapi/${remaining}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                        .requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter()).setKeyResolver(keyResolver())))
                                .uri("http://mmvisits:8083"))
                .build();
    }

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 1, 1);
    }

    @Bean
    public KeyResolver keyResolver() {
        return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
                .defaultIfEmpty("anonymous");
    }
}
