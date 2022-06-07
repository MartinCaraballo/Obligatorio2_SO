package com.mycompany.obligatorio.Resources;
import com.mycompany.obligatorio.Process.*;
import java.util.*;


public class Memory
{
    //Representa la memoria con los procesos listos.
    private ArrayList<IProcess> readyProcess; 

    // Representa la capacidad de la memoria en MB.
    private float MemorySize;

    private float ActualMemorySize;

    public Memory(float size)
    {
        this.readyProcess = new ArrayList<>();
        this.MemorySize = size;
        this.ActualMemorySize = size;
    }

    public void addProcessToReadyProcessList(IProcess process) {
        this.readyProcess.add(process);
        this.decreaseActualMemorySize(process.getProcessSize());
    }

    // Retorna true si la memoria tiene espacio para cargar toda la lista de procesos creados, o falso si no lo tiene.
    public boolean memoryHasSpaceToLoadAll() {
        return (this.ActualMemorySize >= ProcessManager.getProcessCreatedListSize());
    }

    public void decreaseActualMemorySize(float value) {
        this.ActualMemorySize -= value;
    }

    public void increaseActualMemorySize(float value) {
        this.ActualMemorySize += value;
    }

    // Retorna la memoria libre de la memoria.
    public float spaceFree() {
        return this.ActualMemorySize;
    }
    
    public List<IProcess> getAllProcessInMemory() {
        List<IProcess> allProcessInMemory = new ArrayList<>();

        // Recorremos la lista de los procesos listos.
        for (IProcess process : this.readyProcess) {
            allProcessInMemory.add(process);
        }

        // Recorremos la lista de los procesos bloqueados.
        for (IProcess blockedProcess : ProcessManager.getBlockedProcessList()) {
            allProcessInMemory.add(blockedProcess);
        }
        return allProcessInMemory;
    }
    
    // Método para imprimir una tabla con lo que contiene la memoria.
    public String viewMemory() {
        StringBuilder message = new StringBuilder("Los procesos que actualmente se encuentran en memoria son:\n");
        int moreLargeID = 0;
        int moreLargeName = 0;
        int moreLargeSize = 0;
        int moreLargePath = 0;
        List<IProcess> allProcessInMemory = this.getAllProcessInMemory();

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
        }
        // Comenzamos a armar la tabla:
        String bottom = "-";
        String space = " ";
        int repeatCount = (moreLargeID + moreLargeName + moreLargeSize + moreLargePath) + 9;
        message.append(bottom.repeat(repeatCount) + "\n");
        message.append("|ID" + space.repeat((moreLargeID - 1)) + "|" + "Name" + space.repeat((moreLargeName - 3)) + "|Size" + space.repeat((moreLargeSize - 3)) + "|Path" + space.repeat((moreLargePath - 3)) + "|");

        for (IProcess iProcess : allProcessInMemory) {
            ProcessControlBlock iprocessPCB = iProcess.getProcessPCB();
            message.append("\n| " + iprocessPCB.getProcessID() + space.repeat((moreLargeID - iprocessPCB.getProcessID().length())) + "| " + iProcess.getProcessName() + space.repeat((moreLargeName - iProcess.getProcessName().length())) + "| " + iProcess.getProcessSize() + space.repeat((moreLargeSize - String.valueOf(iProcess.getProcessSize()).length())) + "| " + iprocessPCB.getProcessPath() + space.repeat((moreLargePath - iprocessPCB.getProcessPath().length())) + "|");
        }
        message.append("\n" + bottom.repeat(repeatCount));
        return message.toString();
    }
}
