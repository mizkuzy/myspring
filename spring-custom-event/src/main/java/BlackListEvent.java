import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String text;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     * @param address
     * @param text
     */
    public BlackListEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public String getText() {
        return text;
    }
}
