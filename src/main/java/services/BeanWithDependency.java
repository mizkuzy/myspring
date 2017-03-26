package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanWithDependency {

    private GreetingService greetingService;
    @Autowired
    @Qualifier("rus")
    private GreetingService greetingServiceMultilang;

    public BeanWithDependency(GreetingService greetingService) {
        setGreetingService(greetingService);
    }

    public GreetingService getGreetingService() {
        return greetingService;
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayIt(String smthWhatToSay) {
        return smthWhatToSay;
    }

    @Autowired
    public String sayItInSomeLanguage() {

        return greetingServiceMultilang.sayGreetings();
    }
}
