/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.obligatorio;
import com.mycompany.OperativeSystem.*;
import com.mycompany.obligatorio.Interface.*;
import com.mycompany.obligatorio.Resources.CPU;

public class Program {

    public static void main(String[] args) {
        
      //OperativeSystem.getInstance(2048, (byte)1);
      //Ventana
      Setup setup = new Setup();
      setup.setVisible(true);
      while (true){
       // System.out.println("entro");

          System.out.println(OperativeSystem.getInstance().Memory.getAllProcessInMemory().isEmpty());
        if (!OperativeSystem.getInstance().Memory.getAllProcessInMemory().isEmpty()){
            OperativeSystem.getInstance().scheduller.dispatch(CPU.freeCPU());
            System.out.println("cdvfb");
        }
      }
      //VentanaPrincipal ventana = VentanaPrincipal.getInstance();
      //ventana.setVisible(true);
      //ventana.DisplayProcess(os.Memory.getAllProcessInMemory());
    }
}
