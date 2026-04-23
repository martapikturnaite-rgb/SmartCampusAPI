/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marta
 */
@Provider
public class GlobalExceptionMapper  implements ExceptionMapper<Throwable> {
    //Logger to print the error
    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionMapper.class.getName());
    
    //Method catches any unhandled exceptions
    
    @Override
    public Response toResponse (Throwable exception) {
        //Logging the error
        LOGGER.log(Level.SEVERE, "an unexpected error has occured ", exception);
        
        return Response.status(500)
                .entity("Error 500 - An error has occured on the server!")
                .build();
    }
    
}
