package com.Standa.weatherapp.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(String name, MainData main, WindData wind) {

}
