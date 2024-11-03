package com.invest.asset_service;

import org.springframework.boot.SpringApplication;

public class TestAssetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(AssetServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
