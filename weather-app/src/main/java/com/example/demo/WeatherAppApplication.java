package com.example.demo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class WeatherAppApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

}
