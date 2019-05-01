package nl.cge.frontend.events;

import javax.json.JsonObject;

public abstract class AbstractApplicationEvent implements ApplicationEvent {

    private String eventId;

    private String processId;
    private JsonObject content;

    protected AbstractApplicationEvent(String eventId, String processId, JsonObject content) {
        this.eventId = eventId;
        this.processId = processId;
        this.content = content;
    }

    public String getEventId() {
        return eventId;
    }

    public String getProcessId() {
        return processId;
    }

    public JsonObject getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "AbstractApplicationEvent{" +
                "eventId='" + eventId + '\'' +
                ", processId='" + processId + '\'' +
                ", processName='" + getProcessName() + '\'' +
                ", content=" + content +
                '}';
    }
}
