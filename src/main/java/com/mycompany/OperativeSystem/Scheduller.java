/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;
import com.mycompany.obligatorio.Process.*;

public class Scheduller {
    
    private float timeout = (float) 0.01;

    //Despacha el primer proceso de la lista de listos en CPU
    public void dispatch() {
        IProcess process = OperativeSystem.getInstance().Memory.getReadyProcess().get(0);
        ProcessControlBlock processPCB = process.getProcessPCB();
        if (!process.hasCPU)
        {
            processPCB.changeProcessState(ProcessControlBlock.State.EXECUTING);
            OperativeSystem.getInstance().Memory.removeProcessFromReadyProcessList(process);
            process.setHasCPU(true);
            //this.CPU.Execute(process, this.CPU.);
            OperativeSystem.getInstance().CPU.getExecutingProcessList().add(process);
        }
    }

    //Bloquea el proceso pasado como parámetro. Este sería bloqueado por una esperta de E/S
    public void block(IProcess process) {
        ProcessControlBlock processPCB = process.getProcessPCB();
        for (IProcess executingProcess : OperativeSystem.getInstance().CPU.getExecutingProcessList()) {
            if (process.equals(executingProcess)){
                processPCB.changeProcessState(ProcessControlBlock.State.BLOCKED);
                process.setHasCPU(false);
                OperativeSystem.getInstance().CPU.getExecutingProcessList().remove(process);
                ProcessManager.addBlockedProcessList(process);
            }
        }
    }
    
    //Bloquea el proceso pasado como parámetro. Este es bloqueado por el usuario
    public void blockByUser(IProcess process) {
        ProcessControlBlock processPCB = process.getProcessPCB();
        for (IProcess executingProcess : OperativeSystem.getInstance().CPU.getExecutingProcessList()) {
            if (process.equals(executingProcess)){
                processPCB.changeProcessState(ProcessControlBlock.State.BLOCKEDBYUSER);
                process.setHasCPU(false);
                OperativeSystem.getInstance().CPU.getExecutingProcessList().remove(process);
                ProcessManager.addBlockedProcessList(process);
            }
        }
    }
    
    //Se desbloquea el proceso pasado como parámetro. Esto ocurre cuando la E/S por la que estaba esperando ocurre
    public void unBlock(IProcess process){
        ProcessControlBlock processPCB = process.getProcessPCB();
        for (IProcess blockedProcess : ProcessManager.getBlockedProcessList()){
            if (process.equals(blockedProcess)){
                processPCB.changeProcessState(ProcessControlBlock.State.READY);
                ProcessManager.removeBlockedProcessList(process);
                OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(process);                
            }
        }
    }

    //Pasa los procesos de la lista de ejecución a la lista de listos, si el tiempo de ejecución es mayor al timeout, y resta este último al primero
    //En el caso de que el tiempo de ejecución sea menor al timeout, se finaliza el proceso
    public void timeOut() {
        for (IProcess executingProcess : OperativeSystem.getInstance().CPU.getExecutingProcessList()){
            ProcessControlBlock processPCB = executingProcess.getProcessPCB();
            float processTime = executingProcess.getTotalExecutionTime();
            if (processTime > timeout){
                executingProcess.setTotalExecutionTime(timeout);
                processPCB.changeProcessState(ProcessControlBlock.State.READY);
                executingProcess.setHasCPU(false);
                OperativeSystem.getInstance().CPU.getExecutingProcessList().remove(executingProcess);
                OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(executingProcess);
            }
            else{
                this.end(executingProcess);
            }    
        }
    }

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
    }
}

