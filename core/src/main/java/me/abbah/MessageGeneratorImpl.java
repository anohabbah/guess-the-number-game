package me.abbah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct
    void init() {
        log.debug("MessageGeneratorImpl#init - The number is {}", game.getNumber());
    }

    @Override
    public String getMainMessage() {
        return String.format("Number is between %d and %d. Can you guess it ?", game.getSmallest(), game.getBiggest());
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it ! The number was " + game.getNumber();
        }

        if (game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        }

        if (game.isValidNumberRange()) {
            return "Invalid number range !";
        }

        if (game.getRemainingGuesses() == guessCount) {
            return "What is your first guess ?";
        }

        String direction = "Lower";

        if (game.getGuess() < game.getNumber()) {
            direction = "Higher";
        }

        return String.format("%s ! You have %d guess left.", direction, game.getRemainingGuesses());
    }
}
