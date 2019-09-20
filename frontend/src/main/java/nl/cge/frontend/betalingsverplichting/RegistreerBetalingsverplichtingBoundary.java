package nl.cge.frontend.betalingsverplichting;

import nl.cge.common.events.ApplicationEvent;
import nl.cge.common.events.BetalingsverplichtigOntvangen;

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
    @BetalingsverplichtigOntvangen
    private Event<ApplicationEvent> betalingsverplichtingOntvangen;

    @POST
    public Response registreer(JsonObject betalingsverplichting) {
        betalingsverplichtingOntvangen.fire(new ApplicationEvent("RegistrerenBetalingsverplichting", betalingsverplichting));
        return Response.ok().build();
    }

}
