package me.abbah.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private int maxNumber = 100;
    private int minNumber = 0;
    private int guessCount = 10;

    @Bean
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    public int minNumber() {
        return minNumber;
    }

    @Bean
    public int guessCount() {
        return guessCount;
    }
}
