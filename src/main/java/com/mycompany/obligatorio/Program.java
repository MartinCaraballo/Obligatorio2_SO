/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import com.mycompany.obligatorio.Interface.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Program {

    public static void main(String[] args) {
        
    //Ventana
    Setup setup = new Setup();
    setup.setVisible(true);
    
    Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            VentanaPrincipal.getInstance().DisplayProcess();
            VentanaPrincipal.getInstance().DisplayProcessInExecution();
            VentanaPrincipal.getInstance().DisplayBlockedProcess();
        }
    });
    timer.start();
    
    
    //VentanaPrincipal ventana = VentanaPrincipal.getInstance();
    //ventana.setVisible(true);
    //ventana.DisplayProcess(os.Memory.getAllProcessInMemory());
    }
}
