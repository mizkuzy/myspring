package events;


import org.springframework.context.ApplicationEvent;

public class MyBlackListEvent extends ApplicationEvent
{
    private final String address;
    private final String test;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     * @param address
     * @param test
     */
    public MyBlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
    }
}
