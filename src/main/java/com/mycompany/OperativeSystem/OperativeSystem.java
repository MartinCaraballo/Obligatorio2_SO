package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Resources.CPU;
import java.util.*;
import com.mycompany.obligatorio.*;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Process.Process;
import com.mycompany.obligatorio.Resources.*;

public class OperativeSystem
{

    public Memory Memory;
    public CPU CPU;
    
    private static OperativeSystem instance;

    private OperativeSystem(int memorySize, byte numberOfCores)
    {
        this.Memory = new Memory(memorySize);
        // this.CPU = new CPU(numberOfCores);
    }
    
    // Si hay una instancia la devuelve, si no crea una instancia de sistema operativo con una memoria y numeros de cores default. A modos de que el programa pueda funcionar.
    public static OperativeSystem getInstance() {
        if (instance == null) {
            instance = new OperativeSystem(2048, (byte) 1);
        }
        return instance;
    }
    
    // Si hay una instancia la devuelve, si no crea una con los parámetros indicados.
    public static OperativeSystem getInstace(int memorySize, byte numberOfCores) {
        if (instance == null) {
            instance = new OperativeSystem(memorySize, numberOfCores);
        }
        return instance;
    }
    

    // Este método carga una lista de procesos en memoria.
    // Si la memoria tiene espacio, carga toda la lista de procesos creados, si no, carga un fragmento de ella.
    public boolean LoadProcess() {
        if (this.Memory.memoryHasSpaceToLoadAll()) {
           for (IProcess process : ProcessManager.getProcessList()) {
               this.Load(process);
           }
           return true; 
        }
        else if (!this.Memory.memoryHasSpaceToLoadAll()) {
            for (IProcess iprocess : ProcessManager.getFragmentofProcessList(this.Memory.spaceFree())) {
                this.Load(iprocess);
            }
            return true;
        }
        return false;
    }
    
    //Representa la carga de los procesos creados.
    public void Load(IProcess process) {
        ProcessControlBlock processPCB = process.getProcessPCB();
        processPCB.changeProcessState(ProcessControlBlock.State.READY);
        this.Memory.addProcessToReadyProcessList(process);
    }
}
