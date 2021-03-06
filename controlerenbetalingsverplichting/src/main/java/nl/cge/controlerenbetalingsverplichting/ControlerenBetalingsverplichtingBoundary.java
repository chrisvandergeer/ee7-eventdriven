package nl.cge.controlerenbetalingsverplichting;

import nl.cge.common.events.ApplicationEvent;
import nl.cge.common.events.BetalingsverplichtigOntvangen;
import nl.cge.common.events.BetalingsverplichtingAfgekeurd;
import nl.cge.common.events.BetalingsverplichtingGoedgekeurd;
import nl.cge.common.logging.EventLoggerInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.json.JsonObject;

import static java.lang.String.format;
import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;

@Stateless
public class ControlerenBetalingsverplichtingBoundary {

    private final static Logger LOGGER = LogManager.getLogger(ControlerenBetalingsverplichtingBoundary.class);

    @Inject
    @BetalingsverplichtingGoedgekeurd
    private Event<ApplicationEvent> betalingsverplichtingGoedgekeurd;

    @Inject
    @BetalingsverplichtingAfgekeurd
    private Event<ApplicationEvent> betalingsverplichtingAfgekeurd;

    @Inject
    private ControlerenBetalingsverplichtingEventFactory eventFactory;

    @Interceptors(EventLoggerInterceptor.class)
    public void onMyEvent(@Observes(during = AFTER_SUCCESS) @BetalingsverplichtigOntvangen ApplicationEvent event) {
        JsonObject betalingsverplichting = event.getContent();
        String belastingmiddel = betalingsverplichting.getString("belastingmiddel");
        ApplicationEvent resultEvent;
        if ("MRB".equals(belastingmiddel)) {
            betalingsverplichtingGoedgekeurd.fire(eventFactory.betalingsverplichtingGoedgekeurd(event));

        } else {
            betalingsverplichtingAfgekeurd.fire(
                    eventFactory.betalingsverplichtingAfgekeurd(event, format("onbekend Belastingmiddel: %s", belastingmiddel)));
        }
    }
}
