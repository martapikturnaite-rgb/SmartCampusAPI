/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.resource;

import com.smartcampusmarta.model.Room;
import com.smartcampusmarta.model.Sensor;
import com.smartcampusmarta.store.DataStore;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author marta
 */
@Path("/sensors")
public class SensorResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getAllSensors(@QueryParam("type") String type) {
        if (type != null && !type.trim().isEmpty()) {
            List<Sensor> filtered = new ArrayList<>();
            for (Sensor sensor : DataStore.sensors) {
                if(sensor.getType() != null && sensor.getType().equalsIgnoreCase(type)) {
                    filtered.add(sensor);
                    
                }
            }
            return filtered;
            
        }
        return DataStore.sensors;
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSensor(Sensor sensor) {
        boolean roomExists = false;
        
        for (Room room : DataStore.rooms) {
            if (room.getId().equals(sensor.getRoomId())) {
                roomExists = true;
                room.getSensorIds().add(sensor.getId());
                break;
            }
        }
        
        if (!roomExists) {
            return Response.status(422)
                    .entity("Room not found - cannot add sensor!")
                    .build();
            
        }
        
        DataStore.sensors.add(sensor);
                return Response.status(201).entity(sensor).build();
                
    }
    
    @GET
    @Path("/{sensorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSensorById(@PathParam("sensorId") String sensorId) {
        for(Sensor sensor : DataStore.sensors) {
            if (sensor.getId().equals(sensorId)) {
                return Response.ok(sensor).build();
                
            }
        }
        
        return Response.status(404).entity("Sensor has not been found").build();
    }
    
    
}
