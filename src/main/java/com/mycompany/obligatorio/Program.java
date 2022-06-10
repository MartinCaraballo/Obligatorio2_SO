/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import com.mycompany.OperativeSystem.*;
import java.util.ArrayList;        
import com.mycompany.obligatorio.Process.IProcess;


public class Program {

    public static void main(String[] args) {
        
        // Creamos 100 procesos en el sistema:
        Utils.AddProcesses(100);

        OperativeSystem operativeSystem = OperativeSystem.getInstance();
        operativeSystem.LoadProcess();
        System.out.println(operativeSystem.Memory.viewMemory());
        
        //Ventana
        //Utils.ventana.setVisible(true);
        //ArrayList<IProcess> arr = operativeSystem.Memory.getAllProcessInMemory();
        //Utils.ventana.DisplayProcess(arr);
    }
}
