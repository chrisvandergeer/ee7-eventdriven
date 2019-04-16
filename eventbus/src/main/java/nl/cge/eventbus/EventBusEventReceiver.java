package nl.cge.eventbus;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class EventBusEventReceiver {

    @PersistenceUnit(unitName = "eventbus")
    private EntityManagerFactory emf;


    public void onMyEvent(@Observes nl.cge.eventdrivenioa.events.MyEvent myEvent) {
        System.out.println("EventBusEventReceiver: " + myEvent);
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(new MyEvent(myEvent.getEventMessage()));
        entityManager.createQuery("select e from MyEvent e", MyEvent.class).getResultList()
                .forEach(e -> System.out.println(e));
        ;

    }
}
