package com.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastPropertiesPeriod {
  private String name;
  private Double temperature;
  private String temperatureUnit;
  private String detailedForecast;
}
