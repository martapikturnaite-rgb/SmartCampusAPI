/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.exception;

/**
 *
 * @author marta
 */
public class SensorUnavailableException extends RuntimeException {
    // Constructor that takes the message explainig the error
    public SensorUnavailableException(String message) {
        
        super(message);
    }
    
}
