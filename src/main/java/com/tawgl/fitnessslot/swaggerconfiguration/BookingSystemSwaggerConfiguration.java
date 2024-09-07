package com.tawgl.fitnessslot.swaggerconfiguration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingSystemSwaggerConfiguration {

	@Bean
	public GroupedOpenApi controllerApi() {
		return GroupedOpenApi.builder().group("FitnessSlotBookingSystem")
				.packagesToScan("com.tawgl.fitnessslot.controller") // Specify the package to scan
				.build();
	}

}
