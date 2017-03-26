package services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

@Component
@Description("This bean is for greeting")
@Qualifier("turk")
public class GreetingServiceTurk implements GreetingService {

    @Override
    public String sayGreetings() {
        return "Merhaba";
    }
}
