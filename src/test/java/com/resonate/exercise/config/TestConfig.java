package com.resonate.exercise.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@ComponentScan(basePackages="com.resonate.exercise")
@EnableAutoConfiguration
@TestConfiguration
@ActiveProfiles("test")
public class TestConfig {

}
