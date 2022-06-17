/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Process.*;
import java.util.*;


public class IOController extends Thread {
    
    public void run() {
        List<IProcess> blockedProcessList = ProcessManager.getBlockedProcessList();
        // FALTA ORDENAR LA LISTA DE MENOR A MAYOR TIEMPO DE ESPERA DE E/S.
        while (!blockedProcessList.isEmpty()) {
            
        }
    }    
}
