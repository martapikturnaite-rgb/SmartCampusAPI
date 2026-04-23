/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcampusmarta.exception;

/**
 *
 * @author marta
 */
public class RoomNotEmptyException  extends RuntimeException {
    // Constructor that takes the message explaining the error happenig
    public RoomNotEmptyException(String message) {
        super(message);
        
        
    }
    
    
}
