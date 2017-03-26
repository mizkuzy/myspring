import configuration.LessonsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import services.BeanWithDependency;
import services.GreetingService;
import services.GreetingServiceTurk;

import java.util.Locale;

public class Starter {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("Starting configuration...");

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingServiceTurk.class);
        logger.info(greetingService.sayGreetings());  // "Greeting, user!"
        BeanWithDependency bwd = context.getBean(BeanWithDependency.class);
        logger.info("BWD: {}", bwd.getGreetingService().sayGreetings());
        logger.info(bwd.sayIt("Hello, Spring!"));
        logger.info(bwd.sayItInSomeLanguage());

        //working with  MessageSource and locales
        logger.info("Message: {}", context.getMessage("message", null, Locale.getDefault()));
        logger.info("Argument.required: {}", context.getMessage("argument.required", new Object[]{"Test_Argument"},  Locale.getDefault()));

        logger.info("Message: {}", context.getMessage("message", null, Locale.UK));
        logger.info("Argument.required: {}", context.getMessage("argument.required", new Object[]{"Test_UK_Argument"}, Locale.UK));

        //switch on logging for destroying beans
        context.registerShutdownHook();

    }
}