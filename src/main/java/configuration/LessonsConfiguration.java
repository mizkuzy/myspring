package configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import services.GreetingService;
import services.GreetingServiceTurk;

@Configuration
@ComponentScan(basePackageClasses = GreetingServiceTurk.class)
@Import({SingletonPrototypeConfiguration.class, BeanWithDependencyConfiguration.class})
//@ImportResource("classpath:/lessons/xml-config.xml")/*TO IMPORT XML CONFIGURATION*/
public class LessonsConfiguration {

    GreetingService greetingService() {
        return new GreetingServiceTurk();
    }

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

}
