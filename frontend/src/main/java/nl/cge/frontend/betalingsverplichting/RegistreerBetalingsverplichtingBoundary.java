package nl.cge.frontend.betalingsverplichting;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("registreerbetalingsverplichting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegistreerBetalingsverplichtingBoundary {

    @GET
    public Response registreer() {
        return Response.ok().build();
    }

    @POST
    public Response registreer(JsonObject betalingsverplichting) {
        System.out.println("registreer betalingsverplichting");
        System.out.println(betalingsverplichting.toString());
        String heffingkenmerk = betalingsverplichting.getString("heffingkenmerk");
        System.out.println(heffingkenmerk);
        System.out.println(betalingsverplichting.getJsonObject("middelspecifiek").getString("volledig-tijdvak-begindatum"));
        return Response.ok().build();
    }

}
