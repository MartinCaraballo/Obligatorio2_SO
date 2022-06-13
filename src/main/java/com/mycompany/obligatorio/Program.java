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
        
      //OperativeSystem.getInstance(2048, (byte)1);
      //Ventana
      Setup setup = new Setup();
      setup.setVisible(true);
      //VentanaPrincipal ventana = VentanaPrincipal.getInstance();
      //ventana.setVisible(true);
      //ventana.DisplayProcess(os.Memory.getAllProcessInMemory());
    }
}
