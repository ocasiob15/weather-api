package com.weather.controllers;

import com.weather.dtos.ForecastDTO;
import com.weather.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/forecasts")
public class ForecastController {

  private final ForecastService forecastService;

  @Autowired
  public ForecastController(
      final ForecastService forecastService
  ) {
    this.forecastService = forecastService;
  }

  @GetMapping
  public Mono<ForecastDTO> getForecastForArea(
      @RequestParam("latitude") final Integer latitude,
      @RequestParam("longitude") final Integer longitude
  ) {
    return this.forecastService.getDailyForecastForLocation(latitude, longitude);
  }
}
