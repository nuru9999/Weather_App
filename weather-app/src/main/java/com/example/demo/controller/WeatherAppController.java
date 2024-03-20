package com.example.demo.controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class WeatherAppController {
	
	@GetMapping("/weather/{city}")
    public String getWeather(@PathVariable String city) {
        try {
            // Fetch weather data from an external API (OpenWeatherMap API used here)
            String apiKey = "f42d394180342cc7a110f7be44bb428d";
           // String city = "New York";
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey);
            InputStream is = url.openStream();
            JsonReader reader = Json.createReader(new InputStreamReader(is));
            JsonObject jsonObject = reader.readObject();
            reader.close();
            is.close();

            // Extract relevant weather information
            String description = jsonObject.getJsonArray("weather").getJsonObject(0).getString("description");
            int temperature = jsonObject.getJsonObject("main").getInt("temp");
//            double temperature = 0;
            // Return formatted weather information
            return "Weather in " + city + ": " + description + ", Temperature: " + temperature + "°F";
        } catch (Exception e) {
            return "Error fetching weather data: " + e.getMessage();
        }
    }

}
