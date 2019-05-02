package nl.cge.frontend.events;

import javax.json.JsonObject;
import java.util.UUID;

public class ApplicationEvent {

    private String eventId;

    private String processId;
    private String processName;
    private JsonObject content;

    /**
     * @param processName
     * @param content
     */
    public ApplicationEvent(String processName, JsonObject content) {
        this(UUID.randomUUID().toString(), processName, content);
    }

    public ApplicationEvent(ApplicationEvent triggerEvent, JsonObject content) {
        this(triggerEvent.getProcessId(), triggerEvent.getProcessName(), content);
    }

    /**
     * @param processId
     * @param processName
     * @param content
     */
    public ApplicationEvent(String processId, String processName, JsonObject content) {
        this.eventId = UUID.randomUUID().toString();
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
