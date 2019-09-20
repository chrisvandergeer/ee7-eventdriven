package nl.cge.eventbus;

import nl.cge.common.events.ApplicationEvent;

public class IoaEventMapper {

    public IoaEvent map(ApplicationEvent applicationEvent) {
        IoaEvent event = new IoaEvent();
        event.setContent(applicationEvent.getContent().toString());
        event.setEventId(applicationEvent.getEventId());
        event.setProcessId(applicationEvent.getProcessId());
        event.setProcessName(applicationEvent.getProcessName());
        return event;
    }
}
