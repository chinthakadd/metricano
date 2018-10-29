package com.techcoaster.metricano

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CounterEnabledHelloController {

    Counter counter

    CounterEnabledHelloController(MeterRegistry registry) {
        this.counter = registry.counter("hello.counter");
    }

    @GetMapping("/hello")
    String hello(){
        Thread.sleep 2000
        counter.increment()
        return "HELLO"
    }
}
