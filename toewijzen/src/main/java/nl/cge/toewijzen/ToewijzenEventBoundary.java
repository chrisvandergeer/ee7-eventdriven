package nl.cge.toewijzen;


import nl.cge.frontend.events.ApplicationEvent;
import nl.cge.frontend.events.BetalingsverplichtigOntvangen;
import nl.cge.frontend.events.BetalingsverplichtingGoedgekeurd;
import nl.cge.frontend.events.ToewijsbareVorderingGeregistreerd;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;

@Stateless
public class ToewijzenEventBoundary {

    @Inject
    @ToewijsbareVorderingGeregistreerd
    private Event<ApplicationEvent> toewijsbareVorderingGeregistreerd;

    public void onMyEvent(@Observes(during = AFTER_SUCCESS) @BetalingsverplichtingGoedgekeurd ApplicationEvent betalingsverplichtingGoedgekeurd) {
        System.out.println("==> ToewijzenEventBoundary receives BetalingsverplichtingGoedgekeurd");
        JsonObject jsonObject = Json.createObjectBuilder().add("result", "toewijsbareVorderingGeregistreerd").build();
        ApplicationEvent resultEvent = new ApplicationEvent(betalingsverplichtingGoedgekeurd, jsonObject);
        toewijsbareVorderingGeregistreerd.fire(resultEvent);
    }

}
