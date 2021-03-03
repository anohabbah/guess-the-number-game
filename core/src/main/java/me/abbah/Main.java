package me.abbah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number Game");

        // Create the context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call next method to get a random number
        int number = numberGenerator.next();

        log.info("number = {}", number);

        // get fame bean from context
        Game game = context.getBean(Game.class);

        // close context
        context.close();
    }
}
