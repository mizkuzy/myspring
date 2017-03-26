package services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("rus")
public class GreetingServiceRus implements GreetingService {

    @Override
    public String sayGreetings() {
        return "Здоровченко!";
    }
}
