package nl.cge.eventbus;

import nl.cge.eventdrivenioa.events.MyEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class EventBusEventReceiver {

        public void onMyEvent(@Observes MyEvent myEvent) {
            System.out.println("EventBusEventReceiver: " + myEvent);
        }
}
