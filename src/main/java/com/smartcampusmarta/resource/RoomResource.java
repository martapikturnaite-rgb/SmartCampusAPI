/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.resource;

import com.smartcampusmarta.model.Room;
import com.smartcampusmarta.store.DataStore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 *
 * @author marta
 */

@Path("/rooms")
public class RoomResource {
    //GET All rooms
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms() {
        return DataStore.rooms;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Room addRoom(Room room) {
        DataStore.rooms.add(room);
        return room;
    }
    
    //Get one room by the id
    
    @GET
    @Path("/{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room getRoomById(@PathParam("roomId") String roomId) {
        for (Room room : DataStore.rooms) {
            if (room.getId().equals(roomId)) {
                return room;
            }
        }
        return null;
        
    }
    @DELETE
    @Path("/{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteRoom(@PathParam("roomId") String roomId) {
        
        for (int i = 0; i < DataStore.rooms.size(); i++) {
            Room room = DataStore.rooms.get(i);
            if (room.getId().equals(roomId)){
            
            if (room.getSensorIds()  != null && !room.getSensorIds().isEmpty()) {
                return "Sensors detected, room cannot be deleted.";
                
            
        }
            DataStore.rooms.remove(i);
                return "Room deleted successfully.";
            }
        }

        return "Room not found.";
    }

    
    
    
  
    
}
