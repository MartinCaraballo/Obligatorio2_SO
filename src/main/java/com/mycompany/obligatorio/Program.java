/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import com.mycompany.OperativeSystem.*;
/* import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Resources.*; */

public class Program {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        // Creamos 100 procesos en el sistema:
        Utils.AddProcesses(100);

        OperativeSystem operativeSystem = new OperativeSystem(4096, (byte)1);
        operativeSystem.LoadProcess();
        System.out.println(operativeSystem.Memory.viewMemory());
    }
}
