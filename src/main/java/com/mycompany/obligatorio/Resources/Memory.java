package com.mycompany.obligatorio.Resources;
import com.mycompany.obligatorio.Process.*;
import java.util.*;


public class Memory
{
    //Representa la memoria con los procesos listos.
    private ArrayList<IProcess> readyProcess; 

    // Representa la capacidad de la memoria en MB.
    private int MemorySize;
    
    public ArrayList<IProcess> getReadyProcess() {
        return this.readyProcess;
    }

    public int getMemroySize() {
        return this.MemorySize;
    }
    
    public Memory(int size)
    {
        this.readyProcess = new ArrayList<>();
        this.MemorySize = size;
    }

    public void AddProcessToReadyProcessList(IProcess process) {
        this.readyProcess.add(process);
    }

    // Retorna true si la memoria tiene espacio para cargar toda la lista de procesos creados, o falso si no lo tiene.
    public boolean MemoryHasSpace() {
        return (this.MemorySize >= ProcessManager.GetProcessCreatedListSize());
    }

    // Retorna la memoria libre de la memoria.
    public int SpaceFree() {
        return this.MemorySize;
    }

    // Método para imprimir una tabla con lo que contiene la memoria.
    public String ViewMemory() {
        StringBuilder message = new StringBuilder("Los procesos que actualmente se encuentran en memoria son:\n");
        int moreLargeID = 0;
        int moreLargeName = 0;
        int moreLargeSize = 0;
        int moreLargePath = 0;
        List<IProcess> allProcessInMemory = this.GetAllProcessInMemory();

        for (IProcess process : allProcessInMemory) {
            if (process.GetProcessID().length() > moreLargeID) {
                moreLargeID = process.GetProcessID().length() + 2;
            }

            if (process.GetProcessName().length() > moreLargeName) {
                moreLargeName = process.GetProcessName().length() + 2;
            }

            String processSize = String.valueOf(process.GetProcessSize());
            if (processSize.length() > moreLargeSize) {
                moreLargeSize = processSize.length() + 2;
            }

            if (process.GetPath().length() > moreLargePath) {
                moreLargePath = process.GetPath().length() + 2;
            }
        }
        // Comenzamos a armar la tabla:
        String bottom = "-";
        int repeatCount = (moreLargeID + moreLargeName + moreLargeSize + moreLargePath) + 5;
        message.append(bottom.repeat(repeatCount));
        for (IProcess iProcess : allProcessInMemory) {
            message.append("\n| " + iProcess.GetProcessID() + " | " + iProcess.GetProcessName() + " | " + iProcess.GetProcessSize() + " | " + iProcess.GetPath() + " |");
        }
        return message.toString();
    }

    // Método para obtener todos los procesos que se encuentran en memoria.
    public List<IProcess> GetAllProcessInMemory() {
        List<IProcess> allProcessInMemory = new ArrayList<>();
        
        // Añado todos los procesos listos a la lista con todos los procesos que estan en memoria.
        for (IProcess process : this.readyProcess) {
            allProcessInMemory.add (process);
        }
        return allProcessInMemory;
    }
}
