package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.SingletonBeanWithPrototypeDependency;

@Configuration
public class SingletonPrototypeConfiguration {
    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }

    @Bean
    public SingletonBeanWithPrototypeDependency commandManager() {
        // возвращаем новую анонимную реализацию с новым объектом
        return new SingletonBeanWithPrototypeDependency() {
            @Override
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }
}
