package nl.cge.controlerenbetalingsverplichting;

import nl.cge.frontend.events.ApplicationEvent;

import javax.json.Json;
import javax.json.JsonObject;

public class ControlerenBetalingsverplichtingEventFactory {

    public ApplicationEvent betalingsverplichtingGoedgekeurd(ApplicationEvent betalingsverplichtingOntvangen) {
        JsonObject jsonObject = Json.createObjectBuilder().add("result", "GOEDGEKEURD").build();
        return new ApplicationEvent(betalingsverplichtingOntvangen, jsonObject);
    }

    public ApplicationEvent betalingsverplichtingAfgekeurd(ApplicationEvent betalingsverplichtingOntvangen, String reden) {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("result", "AFGEKEURD")
                .add("reden", reden)
                .build();
        return new ApplicationEvent(betalingsverplichtingOntvangen, jsonObject);
    }
}
