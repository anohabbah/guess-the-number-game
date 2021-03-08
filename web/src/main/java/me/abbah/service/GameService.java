package me.abbah.service;

public interface GameService {
    boolean isGameOver();

    String getResultMessage();

    String getMainMessage();

    void checkGuess(int guess);

    void reset();
}
