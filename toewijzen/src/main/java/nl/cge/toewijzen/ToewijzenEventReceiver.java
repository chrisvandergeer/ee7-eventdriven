package nl.cge.toewijzen;


import nl.cge.frontend.events.ApplicationEvent;
import nl.cge.frontend.events.BetalingsverplichtigOntvangen;
import nl.cge.frontend.events.BetalingsverplichtingGoedgekeurd;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;

@Stateless
public class ToewijzenEventReceiver {

    public void onMyEvent(@Observes(during = AFTER_SUCCESS) @BetalingsverplichtigOntvangen ApplicationEvent event) {
        System.out.println("==> ToewijzenEventReceiver: " + event.getContent().toString());
    }

}
