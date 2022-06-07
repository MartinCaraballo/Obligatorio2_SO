package com.mycompany.OperativeSystem;

import java.util.*;
import com.mycompany.obligatorio.*;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Process.Process;
import com.mycompany.obligatorio.Resources.*;

public class OperativeSystem
{
    
    int counter = 0;
    public static Memory Memory;
    public CPU CPU;

    public OperativeSystem(int memorySize, byte numberOfCores)
    {
        this.Memory = new Memory(memorySize);
        // this.CPU = new CPU(numberOfCores);
    }

    // Este método carga una lista de procesos en memoria.
    // Si la memoria tiene espacio, carga toda la lista de procesos creados, si no, carga un fragmento de ella.
    public boolean LoadProcess() {
        if (this.Memory.memoryHasSpaceToLoadAll() == true) {
           for (IProcess process : ProcessManager.getProcessList()) {
               this.Load(process);
           }
           return true; 
        }
        else if (this.Memory.memoryHasSpaceToLoadAll() == false) {
            ProcessManager.getFragmentofProcessList(this.Memory.spaceFree());
            return true;
        }
        return false;
    }
    
    //Representa la carga de los procesos creados.
    public void Load(IProcess process) {
        ProcessControlBlock processPCB = process.getProcessPCB();
        processPCB.changeProcessState(ProcessControlBlock.State.LISTO);
        this.Memory.addProcessToReadyProcessList(process);
    }
}
