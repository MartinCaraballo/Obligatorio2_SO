/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.obligatorio.Interface;

import com.mycompany.OperativeSystem.OperativeSystem;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Process.ProcessControlBlock.State;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;


public class VentanaPrincipal extends javax.swing.JFrame {

    private static VentanaPrincipal instance;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.getContentPane().setBackground(new Color(55,63,71));
        ProcessTable.getTableHeader().setOpaque(true);
        ProcessTable.getTableHeader().setBackground(new Color(0,51,64));
        ProcessTable.getTableHeader().setForeground(Color.WHITE);
        ProcessTable.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(0,51,64)));
        ProcessTable.getTableHeader().setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        jScrollPane2.getVerticalScrollBar().setBackground(new Color(55,63,71));
        setLocationRelativeTo(null);
        
    }
    
    public static VentanaPrincipal getInstance() {
        if (instance == null) {
            instance = new VentanaPrincipal();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        processTablePopupMenu = new javax.swing.JPopupMenu();
        processTableMenuSuspendProcess = new javax.swing.JMenuItem();
        processTableMenuReanudeProcess = new javax.swing.JMenuItem();
        processTableMenuFinalizeProcess = new javax.swing.JMenuItem();
        processTableMenuModifyProcessPriority = new javax.swing.JMenuItem();
        ReturnSetup = new javax.swing.JButton();
        AddProcess = new javax.swing.JButton();
        LoadManyProcess = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProcessTable = new javax.swing.JTable();
        MemoryUsageBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProcessInExecution = new javax.swing.JList<>();

        jRadioButton1.setText("jRadioButton1");

        jToggleButton1.setText("jToggleButton1");

        processTablePopupMenu.setBackground(new java.awt.Color(55, 63, 71));
        processTablePopupMenu.setForeground(new java.awt.Color(255, 255, 255));
        processTablePopupMenu.setOpaque(false);

        processTableMenuSuspendProcess.setText("Suspend");
        processTableMenuSuspendProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processTableMenuSuspendProcessActionPerformed(evt);
            }
        });
        processTablePopupMenu.add(processTableMenuSuspendProcess);

        processTableMenuReanudeProcess.setText("Reanude");
        processTableMenuReanudeProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processTableMenuReanudeProcessActionPerformed(evt);
            }
        });
        processTablePopupMenu.add(processTableMenuReanudeProcess);

        processTableMenuFinalizeProcess.setText("Finalize");
        processTableMenuFinalizeProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processTableMenuFinalizeProcessActionPerformed(evt);
            }
        });
        processTablePopupMenu.add(processTableMenuFinalizeProcess);

        processTableMenuModifyProcessPriority.setText("Modify priority");
        processTableMenuModifyProcessPriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processTableMenuModifyProcessPriorityActionPerformed(evt);
            }
        });
        processTablePopupMenu.add(processTableMenuModifyProcessPriority);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(55, 63, 71));
        setForeground(new java.awt.Color(51, 255, 0));
        setResizable(false);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        ReturnSetup.setBackground(new java.awt.Color(0, 51, 64));
        ReturnSetup.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ReturnSetup.setForeground(new java.awt.Color(255, 255, 255));
        ReturnSetup.setText("Return Setup");
        ReturnSetup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnSetupMouseClicked(evt);
            }
        });
        ReturnSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnSetupActionPerformed(evt);
            }
        });

        AddProcess.setBackground(new java.awt.Color(0, 51, 64));
        AddProcess.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        AddProcess.setForeground(new java.awt.Color(255, 255, 255));
        AddProcess.setText("Add Process");
        AddProcess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddProcessMouseClicked(evt);
            }
        });
        AddProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProcessActionPerformed(evt);
            }
        });

        LoadManyProcess.setBackground(new java.awt.Color(0, 51, 64));
        LoadManyProcess.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        LoadManyProcess.setForeground(new java.awt.Color(255, 255, 255));
        LoadManyProcess.setText("Load Many Process");
        LoadManyProcess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoadManyProcessMouseClicked(evt);
            }
        });
        LoadManyProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadManyProcessActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(0, 51, 64));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 64), 3, true));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setOpaque(false);

        ProcessTable.setBackground(new java.awt.Color(55, 63, 71));
        ProcessTable.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        ProcessTable.setForeground(new java.awt.Color(255, 255, 255));
        ProcessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Size", "State", "Priority", "Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.Byte.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ProcessTable.setComponentPopupMenu(processTablePopupMenu);
        ProcessTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProcessTable.setFillsViewportHeight(true);
        ProcessTable.setGridColor(new java.awt.Color(55, 63, 71));
        ProcessTable.setSelectionBackground(new java.awt.Color(0, 51, 64));
        ProcessTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(ProcessTable);

        MemoryUsageBar.setBackground(new java.awt.Color(55, 63, 71));
        MemoryUsageBar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        MemoryUsageBar.setForeground(new java.awt.Color(0, 255, 0));
        MemoryUsageBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 64), 3, true));
        MemoryUsageBar.setStringPainted(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Memory Usage");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Process in execution:");

        ListProcessInExecution.setBackground(new java.awt.Color(55, 63, 71));
        ListProcessInExecution.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ListProcessInExecution.setForeground(new java.awt.Color(255, 255, 255));
        ListProcessInExecution.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListProcessInExecution);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MemoryUsageBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LoadManyProcess)
                            .addComponent(ReturnSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(AddProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(LoadManyProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(ReturnSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MemoryUsageBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnSetupActionPerformed
    }//GEN-LAST:event_ReturnSetupActionPerformed

    private void LoadManyProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadManyProcessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadManyProcessActionPerformed

    private void AddProcessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProcessMouseClicked
        AddProcess addP = new AddProcess();
        addP.setVisible(true);
    }//GEN-LAST:event_AddProcessMouseClicked

    private void AddProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProcessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddProcessActionPerformed

    private void LoadManyProcessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadManyProcessMouseClicked
        new LoadManyProcess().setVisible(true);
    }//GEN-LAST:event_LoadManyProcessMouseClicked

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void ReturnSetupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnSetupMouseClicked
        OperativeSystem.getInstance().resetSystem();
        this.setVisible(false);
        new Setup().setVisible(true);
    }//GEN-LAST:event_ReturnSetupMouseClicked

    private void processTableMenuSuspendProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processTableMenuSuspendProcessActionPerformed
        try {
            int row = ProcessTable.getSelectedRow();
            String value = ProcessTable.getModel().getValueAt(row, 0).toString();
            IProcess processToSuspend = ProcessManager.getProcessById(value);
            ProcessManager.suspendProcess(processToSuspend);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Deben de existir procesos y tener uno seleccionado para poder suspenderlo.");
        }
        finally {
            this.DisplayProcess(OperativeSystem.getInstance().Memory.getAllProcessInMemory());
        }
    }//GEN-LAST:event_processTableMenuSuspendProcessActionPerformed

    private void processTableMenuReanudeProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processTableMenuReanudeProcessActionPerformed
        try {
            if (ProcessManager.getSuspendedProcessList().size() < 1) {
                throw new Exception();
            }
            ReanudeProcess ventana = ReanudeProcess.getInstance();
            ventana.DisplaySuspendedProcess(ProcessManager.getSuspendedProcessList());
            ventana.setVisible(true);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No encontré procesos suspendidos para reanudar.");
        }
        finally {
            VentanaPrincipal.getInstance().DisplayProcess(OperativeSystem.getInstance().Memory.getAllProcessInMemory());
        }
    }//GEN-LAST:event_processTableMenuReanudeProcessActionPerformed

    private void processTableMenuFinalizeProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processTableMenuFinalizeProcessActionPerformed
        try {
            int row = ProcessTable.getSelectedRow();
            String value = ProcessTable.getModel().getValueAt(row, 0).toString();
            IProcess processToFinalize = ProcessManager.getProcessById(value);
            State stateOfProcess = processToFinalize.getProcessPCB().getProcessState();
            ProcessManager.finalizeProcess(processToFinalize);
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Deben de existir procesos y tener uno seleccionado para poder finalizarlo.");
        }
        finally {
            VentanaPrincipal.getInstance().DisplayProcess(OperativeSystem.getInstance().Memory.getAllProcessInMemory());
        }
    }//GEN-LAST:event_processTableMenuFinalizeProcessActionPerformed

    private void processTableMenuModifyProcessPriorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processTableMenuModifyProcessPriorityActionPerformed
        try {
            int row = ProcessTable.getSelectedRow();
            String value = ProcessTable.getModel().getValueAt(row, 0).toString();
            IProcess processToModifyPriority = ProcessManager.getProcessById(value);
            ModifyPriority.setProcessToModify(processToModifyPriority);
            new ModifyPriority().setVisible(true);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Deben de existir procesos y tener uno seleccionado para poder modificar su prioridad.");
        }
    }//GEN-LAST:event_processTableMenuModifyProcessPriorityActionPerformed


    public void DisplayProgressBar(int value) {
        MemoryUsageBar.setValue(value);
    }
    
    public void DisplayProcess(List<IProcess> readyProcess) {
        Object[][] data = new Object[readyProcess.size()][6];

        int c = 0;

        for (IProcess pr : readyProcess) {
            data[c][0] = pr.getProcessPCB().getProcessID();
            data[c][1] = pr.getProcessName();
            data[c][2] = pr.getProcessSize();
            data[c][3] = pr.getProcessPCB().getProcessState();
            data[c][4] = pr.getProcessPCB().getProcessPriority();
            data[c][5] = pr.getProcessPCB().getProcessPath();
            c++;
        }

        ProcessTable.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "ID", "Name", "Size", "State", "Priority", "Path"
                }));
        DisplayProgressBar((int)Math.round(OperativeSystem.getInstance().Memory.memoryUsage()));
    }

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProcess;
    private javax.swing.JList<String> ListProcessInExecution;
    private javax.swing.JButton LoadManyProcess;
    private javax.swing.JProgressBar MemoryUsageBar;
    private javax.swing.JTable ProcessTable;
    private javax.swing.JButton ReturnSetup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JMenuItem processTableMenuFinalizeProcess;
    private javax.swing.JMenuItem processTableMenuModifyProcessPriority;
    private javax.swing.JMenuItem processTableMenuReanudeProcess;
    private javax.swing.JMenuItem processTableMenuSuspendProcess;
    private javax.swing.JPopupMenu processTablePopupMenu;
    // End of variables declaration//GEN-END:variables

}
