package nl.cge.eventdrivenioa.eventreceiver;

import nl.cge.eventdrivenioa.events.MyEvent;

import javax.enterprise.event.Observes;

public class EventReceiver2 {

    public void onMyEvent(@Observes MyEvent myEvent) {
        System.out.println("EventReceiver2: " + myEvent);
    }

}
