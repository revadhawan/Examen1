package edu.upc.dsa.Service;

import edu.upc.dsa.Track;
import edu.upc.dsa.MyBike;
import edu.upc.dsa.MyBikeImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/bikes", description = "Endpoint to Bike Service")
@Path("/bikes")
public class BikeService {
    final static Logger log = Logger.getLogger(BikeService.class.getName());
    
    //Declarar interficie
    private MyBike tm;
    
    
    public BikeService() {
        this.tm = MyBikeImpl.getInstance();
        if (tm.size()==0) {
            this.tm.addUser("Pepe", "Luis", "Garcia");

    }
        
   @POST
    @ApiOperation(value = "Add User", notes = "Users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
        
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {
        String idUser = u.getIdUser();
        String name = u.getName();
        String surname = u.getSurname();
        this.mb.addUser(idUser, name, surname);

        return Response.status(201).build();
    }

        
         
    @POST
    @ApiOperation(value = "Add Station", notes = "Stations")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
        
    @Path("/addStation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStation(Station s) {
        String idStation = s.getIdUser();
        String description = s.getDescription();
        int max = s.getMax();
        double lat = s.getLat();
        double lon = s.getLon();
        this.mb.addStation(idStation, description, max, lat, lon);

        return Response.status(201).build();
    }    
        
    //Obtener bikes de una station sorted by kms
    @GET
    @ApiOperation(value = "get bikes from a Station", notes = "bikes list")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class, responseContainer="List of tracks"),
    })
    
    @Path("/sortbikesbykm/{idStation}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bikesByStationOrderByKms(@PathParam("idStation") String idStation) {
        try {
            LinkedList<Bike> bikes = this.mb.bikesByStationOrderByKms(idStation);
            GenericEntity<LinkedList<Bike>> entity = new GenericEntity<LinkedList<Bike>>(bikes){};
            return Response.status(201).entity(entity).build();
        } catch (StationNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }
        
        
        
        
        
        
        
        
        
        
    //Dame un track
    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    //En el Path damo id ya que la necesita para encontrar
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //Como pasas id -->@PathParam("id") int id
    public Response getTrack(@PathParam("id") int id) {
        //Guardas en t la track a partir del id
        Track t = this.tm.getTrack(id);
        //Si no existe da 404
        if (t == null)
            return Response.status(404).build();
        else
            return Response.status(201).entity(t).build();
    }
    //Borrar
    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") int id) {
        Track t = this.tm.getTrack(id);
        if (t == null)
            return Response.status(404).build();
        else
            //deleteTrack declarado en interfície
            this.tm.deleteTrack(id);
            return Response.status(201).build();
    }
    //Actualizar track
    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    //Como al actulizar no nos da la id sino el track entero hay que encontrar primero id
    @Path("/")
    public Response updateTrack(Track track) {
        Track t = this.tm.getTrack(track.getId());
        if (t == null)
            return Response.status(404).build();
        else
            //updateTrack declarado en interfície
            this.tm.updateTrack(t);
            return Response.status(201).build();
    }


    //Crear cancion
    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Track.class),
    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }

}
