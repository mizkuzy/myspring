package listeners;

import events.MyBlackListEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class BlackListNotifier implements ApplicationListener<MyBlackListEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BlackListNotifier.class);

    @Override
    public void onApplicationEvent(MyBlackListEvent event) {
        logger.warn("There was an {}.", event.getClass());
    }
}
