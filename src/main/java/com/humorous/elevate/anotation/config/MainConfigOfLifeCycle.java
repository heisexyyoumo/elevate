package com.humorous.elevate.anotation.config;

import com.humorous.elevate.anotation.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期
 */

@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
