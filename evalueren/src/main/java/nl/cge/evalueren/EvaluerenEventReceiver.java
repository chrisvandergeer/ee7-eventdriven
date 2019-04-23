package nl.cge.evalueren;


import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;

@Stateless
public class EvaluerenEventReceiver {

//        public void onMyEvent(@Observes(during = AFTER_SUCCESS) MyEvent myEvent) {
//            System.out.println("EvaluerenEventReceiver: " + myEvent);
//        }
}
