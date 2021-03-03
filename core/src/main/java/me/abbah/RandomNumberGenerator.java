package me.abbah;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Autowired
    private int maxNumber;

    @Override
    public int next() {
        return random.nextInt(this.maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return this.maxNumber;
    }
}
