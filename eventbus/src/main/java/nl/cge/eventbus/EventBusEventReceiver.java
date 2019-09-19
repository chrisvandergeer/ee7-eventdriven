package nl.cge.eventbus;

import nl.cge.frontend.events.ApplicationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class EventBusEventReceiver {

    private final static Logger LOGGER = LogManager.getLogger(EventBusEventReceiver.class);

    @PersistenceUnit(unitName = "eventbus")
    private EntityManagerFactory emf;

    @Inject
    private IoaEventMapper mapper;

    public void onEvent(@Observes ApplicationEvent event) {
        LOGGER.info(() -> "==> Eventbus: " + event.getContent().toString());
        IoaEvent ioaEvent = mapper.map(event);
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(ioaEvent);
    }

}
