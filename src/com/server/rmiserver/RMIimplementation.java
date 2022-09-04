/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.rmiserver;

import com.databaseLayer.dbConnection;
import com.server.code.quickChart;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.rmi.NotBoundException;
import java.sql.ResultSet;

/**
 *This class contains method bodies in the ServiceInterface class.
 * @author Eranda
 */
public class RMIimplementation extends UnicastRemoteObject implements ServiceInterface{
    
    
    
    protected RMIimplementation() throws RemoteException, NotBoundException{
    
        super();
        
    }

     Connection conn = dbConnection.databaseConnection(); //establish the connection with the database
     quickChart chart = new quickChart(); //create an instance in QuickChart
     
     /**
      * This method is created for new player registration.
      * @param name player name 
      * @param age player age
      * @param password password for the account
      * @throws RemoteException 
      */
    @Override
    public void addNewUser(String name, String age, String password) throws RemoteException {

        String sql = "INSERT INTO `users`(`name`, `age`, `password`) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(age));
            ps.setString(3, password);
            
            ps.execute();
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }     
    }
    
    /**
     * This method created for user login part.
     * it will get the requested username and password from the database.
     * otherwise it will return false.
     * @param name username of the player
     * @param password password for the player account
     * @return result as a boolean
     * @throws RemoteException 
     */
    @Override
    public boolean userLogin(String name, String password) throws RemoteException{
    
        String sql = "SELECT `name`, `password`FROM `users` WHERE `name`='"+name+"' AND `password`='"+password+"'";
        ResultSet rs; 
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }       
        return false;
    }

    /**
     * This method will submit player marks to the 'marks' table in the database
     * @param logger player name
     * @param answer player marks 
     * @throws RemoteException 
     */
    @Override
    public void submitMarks(String logger, String answer) throws RemoteException {
        
        String sql = "INSERT INTO `marks`(`user`, `score`) VALUES (?, ?)";

         try {
            PreparedStatement ps = conn.prepareStatement(sql);   
            
            ps.setString(1, logger);
            ps.setInt(2, Integer.parseInt(answer));
            ps.execute();
            
            System.out.println("Answers Submitted");
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }
    }

    /**
     * This method will get player names and their marks from the database to an array.
     * It will pass the array to QuickChart method to generate scoreboard
     * @return URL of the chart
     * @throws RemoteException 
     */
    @Override
    public String printScoreChart() throws RemoteException {
        
        //String sql = "SELECT * FROM `marks`";
        String sql = "SELECT * FROM `marks` LIMIT 5";
        String [][] data = new String [5][2];
        String url = null;
        ResultSet rs;
        int i = 0;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);   
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                data[i][0] = rs.getString("user");
                data[i][1] = rs.getString("score");
                
                i++;
            }
            
            System.out.println("Marks Collected");
            
            url = chart.gameChart(data);
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }              
        return url;
    }

    /**
     * This method will pass the player score to the QuickChart to generate chart to show player marks
     * @param score player score
     * @return URL of the chart
     * @throws RemoteException 
     */
    @Override
    public String printScore(int score) throws RemoteException {
        
        String url  = null;
        String sco = String.valueOf(score);
        
        url = chart.scoreChart(sco);
        
        return url;
    }    
}
