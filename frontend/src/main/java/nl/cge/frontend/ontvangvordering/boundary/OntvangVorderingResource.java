package nl.cge.frontend.ontvangvordering.boundary;



import nl.cge.frontend.events.*;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("vordering")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OntvangVorderingResource {

    @Inject
    private Event<ApplicicationEvent> event;

    @POST
    public JsonObject helloWorld(JsonObject json) {
        System.out.println(json.toString());
        return Json.createObjectBuilder().add("result", "success").build();
    }


}
