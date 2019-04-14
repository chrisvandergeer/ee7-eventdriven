package nl.cge.eventdrivenioa.eventreceiver;

import nl.cge.eventdrivenioa.events.MyEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import static javax.enterprise.event.TransactionPhase.*;

public class EventReceiver3 {

    public void onMyEvent(@Observes(during = AFTER_SUCCESS) MyEvent myEvent) {
        System.out.println("EventReceiver3: " + myEvent);
    }

}
