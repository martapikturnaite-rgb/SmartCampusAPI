/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.store;

import com.smartcampusmarta.model.Room;
import com.smartcampusmarta.model.Sensor;
import com.smartcampusmarta.model.SensorReading;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author marta
 */
public class DataStore {
    //Statics are used to store data and share API requests
    //
    public static List<Room> rooms = new ArrayList<>();
    
    public static List<Sensor> sensors = new ArrayList<>();
    
    public static List<SensorReading> readings = new ArrayList<>();
    
    
    
    // Example of sample data has been created so that the API has initial rooms to return
    //When application has started, static will run
    static {
        rooms.add(new Room("LAB-100", "Computer Science Lab",80));
        rooms.add(new Room("ROOM-005", "Independent Study Room", 200));
        
        //Sample Sensors
        sensors.add(new Sensor("TEMP-022", "TEMPERATURE", "Active", 30.5, "LAB-100"));
        
        sensors.add(new Sensor("LIGHT-022", "LIGHT", "Active", 75, "ROOM-005"));
        
        sensors.add(new Sensor("FIRE-022", "Fire Alaram", "Maintenance", 0.0, "LAB-100"));
    }
    
    
    
}
