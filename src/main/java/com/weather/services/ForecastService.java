package com.weather.services;

import com.weather.clients.WeatherClient;
import com.weather.dtos.ForecastDTO;
import com.weather.mappers.ForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ForecastService {

  private final WeatherClient weatherClient;
  private final ForecastMapper forecastMapper;

  @Autowired
  public ForecastService(
      final WeatherClient weatherClient,
      final ForecastMapper forecastMapper
  ) {
    this.weatherClient = weatherClient;
    this.forecastMapper = forecastMapper;
  }

  public Mono<ForecastDTO> getDailyForecastForLocation(final Integer latitude, final Integer longitude) {
    return this.weatherClient
        .getDaily(latitude, longitude)
        .map(forecastMapper::map);
  }
}
