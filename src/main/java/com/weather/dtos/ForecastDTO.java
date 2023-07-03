package com.weather.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ForecastDTO {
  private List<DailyForecastDTO> daily;
}
