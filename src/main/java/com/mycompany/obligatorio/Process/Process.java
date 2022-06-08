package com.mycompany.obligatorio.Process;
import com.mycompany.obligatorio.Resources.*;
import java.util.*;

public class Process implements IProcess
{
    // Nombre de un proceso.
    private String ProcessName;

    private ProcessControlBlock PCB;

    private List<Resource> Resources = new ArrayList<>();

    // Un booleano que indica si el proceso tiene CPU o no.
    public boolean hasCPU;

    // Tamaño que ocupa el proceso en memoria.
    private float ProcessSize;

    // Tiempo total de ejecución de un proceso.
    private float TotalExecutionTime;
    
    // Tiempo entre entradas/salidas de un proceso.
    private float TimeBetweenIO;

    // Tiempo que lleva la entrada/salida.
    private float TimeConsumedIO;

    
    public Process(String path, String processName, float size, float executionTime, float timeBetweenIO, float timeConsumedIO)
    {
        this.ProcessName = processName;
        this.ProcessSize = size;
        this.hasCPU = false;
        this.TotalExecutionTime = executionTime;
        this.TimeBetweenIO = timeBetweenIO;
        this.TimeConsumedIO = timeConsumedIO;
        this.PCB = new ProcessControlBlock(path);
    }

    // Retorna el nombre de un proceso.
    public String getProcessName() {
        return this.ProcessName;
    }

    // Retorna el espacio que ocupa el proceso en memoria.
    public float getProcessSize() {
        return this.ProcessSize;
    }

    public ProcessControlBlock getProcessPCB() {
        return this.PCB;
    }
    
    // Retorna el tiempo total de ejecución de un proceso.
    public float getTotalExecutionTime() {
        return this.TotalExecutionTime;
    }

    // Retorna el tiempo en el que el proceso hace una entrada / salida.
    public float getTimeBetweenIO() {
        return this.TimeBetweenIO;
    }

    // Retorna el tiempo que consume la entrada / salida.
    public float getTimeConsumedIO() {
        return this.TimeConsumedIO;
    }

    public boolean askForResource(Resource resource) {
        if (resource.getAvailability()) {
            this.Resources.add(resource);
            return true;
        }
        return false;
    }
    
    public void setHasCPU(boolean bool){
        this.hasCPU = bool;
    }
}
