package com.weather.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DailyForecastDTO {

  @JsonProperty("day_name")
  private String dayName;

  @JsonProperty("temp_high_celcius")
  private Double tempHighCelcius;

  @JsonProperty("forecast_blurp")
  private String forecastBlurp;
}
