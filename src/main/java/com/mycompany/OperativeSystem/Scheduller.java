/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.CPU;
import com.mycompany.obligatorio.Resources.Memory;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Utils;
import java.util.*;
/**
 *
 * @author TomasUcu
 */
public class Scheduller extends OperativeSystem {

    public void dispatch() {
        IProcess process = Memory.getReadyProcess().get(0);
        ProcessControlBlock processPCB = process.getProcessPCB();
        if (!process.hasCPU)
        {
            processPCB.changeProcessState(ProcessControlBlock.State.EJECUCION);
            Memory.removeProcessFromReadyProcessList(process);
            process.setHasCPU(true);
            //this.CPU.Execute(process, this.CPU.);
            CPU.getExecutingProcessList().add(process);
        }
    }

    public void block(IProcess process) {
        ProcessControlBlock processPCB = process.getProcessPCB();
        for (IProcess executingProcess : CPU.getExecutingProcessList()) {
            if (process.equals(executingProcess)){
                processPCB.changeProcessState(ProcessControlBlock.State.BLOQUEADO);
                process.setHasCPU(false);
                CPU.getExecutingProcessList().remove(process);
                ProcessManager.addBlockedProcessList(process);
            }
        }
    }
    
    public void unBlock(IProcess process){
        ProcessControlBlock processPCB = process.getProcessPCB();
        for (IProcess blockedProcess : ProcessManager.getBlockedProcessList()){
            if (process.equals(blockedProcess)){
                processPCB.changeProcessState(ProcessControlBlock.State.LISTO);
                ProcessManager.removeBlockedProcessList(process);
                Memory.addProcessToReadyProcessList(process);                
            }
        }
    }

    public void timeOut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void end(IProcess process) {
        ProcessControlBlock processPCB = process.getProcessPCB();
        for (IProcess executingProcess : CPU.getExecutingProcessList()) {
            if (process.equals(executingProcess)){
                processPCB.changeProcessState(ProcessControlBlock.State.FINALIZADO);
                process.setHasCPU(false);
                CPU.getExecutingProcessList().remove(process);
            }
        }
    }
}
