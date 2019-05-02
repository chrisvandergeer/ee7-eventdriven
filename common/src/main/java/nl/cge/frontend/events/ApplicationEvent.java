package nl.cge.frontend.events;

import javax.json.JsonObject;
import java.util.UUID;

public class ApplicationEvent {

    private String eventId;

    private String processId;
    private String processName;
    private JsonObject content;

    public ApplicationEvent(String processName, JsonObject content) {
        this(UUID.randomUUID().toString(), UUID.randomUUID().toString(), processName, content);
    }

    public ApplicationEvent(String eventId, String processId, String processName, JsonObject content) {
        this.eventId = eventId;
        this.processId = processId;
        this.processName = processName;
        this.content = content;
    }

    public String getEventId() {
        return eventId;
    }

    public String getProcessId() {
        return processId;
    }

    public String getProcessName() {
        return processName;
    }

    public JsonObject getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "AbstractApplicationEvent{" +
                "eventId='" + eventId + '\'' +
                ", processId='" + processId + '\'' +
                ", processName='" + processName + '\'' +
                ", content=" + content +
                '}';
    }
}
