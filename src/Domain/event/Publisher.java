package Domain.event;

/**
 * The Publisher interface represents the subject in the Observer Pattern.
 * It allows observers to register and notifies them of events, while also
 * defining what type of event it is using the Type enum from the Event package.
 */
public interface Publisher {
    /**
     * Notifies all registered listeners of an event.
     *
     * @param type The type of the event to publish.
     */
    void publishEvent(Type type);
    
    /**
     * Adds a new listener to the publisher.
     * NOTE: Should be implemented for controllers, if the function is not exposed.
     *
     * @param lis The listener to be added.
     */
    void addListener(Listener lis);
}
