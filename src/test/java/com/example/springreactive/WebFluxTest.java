package com.example.springreactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class WebFluxTest {
    // WebFlux publishers: Mono, Flux
    @Test
    public void testMonoPublisher() {
        var stringMono = Mono.just("Alex");
        var emptyMono = Mono.empty();

        stringMono.subscribe();
    }
}
