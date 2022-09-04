/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.databaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Establish the connection with the database
 * @author Eranda
 */
public class dbConnection {

    public static Connection databaseConnection(){

        Connection con;
        
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/braintrickle","root","");
            System.out.println("Connection established with the Database...");
            return con;
            
        } 
        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException \n"+e);
            return null;
        }
        catch(SQLException e)
        {
            System.out.println("SQLException \n"+e);
            return null;
        }
        catch(NullPointerException ex){
            System.out.println("Null pointer Error \n"+ex);
            return null;
        }
        
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  
}
