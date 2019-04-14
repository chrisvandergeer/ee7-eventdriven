package nl.cge.eventdrivenioa.helloworld;

import nl.cge.eventdrivenioa.events.MyEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("helloworld")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    @Inject
    private Event<MyEvent> myEvent;

    @GET
    public JsonObject helloWorld() {
        MyEvent event = new MyEvent("a message");
        myEvent.fire(event);
        return Json.createObjectBuilder()
                .add("eventId", event.getEventId())
                .add("eventMessage", event.getEventMessage())
                .build();
    }

}
