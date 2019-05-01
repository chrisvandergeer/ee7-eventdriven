package nl.cge.frontend.events;

import javax.json.JsonObject;

public interface ApplicationEvent {

    String getEventId();

    String getProcessName();

    String getProcessId();

    JsonObject getContent();
}
