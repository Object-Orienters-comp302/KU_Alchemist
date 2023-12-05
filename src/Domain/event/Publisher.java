package Domain.event;

public interface Publisher {
    void publishEvent (Type type);
    
    void addListener (Listener lis);
}
