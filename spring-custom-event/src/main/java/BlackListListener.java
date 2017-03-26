import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class BlackListListener implements ApplicationListener<BlackListEvent> {

    private final static Logger logger = LoggerFactory.getLogger(BlackListListener.class);

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {

       logger.info("Got {}. The attempt to send email to user {} from black list", event.getClass(), event.getAddress());
    }
}
