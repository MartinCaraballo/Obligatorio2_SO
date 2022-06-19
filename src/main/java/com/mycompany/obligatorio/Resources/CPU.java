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

    public synchronized void Execute() {
        try {
            IProcess process = this.processExecuting;
            
            if (OperativeSystem.getInstance().Memory.getReadyProcess().size() > 1) {
                if (process.getProcessPCB().getProcessPriority() > OperativeSystem.getInstance().Memory.getReadyProcess().get(1).getProcessPCB().getProcessPriority()) {
                    OperativeSystem.getInstance().Memory.incrmentPriorityWithoutSpecificProcess(process);
                }
            }
            
            process.getProcessPCB().changeProcessState(ProcessControlBlock.State.EXECUTING);
            Thread.sleep(500);
            OperativeSystem.getInstance().Memory.removeProcessFromReadyProcessList(process);
            this.isCPUExecuting = true;
            this.processExecuting = process;
            executingProcessList.add(process);
            process.setHasCPU(true);
            Thread.sleep((long) this.Timeout);

            if (process.getTotalExecutionTime() <= this.Timeout) {
                // OCURRE E/S.
                if (process.getActualTimeBetweenIO() <= process.getTotalExecutionTime()) {
                    executingProcessList.remove(process);
                    process.decreaseTotalExecutionTime(process.getActualTimeBetweenIO());
                    OperativeSystem.getInstance().scheduller.blockProcess(process);
                    this.isCPUExecuting = false;
                    this.processExecuting = null;

                // NO OCURRE ENTRADA SALIDA, Y EL TIEMPO TOTAL DE EJECUCIÓN COMO ES MENOR O IGUAL AL TIMEOUT EL PROCESO FINALIZA.
                } else {
                    process.getProcessPCB().changeProcessState(ProcessControlBlock.State.FINALIZED);
                    executingProcessList.remove(process);
                    OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(process);
                    ProcessManager.finalizeProcess(process);
                    this.isCPUExecuting = false;
                    this.processExecuting = null;
                }
            } // EL TIEMPO TOTAL DEL PROCESO ES MAYOR AL TIMEOUT, POR LO TANTO EL NUEVO TIEMPO TOTAL ES LA DIFERENCIA ENTRE ÉSTE Y EL TIMEOUT.
            else if (process.getTotalExecutionTime() > this.Timeout) {
                // A PESAR DE QUE EL PROCESO DADO SU TIEMPO DE EJECUCION TERMINARA EN TIMEOUT, PUEDE OCURRIR LA E/S.
                // OCURRE E/S.
                if (process.getActualTimeBetweenIO() <= process.getTotalExecutionTime()) {
                    executingProcessList.remove(process);
                    process.decreaseTotalExecutionTime(process.getActualTimeBetweenIO());
                    OperativeSystem.getInstance().scheduller.blockProcess(process);
                    this.isCPUExecuting = false;
                    this.processExecuting = null;

                } else {
                    executingProcessList.remove(process);
                    process.decreaseTotalExecutionTime(this.Timeout);
                    process.decreaseActualTimeBetweenIO(this.Timeout);
                    OperativeSystem.getInstance().scheduller.timeOut(process);
                    this.isCPUExecuting = false;
                    this.processExecuting = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<IProcess> getExecutingProcessList() {
        return executingProcessList;
    }

    public static void createInstanceOfCPU(int numberOfCPU, float timeout) {
        Cores = new CPU[numberOfCPU];
        for (int i = 0; i < numberOfCPU; i++) {
            Cores[i] = new CPU(("CPU" + i), timeout);
        }
    }

    public static CPU getFreeCPU() {
        for (CPU cpu : Cores) {
            if (!cpu.isCPUExecuting) {
                return cpu;
            }
        }
        return null;
    }

    public static boolean isCPUFree(CPU cpu) {
        if (cpu.isCPUExecuting) {
            return false;
        }
        return true;
    }

    public synchronized void setProcessToExecute(IProcess process) {
        if (!process.getHasCPU()) {
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
    
    public float getTimeout() {
        return this.Timeout;
    }
}

