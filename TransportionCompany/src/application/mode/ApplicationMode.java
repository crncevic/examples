/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.mode;

import factory.Creator;
import service.Service;

/**
 *
 * @author Petar
 */
public abstract class ApplicationMode {
    
    protected Creator creator;
    protected Service service;
    
    public abstract void startConversation();
    public abstract void chooseDestination();
    public abstract void drive();
    
    
    
}
