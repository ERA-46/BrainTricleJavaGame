/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.rmiserver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

/**
 *The RMI server class
 * I have refer some YouTube videos done by previous students https://www.youtube.com/watch?v=eiQq_wQrw84&ab_channel=PhilipNironNithianandan 
 * @author Eranda
 */
public class RMIServer {
    
    public static void main(String args[]) throws RemoteException, NotBoundException{
    
        Registry registry = null;
        RMIimplementation service = new RMIimplementation();
        
        try {
            registry = LocateRegistry.createRegistry(2000);
            registry.rebind("RMIserver", service);
            System.out.println("Server is Now runnig...\n");
        } catch (ExportException ex) {
            registry = LocateRegistry.getRegistry(2000);
            System.out.println("Server is Now runnig...\n");
        }   
    }   
}
