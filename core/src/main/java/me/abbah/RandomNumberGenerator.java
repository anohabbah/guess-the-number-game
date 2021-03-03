package me.abbah;


import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Getter
    private final int maxNumber;

    @Getter
    private final int minNumber;

    public RandomNumberGenerator(int maxNumber, int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt(this.maxNumber - this.minNumber) + this.maxNumber;
    }
}
