package com.techcoaster.metricano

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MetricanoApplication {

    /**
     * Adding a custom tag to the metrics.
     */
    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return { registry -> registry.config().commonTags("platform", "minion") }
    }

    static void main(String[] args) {
        SpringApplication.run MetricanoApplication, args
    }
}
