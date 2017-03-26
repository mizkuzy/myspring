import configuration.EventConfiguration;
import configuration.LessonsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import services.EmailService;

import java.util.ArrayList;
import java.util.List;

public class EventStarter {
    private final static Logger logger = LoggerFactory.getLogger(EventStarter.class);
    private static final String blackAddress1 = "KOKO";
    private static final String blackAddress2 = "BOOKBOOK";

    public static void main(String[] args) {
        logger.info("Starting configuration...");

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(EventConfiguration.class);

        EmailService emailService = context.getBean(EmailService.class);
        emailService.setBlackList(getBlackAddresses());

        //this service will publish event that we are trying to send email from the black list
        emailService.sendEmail(blackAddress1, "Message to bad address.");
    }

    private static List<String> getBlackAddresses() {
        List<String> blackList = new ArrayList<>();
        blackList.add(blackAddress1);
        blackList.add(blackAddress2);
        return blackList;
    }
}