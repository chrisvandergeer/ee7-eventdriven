package nl.cge.toewijzen;


import nl.cge.frontend.events.verwerkenvordering.BetalingsverplichtingOntvangen;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;

@Stateless
public class ToewijzenEventReceiver {

    public void onMyEvent(@Observes(during = AFTER_SUCCESS) BetalingsverplichtingOntvangen event) {
        System.out.println("ToewijzenEventReceiver: " + event.getContent().toString());
    }

//        public void onMyEvent(@Observes(during = AFTER_SUCCESS) MyEvent myEvent) {
//            System.out.println("ToewijzenEventReceiver: " + myEvent);
//        }
}
