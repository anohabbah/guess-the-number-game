package me.abbah;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

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

        if (!game.isValidNumberRange()) {
            return "Invalid number range !";
        }

        if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess ?";
        }

        String direction = "Lower";

        if (game.getGuess() < game.getNumber()) {
            direction = "Higher";
        }

        return String.format(
                "%s ! You have %d %s left.",
                direction,
                game.getRemainingGuesses(),
                game.getRemainingGuesses() <= 1 ? "guess" : "guesses"
        );
    }
}
