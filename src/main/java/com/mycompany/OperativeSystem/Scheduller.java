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
            List<IProcess> tasks = new ArrayList<>();
            while (!OperativeSystem.getInstance().Memory.getReadyProcess().isEmpty()) {
                // Armamos una lista de tareas en relación a la cantidad de cpus.
                for (int i = 0; i <= CPU.getCores().length; i++) {
                    IProcess process = OperativeSystem.getInstance().Memory.getReadyProcess().get(i);
                    tasks.add(process);
                }
 
                // Si el proceso no esta siendo ejecutado, ejecutamos.
                for (int i = 0; i < cores.length; i++) {
                    IProcess process = tasks.get(i);
                    CPU cpu = cores[i];
                    cpu.setProcessToExecute(process);
                    ExecuteProcess execute = new ExecuteProcess(cpu);
                    execute.start();
                }
                Thread.sleep(3000);
                tasks.clear();
            }
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
            Thread.sleep(500);
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    //Se desbloquea el proceso pasado como parámetro. Esto ocurre cuando la E/S que estaba ejecutando termina.
    public synchronized void unBlockProcess(IProcess process) {
        try {
            ProcessManager.unblockProcess(process);
            process.getProcessPCB().changeProcessState(ProcessControlBlock.State.READY);
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
