package com.invest.simulation_service;

import org.springframework.boot.SpringApplication;

public class TestSimulationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(SimulationServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
