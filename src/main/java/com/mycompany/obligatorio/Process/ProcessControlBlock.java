package com.mycompany.obligatorio.Process;
import java.util.*;

public class ProcessControlBlock
{
    // Variable estática para generar el ID de un proceso.
    private static int staticProcessID = 1;

    // ID de un proceso.
    private String ProcessID;

    // Ruta al archivo del proceso.
    private String Path;

    // Enumeracion que indica los estados de un proceso, estos pueden ser LISTO, BLOQUEADO, SUSPENDIDO, EN EJECUCION o FINALIZADO.
    public enum State
    {
        CREATED, READY, BLOCKED, SUSPENDED, EXECUTING, FINALIZED;
    }

    // Estado del proceso.
    private State ProcessState;

    // Prioridad de un proceso en el sistema.
    private byte Priority;

    public ProcessControlBlock(String path)
    {
        this.ProcessID = Integer.toString(staticProcessID);
        this.Path = path;
        this.ProcessState = ProcessControlBlock.State.CREATED;
        this.Priority = 1;

        ProcessControlBlock.staticProcessID++;
    }
    
    // Cambia el state de un proceso, dado el nuevo state como objeto State.
    public void changeProcessState(State newState) {
        this.ProcessState = newState;
    }

    public State getProcessState() {
        return this.ProcessState;
    }

    public String getProcessPath() {
        return this.Path;
    }

    public String getProcessID() {
        return this.ProcessID;
    }

    public void increaseProcessPriority() {
        this.Priority += 1;
    }

    public void decreaseProcessPriority() {
        this.Priority -= 1;
    }
    
    public void changeProcessPriority(byte value) {
        this.Priority = value;
    }

    public byte getProcessPriority() {
        return this.Priority;
    }
    
    public static int getStaticID() {
        return ProcessControlBlock.staticProcessID;
    }
    
}
