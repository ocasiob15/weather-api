package com.weather.clients;

import com.weather.models.Forecast;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriTemplate;
import reactor.core.publisher.Mono;

@Component
public class WeatherClientImpl implements WeatherClient {

  private final static String ENDPOINT = "https://api.weather.gov/gridpoints/MLB/{latitude},{longitude}/forecast";

  private final WebClient webClient = WebClient.create();

  @Override
  public Mono<Forecast> getDaily(final Integer latitude, final Integer longitude) {
    return this.webClient.get()
        .uri(new UriTemplate(ENDPOINT).expand(latitude, longitude))
        .retrieve()
        .bodyToMono(Forecast.class);
  }
}
