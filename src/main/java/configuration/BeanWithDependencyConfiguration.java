package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.BeanWithDependency;
import services.GreetingService;

@Configuration
public class BeanWithDependencyConfiguration {

    @Autowired
    @Qualifier("turk")
    private GreetingService greetingService;

    @Bean
    BeanWithDependency beanWithDependency() {
        return new BeanWithDependency(greetingService);
    }
}
