package nl.cge.frontend.events.verwerkenvordering;

import nl.cge.frontend.events.AbstractApplicationEvent;

import javax.json.JsonObject;
import java.util.UUID;

public class BetalingsverplichtingOntvangen extends AbstractApplicationEvent {

    public BetalingsverplichtingOntvangen(JsonObject content) {
        super(UUID.randomUUID().toString(), UUID.randomUUID().toString(), content);
    }

    @Override
    public String getProcessName() {
        return "Verwerken Vordering";
    }
}
