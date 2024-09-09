package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherForecast {
    private String city;
    private List<String> forecasts;

    public WeatherForecast(String city) {
        this.city = city;
        this.forecasts = new ArrayList<>();
        // Previsões pré-definidas
        forecasts.add("Ensolarado com poucas nuvens");
        forecasts.add("Chuva moderada");
        forecasts.add("Nublado");
        forecasts.add("Tempestade com trovões");
        forecasts.add("Tempo seco e quente");
        forecasts.add("Frio e com garoa");
    }

    public String getRandomForecast() {
        Random random = new Random();
        return forecasts.get(random.nextInt(forecasts.size()));
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Previsão do tempo para " + city + ": " + getRandomForecast();
    }
}
