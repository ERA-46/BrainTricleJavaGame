/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *This ServiceInterface contains all abstract methods
 * @author Eranda
 */
public interface ServiceInterface extends Remote{
    
    public void addNewUser(String name, String age, String password) throws RemoteException;
   
    public boolean userLogin(String name, String password) throws RemoteException;
    
    public void submitMarks(String logger, String answer) throws RemoteException;

    public String printScoreChart() throws RemoteException;

    public String printScore(int score) throws RemoteException;   
}
