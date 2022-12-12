package org.acme.quarkus;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("quarkus")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuarkusResource {

    @Inject
    QuarkusService quarkusService;

    @GET
    public List<Quarkus> fetchAll() {
        return quarkusService.getAll();
    }

    @POST
    public Quarkus add(@Valid Quarkus quarkus) {
        return quarkusService.add(quarkus);
    }

    @Path("test")
    @GET
    public String test(@QueryParam("fail") Boolean fail) {
        if (fail != null && fail.equals(true)) {
            throw new BadRequestException("something failed");
        }

        return "Working";
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        if (id == null) {
            throw new BadRequestException("Missing id value!");
        }
        quarkusService.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
