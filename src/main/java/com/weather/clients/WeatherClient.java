package com.weather.clients;

import com.weather.models.Forecast;
import reactor.core.publisher.Mono;

public interface WeatherClient {
  Mono<Forecast> getDaily(Integer latitude, Integer longitude);
}
