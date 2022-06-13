/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.obligatorio.Interface;
import com.mycompany.OperativeSystem.OperativeSystem;
import com.mycompany.obligatorio.Process.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;


public class ReanudeProcess extends javax.swing.JFrame {

    private static ReanudeProcess instance;
    /**
     * Creates new form ReanudeProcess
     */
    public ReanudeProcess() {
        initComponents();
        this.getContentPane().setBackground(new Color(55,63,71));
        suspendedProcessTable.getTableHeader().setOpaque(true);
        suspendedProcessTable.getTableHeader().setBackground(new Color(0,51,64));
        suspendedProcessTable.getTableHeader().setForeground(Color.WHITE);
        suspendedProcessTable.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(0,51,64)));
        suspendedProcessTable.getTableHeader().setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        jScrollPane1.getVerticalScrollBar().setBackground(new Color(55,63,71));
        setLocationRelativeTo(null);
    }
    
    public static ReanudeProcess getInstance() {
        if (instance == null) {
            instance = new ReanudeProcess();
        }
        return instance;
    }
    
    public void DisplaySuspendedProcess(List<IProcess> suspendedProcess) {
        Object[][] data = new Object[suspendedProcess.size()][5];
        
        int c = 0;
        
        for (IProcess process : suspendedProcess) {
            data[c][0] = process.getProcessPCB().getProcessID();
            data[c][1] = process.getProcessName();
            data[c][2] = process.getProcessSize();
            data[c][3] = process.getProcessPCB().getProcessState();
            data[c][4] = process.getProcessPCB().getProcessPath();
            c++;
        }
        
        suspendedProcessTable.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "ID", "Name", "Size", "State", "Path"
                }));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        suspendedProcessTable = new javax.swing.JTable();
        exitReanudeProcess = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        suspendedProcessTable.setBackground(new java.awt.Color(55, 63, 71));
        suspendedProcessTable.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        suspendedProcessTable.setForeground(new java.awt.Color(255, 255, 255));
        suspendedProcessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Size", "State", "Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        suspendedProcessTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suspendedProcessTable.setFillsViewportHeight(true);
        suspendedProcessTable.setGridColor(new java.awt.Color(55, 63, 71));
        suspendedProcessTable.setSelectionBackground(new java.awt.Color(0, 51, 64));
        suspendedProcessTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        suspendedProcessTable.setShowGrid(false);
        suspendedProcessTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suspendedProcessTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suspendedProcessTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(suspendedProcessTable);

        exitReanudeProcess.setBackground(new java.awt.Color(0, 51, 64));
        exitReanudeProcess.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        exitReanudeProcess.setForeground(new java.awt.Color(255, 255, 255));
        exitReanudeProcess.setText("Close");
        exitReanudeProcess.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 64), 3, true));
        exitReanudeProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitReanudeProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitReanudeProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(exitReanudeProcess)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suspendedProcessTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspendedProcessTableMousePressed
      
    }//GEN-LAST:event_suspendedProcessTableMousePressed

    private void suspendedProcessTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspendedProcessTableMouseClicked
        try {
            int row = suspendedProcessTable.getSelectedRow();
            String value = suspendedProcessTable.getModel().getValueAt(row, 0).toString();
            IProcess processToReanude = ProcessManager.getProcessSuspendedById(value);
            ProcessManager.reanudeProcess(processToReanude);
            this.setVisible(false);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un proceso o cerrar la ventana.");
        }
        finally {
            VentanaPrincipal.getInstance().DisplayProcess(OperativeSystem.getInstance().Memory.getAllProcessInMemory());
        }
    }//GEN-LAST:event_suspendedProcessTableMouseClicked

    private void exitReanudeProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitReanudeProcessActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_exitReanudeProcessActionPerformed

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
            java.util.logging.Logger.getLogger(ReanudeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReanudeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReanudeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReanudeProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReanudeProcess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitReanudeProcess;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable suspendedProcessTable;
    // End of variables declaration//GEN-END:variables
}