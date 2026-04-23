/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.application;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.JacksonFeature;



        

/**
 *
 * @author marta
 */
@ApplicationPath("/api/v1")
public class SmartCampusApplication extends ResourceConfig{
    
    public SmartCampusApplication(){
        packages("com.smartcampusmarta");
        register(JacksonFeature.class);
        
        
        
       
        
    }
    
    
    
}
