/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author marta
 */
@Provider
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {
    //Method runs when Mapper is thrown
    @Override
    public Response toResponse(SensorUnavailableException exception){
        //Returns 403
        return Response.status(403)
                .entity("Error 403- Sensor is unavailable: " + exception.getMessage())
                .build();
    }
    
}
