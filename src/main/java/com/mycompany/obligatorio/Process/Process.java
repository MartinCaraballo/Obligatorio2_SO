package com.mycompany.obligatorio.Process;

public class Process implements IProcess {

    // ID de un proceso.
    private String ProcessID;

    // Ruta al archivo del proceso.
    private String Path;

    // Un booleano que indica si el proceso tiene CPU o no.
    public boolean hasCPU;

    // Enumeracion que indica los estados de un proceso, estos pueden ser LISTO, BLOQUEADO, SUSPENDIDO, EN EJECUCION o FINALIZADO.
    enum State
    {
        CREADO, LISTO, BLOQUEADO, SUSPENDIDO, EJECUCION, FINALIZADO;
    }

    // Estado del proceso.
    public State processState;

    // Prioridad de un proceso en el sistema.
    public byte priority;

    // Tiempo total de ejecución de un proceso.
    private float TotalExecutionTime;
    
    // Tiempo entre entradas/salidas de un proceso.
    private float TimeBetweenIO;

    // Tiempo que lleva la entrada/salida.
    private float TimeConsumedIO;

    public Process(String processID, String path, float executionTime, float timeBetweenIO, float timeConsumedIO)
    {
        this.ProcessID  = processID;
        this.Path = path;
        this.hasCPU = false;
        this.processState = Process.State.CREADO;
        this.priority = 1;
        this.TotalExecutionTime = executionTime;
        this.TimeBetweenIO = timeBetweenIO;
        this.TimeConsumedIO = timeConsumedIO;
    }

    // Retorna la id del proceso (ya que es privado).
    public String GetProcessID() {
        return this.ProcessID;
    }
    
    // Retorna el path del proceso.
    public String GetPath() {
        return this.Path;
    }

    // Retorna el tiempo total de ejecución de un proceso.
    public float GetTotalExecutionTime() {
        return this.TotalExecutionTime;
    }

    // Retorna el tiempo en el que el proceso hace una entrada / salida.
    public float GetTimeBetweenIO() {
        return this.TimeBetweenIO;
    }

    // Retorna el tiempo que consume la entrada / salida.
    public float GetTimeConsumedIO() {
        return this.TimeConsumedIO;
    }

    public void AddProcessCreatedtoList(IProcess process) {
        IProcess.processList.add(process);
    }
}
