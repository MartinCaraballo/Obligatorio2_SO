/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import com.mycompany.obligatorio.Process.Process;
import com.mycompany.OperativeSystem.*;
import java.util.Random;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Resources.*;


public class Program {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        Memory memory = new Memory(1024);
        
        // for para crear procesos.
        for (int i = 0; i < 4; i++) {
            String stringI = Integer.toString(i);
            Random random = new Random();
            // Genera un número aleatorio entre 0 y el valor de esta variable.
            int randomUpperBound = 15;
            IProcess process = ProcessManager.CreateInstanceOfProcess("/home/process" + stringI, "Proceso" + stringI, stringI, 512, random.nextInt(randomUpperBound), random.nextInt(randomUpperBound), random.nextInt(randomUpperBound));
            ProcessManager.AddProcessCreatedToList(process);
        }

        // Imprime si la memoria tiene espacio para cargar todos esos procesos creados.
        //System.out.println(memory.MemoryHasSpace());

        /* for (IProcess process : ProcessManager.GetProcessList()) {
            System.out.println(process.GetProcessState());
        } */

        byte numberOfCores = 1;
        OperativeSystem operativesystem = new OperativeSystem(1024, numberOfCores);
        operativesystem.LoadProcess();
        System.out.println(operativesystem.Memory.ViewMemory());
    }
}
