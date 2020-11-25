package apap.tutorial.traveloke.service;
import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import reactor.core.publisher.Mono;

import java.util.List;
public interface RestAPIService {
    Mono<String> findCity(String cityName);
}
