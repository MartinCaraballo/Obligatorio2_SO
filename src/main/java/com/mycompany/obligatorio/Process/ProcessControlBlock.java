package com.mycompany.obligatorio.Process;
import java.util.*;

public class ProcessControlBlock
{
    // Variable estática para generar el ID de un proceso.
    public static int staticProcessID = 1;

    // ID de un proceso.
    private String ProcessID;

    // Ruta al archivo del proceso.
    private String Path;

    // Enumeracion que indica los estados de un proceso, estos pueden ser LISTO, BLOQUEADO, SUSPENDIDO, EN EJECUCION o FINALIZADO.
    public enum State
    {
        CREADO, LISTO, BLOQUEADO, SUSPENDIDO, EJECUCION, FINALIZADO;
    }

    // Estado del proceso.
    private State ProcessState;

    // Prioridad de un proceso en el sistema.
    private byte Priority;

    public ProcessControlBlock(String path)
    {
        this.ProcessID = Integer.toString(staticProcessID);
        this.Path = path;
        this.ProcessState = ProcessControlBlock.State.CREADO;
        this.Priority = 1;

        ProcessControlBlock.staticProcessID += 1;
    }
    
    // Cambia el state de un proceso, dado el nuevo state como objeto State.
    public void ChangeProcessState(State newState) {
        this.ProcessState = newState;
    }

    public State GetProcessState() {
        return this.ProcessState;
    }

    public String GetProcessPath() {
        return this.Path;
    }

    public String GetProcessID() {
        return this.ProcessID;
    }

    public void IncreaseProcessPriority() {
        this.Priority += 1;
    }

    public byte GetProcessPriority() {
        return this.Priority;
    }
    
}
