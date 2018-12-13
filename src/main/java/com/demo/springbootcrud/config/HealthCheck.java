package com.demo.springbootcrud.config;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {
	
	Random random = new Random();

	@Override
	public Health health() {
//		if (randomBoolean()) {
//			return Health.up().build();			
//		} else {
//			return Health.down().withDetail("DemoKey", "DemoVal").build();
//		}
		return Health.up().build();	
	}
	
	private boolean randomBoolean() {
		return random.nextBoolean();
	}

}
