package me.abbah.console;

import me.abbah.AppConfig;
import me.abbah.MessageGenerator;
import me.abbah.NumberGenerator;
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

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage : {}", messageGenerator.getMainMessage());
        log.info("getResultMessage : {}", messageGenerator.getResultMessage());

        // close context
        context.close();
    }
}
