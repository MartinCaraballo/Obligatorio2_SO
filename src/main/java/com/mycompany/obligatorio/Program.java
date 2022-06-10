/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import java.util.ArrayList;
        
import com.mycompany.obligatorio.Process.IProcess;
public class Program {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        // Imprime si la memoria tiene espacio para cargar todos esos procesos creados.
        //System.out.println(memory.MemoryHasSpace());

        /* for (IProcess process : ProcessManager.GetProcessList()) {
            System.out.println(process.GetProcessState());
        } */
        
        // Creamos 100 procesos en el sistema:
        Utils.AddProcesses(100);

        Utils.operativeSystem.LoadProcess();
        
//        System.out.println(Utils.operativeSystem.Memory.viewMemory());
        
        //Ventana
        Utils.ventana.setVisible(true);
        ArrayList<IProcess> arr = Utils.operativeSystem.Memory.getAllProcessInMemory();
        Utils.ventana.DisplayProcess(arr);
    }
}
