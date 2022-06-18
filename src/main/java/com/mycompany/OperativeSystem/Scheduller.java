/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;

import java.util.*;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Resources.CPU;

public class Scheduller extends Thread {

    //Despacha el primer proceso de la lista de listos en CPU
    public void run() {
        try {
            CPU[] cores = CPU.getCores();
            long timeout = (long) cores[0].getTimeout();
            List<IProcess> tasks = new ArrayList<>();
            while (!OperativeSystem.getInstance().Memory.getReadyProcess().isEmpty()) {
                // Armamos una lista de tareas en relación a la cantidad de cpus.
                for (int i = 0; i <= OperativeSystem.NumberOfCores; i++) {
                    if (i < OperativeSystem.getInstance().Memory.getReadyProcess().size()) {
                        IProcess process = OperativeSystem.getInstance().Memory.getReadyProcess().get(i);
                        tasks.add(process);
                    }                
                }
 
                // Si el proceso no esta siendo ejecutado, ejecutamos.
                for (int i = 0; i < OperativeSystem.NumberOfCores; i++) {
                    try {
                        if (i < tasks.size()) {
                            IProcess process = tasks.get(i);
                            CPU cpu = cores[i];
                            cpu.setProcessToExecute(process);
                            ExecuteProcess execute = new ExecuteProcess(cpu);
                            execute.start();
                        } else { 
                            break; 
                        }
                    } catch (Exception e) {}
                }
                Thread.sleep(timeout + 1000);
                tasks.clear();    
            }
            OperativeSystem.running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Bloquea el proceso pasado como parámetro. Este sería bloqueado por una esperta de E/S
    public synchronized void blockProcess(IProcess process) {
        try {
            process.getProcessPCB().changeProcessState(ProcessControlBlock.State.BLOCKED);
            process.restartTimeBetweenIO();
            process.setHasCPU(false);
            ProcessManager.addBlockedProcessList(process);
            if (!OperativeSystem.getInstance().iocontroller.isAlive()) {
                OperativeSystem.getInstance().iocontroller = new IOController();
                OperativeSystem.getInstance().iocontroller.start();
            }
            Thread.sleep(500);
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    //Se desbloquea el proceso pasado como parámetro. Esto ocurre cuando la E/S que estaba ejecutando termina.
    public synchronized void unBlockProcess(IProcess process) {
        try {
            ProcessManager.removeBlockedProcessList(process);
            OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(process);
            Thread.sleep(500);
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    //Pasa los procesos de la lista de ejecución a la lista de listos, si el tiempo de ejecución es mayor al timeout, y resta este último al primero
    //En el caso de que el tiempo de ejecución sea menor al timeout, se finaliza el proceso
    public synchronized void timeOut(IProcess process) {
        try {
            process.getProcessPCB().changeProcessState(ProcessControlBlock.State.READY);
            //System.out.println(process.getProcessName() + " " + Float.toString(process.getTotalExecutionTime()));
            process.setHasCPU(false);
            OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(process);
            Thread.sleep(500);
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }
}
