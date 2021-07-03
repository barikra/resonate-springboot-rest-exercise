package com.resonate.exercise.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.resonate.exercise")
public class SpringBootExercise {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExercise.class, args);
	}
}
