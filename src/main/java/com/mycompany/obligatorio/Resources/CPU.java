/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio.Resources;

import com.mycompany.OperativeSystem.OperativeSystem;
import com.mycompany.obligatorio.Process.*;
import java.util.*;

public class CPU {

    private static CPU[] Cores;

    private float Timeout;
    
    private String Name;
    
    private IProcess processExecuting;
    
    public boolean isCPUExecuting;

    //Lista de procesos en ejecución
    private static List<IProcess> executingProcessList = new ArrayList<>();

    private CPU(String name, float timeout) {
        this.Name = name;
        this.Timeout = timeout;
        this.isCPUExecuting = false;
        this.processExecuting = null;
    }

    public void Execute(IProcess process) {
        try {
            process.getProcessPCB().changeProcessState(ProcessControlBlock.State.EXECUTING);
            Thread.sleep(250);
            OperativeSystem.getInstance().Memory.removeProcessFromReadyProcessList(process);
            this.isCPUExecuting = true;
            this.processExecuting = process;
            executingProcessList.add(process);
            process.setHasCPU(true);
            Thread.sleep(1000);

            if (process.getTotalExecutionTime() <= this.Timeout) {
                process.getProcessPCB().changeProcessState(ProcessControlBlock.State.FINALIZED);
                executingProcessList.remove(process);
                OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(process);
                Thread.sleep(500);
                ProcessManager.finalizeProcess(process);
                this.isCPUExecuting = false;
                this.processExecuting = null;
                //Thread.sleep(1000);
            } 
            else if (process.getTotalExecutionTime() > this.Timeout) {
                executingProcessList.remove(process);
                process.setTotalExecutionTime(this.Timeout);
                this.isCPUExecuting = false;
                this.processExecuting = null;
                OperativeSystem.getInstance().scheduller.timeOut(process);
            }     
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public static boolean isCPUFree(CPU cpu) {
        if (cpu.isCPUExecuting){
            return false;
        }
        return true;
    }
    
    public void setProcessExecuting(IProcess process) {
        if (process.getHasCPU()) {
            this.processExecuting = process;
        }
    }
    
    public IProcess getProcessExecuting() {
        return this.processExecuting;
    }
    
    public static CPU[] getCores() {
        return Cores;
    }
    
    public String getCPUName() {
        return this.Name;
    }
}