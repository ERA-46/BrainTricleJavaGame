/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.code;

import io.quickchart.QuickChart;

/**
 *This class will send data to the http://quickchart.io/ and generate the score chart
 * @author Eranda
 */
public class quickChart {
  
    /**
     * This method will generate the scoreboard as a bar chart for the all players.
     * @param data contains the player names and their marks in 2D array
     * @return the generated chart 
     */
    public String chartData(String [][] data){
    
        String chartGen = null;
        System.out.println("Marks  ready to send!");
        
        chartGen = "{" + 
                    "type: 'bar'," +   
                        "data: {" +
                                "labels: ['"+data[0][0]+"', '"+data[1][0]+"', '"+data[2][0]+"', '"+data[3][0]+"', '"+data[4][0]+"']," +  //player names
                                        "datasets: [{" +
                                                  "label: 'SCORE BOARD'," +                         // Create the 'Users' dataset
                                                        "data: ['"+Integer.parseInt(data[0][1])+"', '"+Integer.parseInt(data[1][1])+"', '"+Integer.parseInt(data[2][1])+"', '"+Integer.parseInt(data[3][1])+"', '"+Integer.parseInt(data[4][1])+"']" +   //marks
                                                    "}]" +
                                "}" +
                    "}";
               
        System.out.println("Marks sent!");
        
        return chartGen;
    }
    
    /**
     * This method will generate the player score as a doughnut chart.
     * @param score contains the player score
     * @return  the generated chart
     */
    public String chartScore(String score){
        
        String scoreGen = null;
        String label = "Your Score";
        
        scoreGen = "{\n" +
                "  type: 'doughnut',\n" +
                "  data: {\n" +
                "    datasets: [\n" +
                "      {\n" +
                "        data: ["+Integer.parseInt(score)+"],\n" +  //score
                "        backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)', ],\n" +
                "      },\n" +
                "    ],\n" +
                "    labels: ['"+label+"'],\n" +
                "  },\n" +
                "  options: {\n" +
                "    plugins: {\n" +
                "      datalabels: {\n" +
                "        formatter: (value) => {\n" +
                "          return value + '%';\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
       
        return scoreGen;
    }
    
    /**
     * This method will generate the player score board by sending the data to the QuickChart web service
     * @param data contains the player names and scores
     * @return URL of the chart as a String
     */
    public String gameChart(String [][] data){

        QuickChart chartgen = new QuickChart();
        
        chartgen.setWidth(500);
        chartgen.setHeight(300);
        chartgen.setConfig(chartData(data));
        System.out.println(chartgen.getShortUrl());
        
        String url = chartgen.getShortUrl();
        
        return url;
    }

    /**
     * This method will generate the player score chart by sending the data to the QuickChart web service
     * @param sco contains the player score
     * @return URL of the chart as a String
     */
    public String scoreChart(String sco) {
        
        QuickChart chart = new QuickChart();
        
        chart.setWidth(500);
        chart.setHeight(300);
        chart.setConfig(chartScore(sco));
        System.out.println(chart.getUrl());
        
        String url = chart.getShortUrl();

        return url;
    }  
}

