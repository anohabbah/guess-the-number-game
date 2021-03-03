package me.abbah;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component()
public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();
    private final int maxNumber = 100;

    @Override
    public int next() {
        return random.nextInt(this.maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return this.maxNumber;
    }
}
