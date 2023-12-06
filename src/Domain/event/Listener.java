package Domain.event;

/**
 * The Listener interface represents an observer in the Observer Pattern.
 * Implementing classes will handle specific events they are interested in, which are defined
 * using the Type in the Event package.
 */
public interface Listener {
    /**
     * Called when an event occurs.
     *
     * @param type The type of the event that occurred.
     */
    void onEvent(Type type);
}
