package com.feiraBrasil.IFeiraAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.feiraBrasil.IFeiraAPI.config.FileStorageConfig;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageConfig.class
})
@EnableAutoConfiguration
@ComponentScan
public class IFeiraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IFeiraApiApplication.class, args);
	}

}
