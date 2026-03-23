package com.Standa.weatherapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.Standa.weatherapp.data.WeatherResponse;

@Service
public class WeatherService {

    private final RestClient restClient;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public WeatherResponse getWeather(String city) {
        return restClient.get()
                .uri("/weather?q={city}&appid={key}&units=metric", city, apiKey)
                .retrieve()
                .body(WeatherResponse.class);
    }
}
