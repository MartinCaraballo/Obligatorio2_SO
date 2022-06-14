/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import com.mycompany.OperativeSystem.*;
import com.mycompany.obligatorio.Interface.*;
import com.mycompany.obligatorio.Resources.CPU;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        
      //OperativeSystem.getInstance(2048, (byte)1);
      //Ventana
      Setup setup = new Setup();
      setup.setVisible(true);
      
      while (true) {
        if (!OperativeSystem.getInstance().Memory.getAllProcessInMemory().isEmpty()) {
            System.out.println("xd");
            OperativeSystem.getInstance().scheduller.dispatch(CPU.freeCPU());
        }
      }
      //VentanaPrincipal ventana = VentanaPrincipal.getInstance();
      //ventana.setVisible(true);
      //ventana.DisplayProcess(os.Memory.getAllProcessInMemory());
    }
}
