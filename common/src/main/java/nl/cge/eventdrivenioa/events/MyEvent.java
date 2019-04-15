package nl.cge.eventdrivenioa.events;

import java.util.UUID;

public class MyEvent {

    private String eventId = UUID.randomUUID().toString();

    private String eventMessage;

    public MyEvent(String eventMessage) {
        this.eventMessage = eventMessage;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "eventId='" + eventId + '\'' +
                ", eventMessage='" + eventMessage + '\'' +
                '}';
    }

}
