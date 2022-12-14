package com.cilent.GUI;

import com.server.code.marking;
import com.server.rmiserver.ServiceInterface;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/**
 *Level 10 for the game
 * @author Eranda
 */
public class Level_10 extends javax.swing.JFrame {
    
    int img, counter, temp;
    
    Registry reg = null;

    /**
     * Creates new form Level_1
     */
    public Level_10() {
        initComponents(); 
        img = imageLoad();
        timer();
        btnSubmit.setEnabled(false); //next level button will disable until select an answer
 
    }
    
    /**
     * This method will load random image from the level 10 images
     * @return image index
     */
    public int imageLoad(){
        
        String[] imageNames = new String[3];
        
        imageNames[0] = "L10_Q1.jpg"; 
        imageNames[1] = "L10_Q2.jpg";
        imageNames[2] = "L10_Q3.jpg";
        
        int max = 2;
        int min = 0;
        
        Random rand = new Random();
        int index = rand.nextInt(max - min +1) + min;
        
        final int ret;
        
        Image im = new ImageIcon(this.getClass().getResource("/Images/" + imageNames[index])).getImage();
        
        ImageIcon img = new ImageIcon(im);
        
        imgLoader.setIcon(img);

        //System.out.println(index);
        
        ret = index;
        
        return ret;
    }

    /**
     * Timer for level 10
     * When time is over, answers will submit and show the score chart
     */
    public void timer(){
    
        Timer time = new Timer();
        counter = 100;
        
        TimerTask task = new TimerTask(){
        
            @Override
            public void run(){
            
                lblTimer.setText(Integer.toString(counter));
                counter --;
                
                if(counter == -1){
                
                    time.cancel();
                    JOptionPane.showMessageDialog(rootPane, "Times Up! Answers Submitted!");
                    levelSwtich();
                }
                if(temp == 1){   
                    
                    time.cancel();   
                }
            }
        };
        time.scheduleAtFixedRate(task, 1000, 1000);
    }
    /**
     * If the time is over game will automatically submit the answers with the player name and display the score as a chart.
     */
    public void levelSwtich(){
        
        int ans = marking.calMarks(0);
        String answer = String.valueOf(ans);
        System.out.println("Your Score : " + answer);
        
        String logger = Login.logUser();
        
        System.out.println("Logged in : " + logger);
        
        try {
                reg = LocateRegistry.getRegistry("localhost", 2000);
                ServiceInterface inter = (ServiceInterface) reg.lookup("RMIserver");
                inter.submitMarks(logger, answer);
    
            } catch (NotBoundException | RemoteException ex) {
                System.out.println("Exception " + ex);
            }
        
        this.setVisible(false);
        new End().setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAnsA = new javax.swing.JButton();
        btnAnsD = new javax.swing.JButton();
        btnAnsB = new javax.swing.JButton();
        btnAnsC = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        imgLoader = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Brain Trickles");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("Level  10");

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnAnsA.setText("A");
        btnAnsA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnsAActionPerformed(evt);
            }
        });

        btnAnsD.setText("D");
        btnAnsD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnsDActionPerformed(evt);
            }
        });

        btnAnsB.setText("B");
        btnAnsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnsBActionPerformed(evt);
            }
        });

        btnAnsC.setText("C");
        btnAnsC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnsCActionPerformed(evt);
            }
        });

        lblTime.setText("Tme Remaining :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 549, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imgLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(btnAnsA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAnsB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAnsC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAnsD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblTime))
                    .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnAnsA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnsB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnsC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnsD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(imgLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:

        temp = 1; //if the player select an answer and submit the answers timer will cancel
        
        /**
         * When the submit button pressed total marks will calculate.
         * Then it will convert to a string and get player name.
         * Then it will call the submitMarks method to submit player marks and display as a chart.
         */
        int ans = marking.calMarks(0);
        String answer = String.valueOf(ans);
        System.out.println("Your Score : " + answer);
        
        String logger = Login.logUser();
        
        System.out.println("Logged in : " + logger);
        
        try {
                reg = LocateRegistry.getRegistry("localhost", 2000);
                ServiceInterface inter = (ServiceInterface) reg.lookup("RMIserver");
                inter.submitMarks(logger, answer);
    
            } catch (NotBoundException | RemoteException ex) {
                System.out.println("Exception " + ex);
            }
        
        this.setVisible(false);
        new End().setVisible(true);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnAnsAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnsAActionPerformed
        // TODO add your handling code here:
        //btnAnsA.setEnabled(false);
        btnAnsB.setEnabled(false);
        btnAnsC.setEnabled(false);
        btnAnsD.setEnabled(false);
        btnSubmit.setEnabled(true);

        System.out.println("Wrong Answer!"); 

    }//GEN-LAST:event_btnAnsAActionPerformed

    private void btnAnsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnsBActionPerformed
        // TODO add your handling code here:
        btnAnsA.setEnabled(false);
        //btnAnsB.setEnabled(false);
        btnAnsC.setEnabled(false);
        btnAnsD.setEnabled(false);
        btnSubmit.setEnabled(true);

        /**
         * Check the answer with image index
         * If the correct answer selected, score will be increased by 10
         */
        if(img == 0){
            
             marking.calMarks(10);
             System.out.println("Answer Correct!");
        }
        else
           System.out.println("Wrong Answer!"); 
    }//GEN-LAST:event_btnAnsBActionPerformed

    private void btnAnsCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnsCActionPerformed
        // TODO add your handling code here:
        btnAnsA.setEnabled(false);
        btnAnsB.setEnabled(false);
        //btnAnsC.setEnabled(false);
        btnAnsD.setEnabled(false);
        btnSubmit.setEnabled(true);

        if(img == 2){
            
             marking.calMarks(10);
             System.out.println("Answer Correct!");
        }
        else
           System.out.println("Wrong Answer!"); 
    }//GEN-LAST:event_btnAnsCActionPerformed

    private void btnAnsDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnsDActionPerformed
        // TODO add your handling code here:
        btnAnsA.setEnabled(false);
        btnAnsB.setEnabled(false);
        btnAnsC.setEnabled(false);
        //btnAnsD.setEnabled(false);
        btnSubmit.setEnabled(true);

        if(img == 1){
            
             marking.calMarks(10);
             System.out.println("Answer Correct!");
        }
        else
           System.out.println("Wrong Answer!"); 
    }//GEN-LAST:event_btnAnsDActionPerformed

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
            java.util.logging.Logger.getLogger(Level_10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Level_10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Level_10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Level_10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Level_10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnsA;
    private javax.swing.JButton btnAnsB;
    private javax.swing.JButton btnAnsC;
    private javax.swing.JButton btnAnsD;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel imgLoader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimer;
    // End of variables declaration//GEN-END:variables
}
