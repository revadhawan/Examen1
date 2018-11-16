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
        } 
        
        catch (StationNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }
               
                   
    //Add bike
    @POST
    @ApiOperation(value = "add bike", notes = "ksdj")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Error")
    })
    
    @Path("/addBike")
    @Produces(MediaType.APPLICATION_JSON) 
        
    public Response addBike(Bike bike) {
        String idBike = bike.getIdBike();
        String description = bike.getDescription();
        double kms = bike.getKm();
        String idStation = bike.getIdStation();

        
        
        
        
        
        
        
        
        
      
    }
    
