package com.mycompany.obligatorio.Resources;
import com.mycompany.obligatorio.Process.*;
import java.util.*;


public class Memory
{
    //Representa la memoria con los procesos listos.
    private LinkedList<IProcess> readyProcess; 

    // Representa la capacidad de la memoria en MB.
    private float MemorySize;

    private float ActualMemorySize;

    public Memory(float size)
    {
        this.readyProcess = new LinkedList<>();
        this.MemorySize = size;
        this.ActualMemorySize = size;
    }

    public LinkedList<IProcess> getReadyProcess(){
        return this.readyProcess;
    }

    public synchronized void addProcessToReadyProcessList(IProcess process) {
        this.readyProcess.add(process);
    }
    
    public synchronized void removeProcessFromReadyProcessList(IProcess process) {
        this.readyProcess.remove(process);
    }
    
    public synchronized void addProcessToMemory(IProcess process) {
        this.readyProcess.add(process);
        this.decreaseActualMemorySize(process.getProcessSize());    
    }
    
    public synchronized void removeProcessFromMemory(IProcess process){
        this.readyProcess.remove(process);
        this.increaseActualMemorySize(process.getProcessSize());
    }

    // Retorna true si la memoria tiene espacio para cargar toda la lista de procesos creados, o falso si no lo tiene.
    public boolean memoryHasSpaceToLoadAll() {
        return (this.ActualMemorySize >= ProcessManager.getProcessCreatedListSize());
    }

    private void decreaseActualMemorySize(float value) {
        this.ActualMemorySize -= value;
    }

    private void increaseActualMemorySize(float value) {
        this.ActualMemorySize += value;
    }

    // Retorna la memoria libre de la memoria.
    public float spaceFree() {
        return this.ActualMemorySize;
    }

    public float memoryUsage() {
        float memoryUsage = 100 * (this.MemorySize - this.ActualMemorySize) / this.MemorySize;
        return memoryUsage; 
    }
    
    
    public void eraseAllFromMemory() {
        readyProcess.clear();
    }
    
    // M??todo para imprimir una tabla con lo que contiene la memoria.
    public String viewMemory() {
        StringBuilder message = new StringBuilder("Los procesos que actualmente se encuentran en memoria son:\n");
        int moreLargeID = 0;
        int moreLargeName = 0;
        int moreLargeSize = 0;
        int moreLargePath = 0;
        int moreLargeState = 0;
        List<IProcess> allProcessInMemory = this.getReadyProcess();

        // Obtenemos el largo que va a tener cada columna de la tabla.
        for (IProcess process : allProcessInMemory) {
            ProcessControlBlock processPCB = process.getProcessPCB();
            if (processPCB.getProcessID().length() > moreLargeID) {
                moreLargeID = processPCB.getProcessID().length() + 1;
            }

            if (process.getProcessName().length() > moreLargeName) {
                moreLargeName = process.getProcessName().length() + 1;
            }

            String processSize = String.valueOf(process.getProcessSize());
            if (processSize.length() > moreLargeSize) {
                moreLargeSize = processSize.length() + 1;
            }

            if (processPCB.getProcessPath().length() > moreLargePath) {
                moreLargePath = processPCB.getProcessPath().length() + 1;
            }

            if (processPCB.getProcessState().name().length() > moreLargeState) {
                moreLargeState = processPCB.getProcessState().name().length() + 1;
            }
        }
        // Comenzamos a armar la tabla:
        String bottom = "-";
        String space = " ";
        int repeatCount = (moreLargeID + moreLargeName + moreLargeSize + moreLargePath) + 9;
        message.append("Memory Usage: %" + this.memoryUsage() + "\n");
        message.append(bottom.repeat(repeatCount) + "\n");
        message.append("|ID" + space.repeat((moreLargeID - 1)) + "|" + "Name" + space.repeat((moreLargeName - 3)) + "|Size" + space.repeat((moreLargeSize - 3)) + "|State" + space.repeat((moreLargeState - 4)) +"|Path" + space.repeat((moreLargePath - 3)) + "|");

        for (IProcess iProcess : allProcessInMemory) {
            ProcessControlBlock iprocessPCB = iProcess.getProcessPCB();
            message.append("\n| " + iprocessPCB.getProcessID() + space.repeat((moreLargeID - iprocessPCB.getProcessID().length())) + "| " + iProcess.getProcessName() + space.repeat((moreLargeName - iProcess.getProcessName().length())) + "| " + iProcess.getProcessSize() + space.repeat((moreLargeSize - String.valueOf(iProcess.getProcessSize()).length())) + "| " + iprocessPCB.getProcessState().name() + space.repeat((moreLargeState - iprocessPCB.getProcessState().name().length())) + "| " + iprocessPCB.getProcessPath() + space.repeat((moreLargePath - iprocessPCB.getProcessPath().length())) + "|");
        }
        message.append("\n" + bottom.repeat(repeatCount));
        return message.toString();
    }
    
    public void incrmentPriorityWithoutSpecificProcess(IProcess process) {
        for(IProcess pr : this.readyProcess) {
            if(pr.getProcessPCB().getProcessPriority() != 99 && !process.equals(pr)) {
                pr.getProcessPCB().increaseProcessPriority();
            }
        }
    }
}
