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
    private boolean hasCPU;

    // Tamaño que ocupa el proceso en memoria.
    private float ProcessSize;

    // Tiempo total de ejecución de un proceso.
    private float TotalExecutionTime;
    
    // Tiempo entre entradas/salidas de un proceso.
    private float TimeBetweenIO;
    
    private float ActualTimeBetweenI0;

    // Tiempo que lleva la entrada/salida.
    private float TimeConsumedIO;
    
    //Tiempo transcurrido en bloqueo
    private float TimeBlocked;

    
    public Process(String path, String processName, float size, float executionTime, float timeBetweenIO, float timeConsumedIO)
    {
        this.ProcessName = processName;
        this.ProcessSize = size;
        this.hasCPU = false;
        this.TotalExecutionTime = executionTime;
        this.TimeBetweenIO = timeBetweenIO;
        this.ActualTimeBetweenI0 = timeBetweenIO;
        this.TimeConsumedIO = timeConsumedIO;
        this.PCB = new ProcessControlBlock(path);
        this.TimeBlocked = 0;
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
    
    //Modifica la variable TotalExecutionTime 
    public void decreaseTotalExecutionTime(float time){
        this.TotalExecutionTime -= time;
    }

    // Retorna el tiempo en el que el proceso hace una entrada / salida.
    public float getTimeBetweenIO() {
        return this.TimeBetweenIO;
    }
    
    public float getActualTimeBetweenIO() {
        return this.ActualTimeBetweenI0;
    }
    
    public void decreaseActualTimeBetweenIO(float value) {
        this.ActualTimeBetweenI0 -= value;
    }
    
    public void restartTimeBetweenIO() {
        this.ActualTimeBetweenI0 = TimeBetweenIO;
    }

    // Retorna el tiempo que consume la entrada / salida.
    public float getTimeConsumedIO() {
        return this.TimeConsumedIO;
    }
    
    // Retorna el tiempo bloqueado
    public float getTimeBlocked() {
        return this.TimeBlocked;
    }
    
    public void setTimeBlocked(float time) {
        this.TimeBlocked = time;
    }

    public boolean askForResource(Resource resource) {
        if (resource.getAvailability()) {
            this.Resources.add(resource);
            return true;
        }
        return false;
    }
    
    //Modifica la variable hasCPU
    public void setHasCPU(boolean bool){
        this.hasCPU = bool;
    }
    
    public boolean getHasCPU() {
        return this.hasCPU;
    }
}
