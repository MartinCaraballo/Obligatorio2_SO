/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Process.*;
import java.util.*;


public class IOController extends Thread {
    
    public long sleepCount = 0;
    public boolean running  = false;
    
    public void run() {
        this.running = true;
        List<IProcess> blockedProcessList = ProcessManager.getBlockedProcessList();
        while (!blockedProcessList.isEmpty()) {
            try {
                for (IProcess process : blockedProcessList) {
                    if (process.getTimeConsumedIO() <= this.sleepCount) {
                        ProcessManager.removeBlockedProcessList(process);   
                    } else {
                        Thread.sleep((long)process.getTimeConsumedIO());
                        this.sleepCount += (long)process.getTimeConsumedIO();
                        ProcessManager.removeBlockedProcessList(process);
                    }
                }
                dispatch();
                
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        this.sleepCount = 0;
        dispatch();
    }
    
    // Si el hilo de dispatch esta "muerto", quiere decir que no esta despachando, por lo cual lo volvemos a hacer.
    public void dispatch() {
        if (!OperativeSystem.getInstance().scheduller.isAlive()) {
            OperativeSystem.getInstance().dispatch();
        }
    }
}
