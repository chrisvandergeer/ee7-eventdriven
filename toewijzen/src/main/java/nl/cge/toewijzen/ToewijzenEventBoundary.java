package nl.cge.toewijzen;


import nl.cge.common.events.ApplicationEvent;
import nl.cge.common.events.BetalingsverplichtingGoedgekeurd;
import nl.cge.common.events.ToewijsbareVorderingGeregistreerd;
import nl.cge.common.logging.EventLoggerInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.json.Json;
import javax.json.JsonObject;

import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;

@Stateless
public class ToewijzenEventBoundary {

    private final static Logger LOGGER = LogManager.getLogger(ToewijzenEventBoundary.class);

    @Inject
    @ToewijsbareVorderingGeregistreerd
    private Event<ApplicationEvent> toewijsbareVorderingGeregistreerd;

    @Interceptors(EventLoggerInterceptor.class)
    public void onMyEvent(@Observes(during = AFTER_SUCCESS) @BetalingsverplichtingGoedgekeurd ApplicationEvent betalingsverplichtingGoedgekeurd) {
        JsonObject jsonObject = Json.createObjectBuilder().add("result", "toewijsbareVorderingGeregistreerd").build();
        ApplicationEvent resultEvent = new ApplicationEvent(betalingsverplichtingGoedgekeurd, jsonObject);
        toewijsbareVorderingGeregistreerd.fire(resultEvent);
    }

}
