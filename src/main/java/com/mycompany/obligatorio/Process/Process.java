package com.mycompany.obligatorio.Process;

public class Process implements IProcess
{

    // ID de un proceso.
    private String ProcessID;

    // Nombre de un proceso.
    private String ProcessName;

    // Ruta al archivo del proceso.
    private String Path;

    // Un booleano que indica si el proceso tiene CPU o no.
    public boolean hasCPU;

    // Enumeracion que indica los estados de un proceso, estos pueden ser LISTO, BLOQUEADO, SUSPENDIDO, EN EJECUCION o FINALIZADO.
    public enum State
    {
        CREADO, LISTO, BLOQUEADO, SUSPENDIDO, EJECUCION, FINALIZADO;
    }

    // Estado del proceso.
    private State ProcessState;

    // Prioridad de un proceso en el sistema.
    public byte priority;

    // Tamaño que ocupa el proceso en memoria.
    private int ProcessSize;

    // Tiempo total de ejecución de un proceso.
    private float TotalExecutionTime;
    
    // Tiempo entre entradas/salidas de un proceso.
    private float TimeBetweenIO;

    // Tiempo que lleva la entrada/salida.
    private float TimeConsumedIO;

    public Process(String processName, String processID, int size, String path, float executionTime, float timeBetweenIO, float timeConsumedIO)
    {
        this.ProcessName = processName;
        this.ProcessID  = processID;
        this.ProcessSize = size;
        this.Path = path;
        this.hasCPU = false;
        this.ProcessState = Process.State.CREADO;
        this.priority = 1;
        this.TotalExecutionTime = executionTime;
        this.TimeBetweenIO = timeBetweenIO;
        this.TimeConsumedIO = timeConsumedIO;
    }

    // Retorna el nombre de un proceso.
    public String GetProcessName() {
        return this.ProcessName;
    }

    // Retorna la id del proceso (ya que es privado).
    public String GetProcessID() {
        return this.ProcessID;
    }

    // Retorna el estado de un proceso.
    public State GetProcessState() {
        return this.ProcessState;
    }

    // Cambia el state de un proceso, dado el nuevo state como string.
    public void ChangeProcessState(String newState) {
        switch (newState) {
            case "CREADO": {
                this.ProcessState = Process.State.CREADO;
            }
            case "LISTO": {
                this.ProcessState = Process.State.LISTO;
            }
            case "BLOQUEADO": {
                this.ProcessState = Process.State.BLOQUEADO;
            }
            case "SUSPENDIDO": {
                this.ProcessState = Process.State.SUSPENDIDO;
            }
            case "EJECUCION": {
                this.ProcessState = Process.State.EJECUCION;
            }
            case "FINALIZADO": {
                this.ProcessState = Process.State.FINALIZADO;
            }
        }
    }

    // Cambia el state de un proceso, dado el nuevo state como objeto State.
    public void ChangeProcessState(State newState) {
        this.ProcessState = newState;
    }

    // Retorna el espacio que ocupa el proceso en memoria.
    public int GetProcessSize() {
        return this.ProcessSize;
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
}
