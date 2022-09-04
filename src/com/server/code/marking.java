/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.code;

/**
 *This class is created to calculate player marks
 * @author Eranda
 */
public class marking {
    
    static int finalMark = 0;
    
    public static int calMarks(int mark){

        finalMark = finalMark + mark;
        
        return finalMark;
    }    
}
