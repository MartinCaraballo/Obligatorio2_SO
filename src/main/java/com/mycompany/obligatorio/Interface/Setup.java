/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.obligatorio.Interface;

import com.mycompany.OperativeSystem.OperativeSystem;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author TomasUcu
 */
public class Setup extends javax.swing.JFrame {

    /**
     * Creates new form Setup
     */
    public Setup() {
        initComponents();
        this.getContentPane().setBackground(new Color(55, 63, 71));
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        fieldName1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonEnter = new javax.swing.JButton();
        fieldCantProcesadores = new javax.swing.JTextField();
        fieldCantTiempoProcesosEnCpu = new javax.swing.JTextField();
        fieldCantRAM = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Execution Time");

        fieldName1.setBackground(new java.awt.Color(0, 51, 64));
        fieldName1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        fieldName1.setForeground(new java.awt.Color(255, 255, 255));
        fieldName1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 64), 3, true));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Setup");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad de procesadores (cores)");

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad de tiempo que los procesos se encuentran en CPU");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cantidad de memoria principal del sistema (RAM)");

        buttonEnter.setBackground(new java.awt.Color(0, 51, 64));
        buttonEnter.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        buttonEnter.setForeground(new java.awt.Color(255, 255, 255));
        buttonEnter.setText("Enter");
        buttonEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEnterMouseClicked(evt);
            }
        });
        buttonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnterActionPerformed(evt);
            }
        });

        fieldCantProcesadores.setBackground(new java.awt.Color(0, 51, 64));
        fieldCantProcesadores.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        fieldCantProcesadores.setForeground(new java.awt.Color(255, 255, 255));
        fieldCantProcesadores.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 64), 3, true));

        fieldCantTiempoProcesosEnCpu.setBackground(new java.awt.Color(0, 51, 64));
        fieldCantTiempoProcesosEnCpu.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        fieldCantTiempoProcesosEnCpu.setForeground(new java.awt.Color(255, 255, 255));
        fieldCantTiempoProcesosEnCpu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 64), 3, true));

        fieldCantRAM.setBackground(new java.awt.Color(0, 51, 64));
        fieldCantRAM.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        fieldCantRAM.setForeground(new java.awt.Color(255, 255, 255));
        fieldCantRAM.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 64), 3, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCantTiempoProcesosEnCpu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addComponent(fieldCantRAM, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCantProcesadores, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(buttonEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(fieldCantProcesadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(fieldCantTiempoProcesosEnCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldCantRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEnterMouseClicked
        try {
            byte cores = (byte) Integer.parseInt(fieldCantProcesadores.getText());
            float cantTimeout = Float.valueOf(fieldCantTiempoProcesosEnCpu.getText());
            int cantMemoriaSys = Integer.valueOf(fieldCantRAM.getText());
            
            if (cores < 1 || cores > 8) {
                throw new Exception();
            }
            else if (cores % 2 != 0 && cores != 1) {
                throw new Exception();
            }
            else if (cantMemoriaSys < 0 || cantMemoriaSys % 2 != 0) {
                throw new Exception();
            }
            
            OperativeSystem.getInstance(cantMemoriaSys, cores);
            this.setVisible(false);
            VentanaPrincipal.getInstance().setVisible(true);
        } 
        catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(this, "Para los campos:\nCantidad de procesadores: los valores deben ser enteros pares entre 1 y 8.\nCantidad de tiempo que los procesos se encuentran en CPU: Los valores deben ser numéricos (si son flotantes con punto)\nCantidad de memoria principal del sistema: los valores deben ser enteros positivos pares.");
        }
    }//GEN-LAST:event_buttonEnterMouseClicked

    private void buttonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEnterActionPerformed

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
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEnter;
    private javax.swing.JTextField fieldCantProcesadores;
    private javax.swing.JTextField fieldCantRAM;
    private javax.swing.JTextField fieldCantTiempoProcesosEnCpu;
    private javax.swing.JTextField fieldName1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
