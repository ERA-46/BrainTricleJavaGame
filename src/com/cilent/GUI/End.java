/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cilent.GUI;

import com.server.code.marking;
import com.server.rmiserver.ServiceInterface;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *Generate the player marks from the QuickChart and display
 * @author Eranda
 */
public class End extends javax.swing.JFrame {

    Registry reg = null;
    /**
     * This will pass the player score to the QuichChart service and generate score chart. 
     */
    public End(){
        initComponents();
        int score = marking.calMarks(0);
        
        try {
                reg = LocateRegistry.getRegistry("localhost", 2000);
                ServiceInterface inter = (ServiceInterface) reg.lookup("RMIserver");

                //passing the socre to the QuickChart method via RMI Server
                Image image = null;
                URL url = new URL(inter.printScore(score));
                
                image = ImageIO.read(url.openStream()).getScaledInstance(lblChart.getWidth(), lblChart.getHeight(), image.SCALE_SMOOTH);	
                        ImageIcon icon = new ImageIcon(image); 			
			lblChart.setIcon(icon); //showing the received chart in a label
         
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                System.out.println("Exception " + ex);
            } catch (IOException ex) {
            Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblChart = new javax.swing.JLabel();
        btnScoreBoard = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 500, 34));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("You have done it! Congratulations on your Great achievement!!!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        lblChart.setBackground(new java.awt.Color(255, 255, 255));
        lblChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 500, 300));

        btnScoreBoard.setText("View Score Board");
        btnScoreBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreBoardActionPerformed(evt);
            }
        });
        jPanel1.add(btnScoreBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 500, 37));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/undraw_well_done_i2wr.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, 190, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnScoreBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreBoardActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new scoreBoard().setVisible(true);
    }//GEN-LAST:event_btnScoreBoardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new End().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnScoreBoard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChart;
    // End of variables declaration//GEN-END:variables
}