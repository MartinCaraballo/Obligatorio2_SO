/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Interface.VentanaPrincipal;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Resources.CPU;

public class Scheduller extends Thread {

    private float timeout;

    private boolean firstTime = true;

    //Despacha el primer proceso de la lista de listos en CPU
    public void run() {
        try {
            while (!OperativeSystem.getInstance().Memory.getReadyProcess().isEmpty()) {
                IProcess process = OperativeSystem.getInstance().Memory.getReadyProcess().get(0);
                if (!process.getHasCPU()) {
                    CPU[] cpus = CPU.getCores();
                    cpus[0].Execute(process);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public void dispatch() {
        while (!OperativeSystem.getInstance().Memory.getReadyProcess().isEmpty()) {
            IProcess process = OperativeSystem.getInstance().Memory.getReadyProcess().get(0);
            if (!process.getHasCPU()) {
                OperativeSystem.getInstance().Memory.removeProcessFromReadyProcessList(process);
                for (CPU cpu : CPU.getCores()) {
                    if (cpu.isCPUFree(cpu)) {
                        cpu.Execute(process);
                    }
                }
            }
        }
    }*/

    //Bloquea el proceso pasado como parámetro. Este sería bloqueado por una esperta de E/S
    public void blockProcess(IProcess process) {
        process.getProcessPCB().changeProcessState(ProcessControlBlock.State.BLOCKED);
        process.setHasCPU(false);
        ProcessManager.addBlockedProcessList(process);
    }

    //Se desbloquea el proceso pasado como parámetro. Esto ocurre cuando la E/S por la que estaba esperando ocurre
    public void unBlockProcess(IProcess process) {
        for (IProcess blockedProcess : ProcessManager.getBlockedProcessList()) {
            if (blockedProcess.equals(process)) {
                ProcessManager.removeBlockedProcessList(process);
                process.getProcessPCB().changeProcessState(ProcessControlBlock.State.READY);
            }
        }
    }

    //Pasa los procesos de la lista de ejecución a la lista de listos, si el tiempo de ejecución es mayor al timeout, y resta este último al primero
    //En el caso de que el tiempo de ejecución sea menor al timeout, se finaliza el proceso
    public void timeOut(IProcess process) {
        process.getProcessPCB().changeProcessState(ProcessControlBlock.State.READY);
        process.setTotalExecutionTime(this.timeout);
        System.out.println(process.getProcessName() + " " + Float.toString(process.getTotalExecutionTime()));
        process.setHasCPU(false);
        OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(process);
    }
    
    /*
    //Finaliza el proceso pasado por parámetro
    public void end(IProcess process) {
        ProcessControlBlock processPCB = process.getProcessPCB();
        for (IProcess executingProcess : OperativeSystem.getInstance().CPU.getExecutingProcessList()) {
            if (process.equals(executingProcess)){
                processPCB.changeProcessState(ProcessControlBlock.State.FINALIZED);
                process.setHasCPU(false);
                OperativeSystem.getInstance().CPU.getExecutingProcessList().remove(process);
            }
        }
    }*/
}
