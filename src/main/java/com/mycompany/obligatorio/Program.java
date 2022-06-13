/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import com.mycompany.OperativeSystem.*;
import com.mycompany.obligatorio.Process.IProcess;
import com.mycompany.obligatorio.Interface.*;
import java.util.ArrayList;        



public class Program {

    public static void main(String[] args) {
        
        // Creamos 100 procesos en el sistema:
        //Utils.AddProcesses(100);
        
//        OperativeSystem os = OperativeSystem.getInstance(4096, (byte) 1);
        //os.LoadProcess();
        //System.out.println(os.Memory.viewMemory());
        
//        Ventana
        new Setup().setVisible(true);
//        VentanaPrincipal ventana = VentanaPrincipal.getInstance();
//        ventana.setVisible(true);
//        ventana.DisplayProcess(os.Memory.getAllProcessInMemory());
    }
}
