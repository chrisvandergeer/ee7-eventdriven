package nl.cge.eventbus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class MyEvent {

    @Id
    private String id = UUID.randomUUID().toString();

    private String eventName;

    public MyEvent() {
        super();
    }

    public MyEvent(String name) {
        this.eventName = name;
    }

    public String getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "id='" + id + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
