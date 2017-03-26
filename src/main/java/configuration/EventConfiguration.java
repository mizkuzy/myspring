package configuration;

import events.MyBlackListEvent;
import listeners.BlackListNotifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.EmailService;

@Configuration
@ComponentScan(basePackageClasses = {MyBlackListEvent.class, BlackListNotifier.class, EmailService.class})
public class EventConfiguration {
}
