package nl.cge.frontend.betalingsverplichting;

import nl.cge.frontend.events.verwerkenvordering.BetalingsverplichtingOntvangen;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("registreerbetalingsverplichting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegistreerBetalingsverplichtingBoundary {

    @Inject
    private Event<BetalingsverplichtingOntvangen> event;

    @POST
    public Response registreer(JsonObject betalingsverplichting) {
        event.fire(new BetalingsverplichtingOntvangen(betalingsverplichting));
        return Response.ok().build();
    }

}
