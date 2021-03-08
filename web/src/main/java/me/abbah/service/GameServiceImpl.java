package me.abbah.service;

import lombok.extern.slf4j.Slf4j;
import me.abbah.Game;
import me.abbah.MessageGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {
    private final Game game;
    private final MessageGenerator messageGenerator;

    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }
    @PostConstruct
    void init() {
        log.info("Number = {}", game.getNumber());
        log.info("Mais message = {}", getMainMessage());
    }

    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
