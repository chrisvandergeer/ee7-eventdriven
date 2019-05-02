package nl.cge.eventbus;

import nl.cge.frontend.events.ApplicationEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class EventBusEventReceiver {

    @PersistenceUnit(unitName = "eventbus")
    private EntityManagerFactory emf;

    @Inject
    private IoaEventMapper mapper;

    public void onEvent(@Observes ApplicationEvent event) {
        System.out.println("==> Eventbus: " + event.getContent().toString());
        IoaEvent ioaEvent = mapper.map(event);
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(ioaEvent);
//        entityManager.createQuery("select e from IoaEvent e", IoaEvent.class).getResultList()
//                .forEach(e -> System.out.println(e));
    }

}
