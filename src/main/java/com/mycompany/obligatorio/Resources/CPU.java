/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio.Resources;

import com.mycompany.OperativeSystem.OperativeSystem;
import com.mycompany.obligatorio.Interface.VentanaPrincipal;
import com.mycompany.obligatorio.Process.*;
import java.util.*;

public class CPU {

    private static CPU[] Cores;

    private float Timeout;
    
    private String Name;
    
    public boolean isCPUExecuting;

    //Lista de procesos en ejecución
    private static List<IProcess> executingProcessList = new ArrayList<>();

    private CPU(String name, float timeout) {
        this.Name = name;
        this.Timeout = timeout;
        this.isCPUExecuting = false;
    }

    public void Execute(IProcess process) throws InterruptedException {
        process.getProcessPCB().changeProcessState(ProcessControlBlock.State.EXECUTING);
        executingProcessList.add(process);
        process.setHasCPU(true);
        VentanaPrincipal.getInstance().DisplayProcess(OperativeSystem.getInstance().Memory.getAllProcessInMemory());
        if (process.getTotalExecutionTime() <= this.Timeout){
            Thread.sleep(4000);
            process.getProcessPCB().changeProcessState(ProcessControlBlock.State.FINALIZED);
            executingProcessList.remove(process);
            ProcessManager.finalizeProcess(process);
            VentanaPrincipal.getInstance().DisplayProcess(OperativeSystem.getInstance().Memory.getAllProcessInMemory());
        } 
        else if (process.getTotalExecutionTime() > this.Timeout){
            Thread.sleep(4000);
            executingProcessList.remove(process);
            OperativeSystem.getInstance().scheduller.timeOut(process);            
        }     
        VentanaPrincipal.getInstance().DisplayProcess(OperativeSystem.getInstance().Memory.getAllProcessInMemory());
    }

    public static List<IProcess> getExecutingProcessList() {
        return executingProcessList;
    }
    
    public static void createInstanceOfCPU(int numberOfCPU, float timeout){
        Cores = new CPU[numberOfCPU];
        for (int i = 0; i < numberOfCPU; i++) {
            Cores[i] = new CPU(("CPU"+i), timeout);
        }
    }
    
    public static CPU freeCPU() {
        for (CPU cpu : Cores) {
            if (!cpu.isCPUExecuting){
                return cpu;
            }
        }
        return null;
    }

}
