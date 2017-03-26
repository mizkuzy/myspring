package services;

import events.MyBlackListEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Thanks to interface ApplicationEventPublisherAware this class can publish events.
 */
@Service
public class EmailService implements ApplicationEventPublisherAware {
    private List<String> blackList;
    private ApplicationEventPublisher publisher;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendEmail(String address, String text) {
        if (blackList.contains(address)) {
            MyBlackListEvent event = new MyBlackListEvent(this, address, text);
            publisher.publishEvent(event);
            logger.warn("Letter was not send because this address {} is in the black list", address);
            return;
        }
        // отправка письма...
        logger.info("Letter to {} was send.", address);
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }
}
