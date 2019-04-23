package nl.cge.frontend.events;

import java.util.UUID;

public class ApplicationEventInpl implements ApplicicationEvent {

    private String eventId = UUID.randomUUID().toString();
    private String procesnaam;
    private String procesId;
    private String inhoud;

    @Override
    public String getEventId() {
        return eventId;
    }

    @Override
    public String getProcesnaam() {
        return procesnaam;
    }

    @Override
    public String getProcesId() {
        return procesId;
    }

    @Override
    public String getInhoud() {
        return inhoud;
    }
}
