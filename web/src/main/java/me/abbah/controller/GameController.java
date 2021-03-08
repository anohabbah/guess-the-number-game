package me.abbah.controller;

import lombok.extern.slf4j.Slf4j;
import me.abbah.service.GameService;
import me.abbah.utils.AttributeNames;
import me.abbah.utils.GameMappings;
import me.abbah.utils.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);

        if (gameService.isGameOver()) {
            return ViewNames.GAME_OVER;
        }

        return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess) {
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);

        return GameMappings.REDIRECT_PLAY;
    }
}
