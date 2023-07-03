package com.weather.mappers;

import com.weather.dtos.DailyForecastDTO;
import com.weather.dtos.ForecastDTO;
import com.weather.models.Forecast;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ForecastMapper {
  private static final String FAR = "F";

  public ForecastDTO map(final Forecast forecast) {
    final ForecastDTO forecastDTO = new ForecastDTO();
    final List<DailyForecastDTO> dailyForecastDTOList = forecast.getProperties().getPeriods().stream()
        .map((period) -> {
          final DailyForecastDTO dailyForecastDTO = new DailyForecastDTO();
          dailyForecastDTO.setForecastBlurp(period.getDetailedForecast());
          dailyForecastDTO.setDayName(period.getName());
          if (FAR.equals(period.getTemperatureUnit())) {
            final double tempCelc = (period.getTemperature() - 32.0) * (5.0 / 9.0);
            dailyForecastDTO.setTempHighCelcius(round(tempCelc));
          } else {
            dailyForecastDTO.setTempHighCelcius(period.getTemperature());
          }
          return dailyForecastDTO;
        })
        .collect(Collectors.toList());
    forecastDTO.setDaily(dailyForecastDTOList);
    return forecastDTO;
  }

  private Double round(double value) {
    int scale = (int) Math.pow(10, 1);
    return (double) Math.round(value * scale) / scale;
  }
}
