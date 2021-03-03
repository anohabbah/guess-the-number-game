package me.abbah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number Game");

        // Create the context (container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get number generator from context
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // call next method to get a random number
        int number = numberGenerator.next();

        log.info("number = {}", number);

        // get fame bean from context
        Game game = context.getBean(Game.class);
        game.reset();

        // close context
        context.close();
    }
}
