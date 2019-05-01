package nl.cge.eventbus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class IoaEvent {

    @Id
    private String eventId;

    private String processName;
    private String processId;

    @Lob
    private String content;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "IoaEvent{" +
                "eventId='" + eventId + '\'' +
                ", processName='" + processName + '\'' +
                ", processId='" + processId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
