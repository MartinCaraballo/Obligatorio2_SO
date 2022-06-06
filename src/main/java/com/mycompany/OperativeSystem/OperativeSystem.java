package com.mycompany.OperativeSystem;

import java.util.*;
import com.mycompany.obligatorio.*;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Process.Process;
import com.mycompany.obligatorio.Resources.*;

public class OperativeSystem
{
    
    int counter = 0;
    public Memory Memory;
    public CPU CPU;

    public OperativeSystem(int memorySize, byte numberOfCores)
    {
        this.Memory = new Memory(memorySize);
        // this.CPU = new CPU(numberOfCores);
    }

    // Este método carga una lista de procesos en memoria.
    // Si la memoria tiene espacio, carga toda la lista de procesos creados, si no, carga un fragmento de ella.
    public boolean LoadProcess() {
        if (this.Memory.MemoryHasSpace() == true) {
           this.Load(ProcessManager.GetProcessList());
           return true; 
        }
        else if (this.Memory.MemoryHasSpace() == false) {
            ProcessManager.GetFragmentofProcessList(this.Memory.SpaceFree());
            return true;
        }
        return false;
    }
    
    //Representa la carga de los procesos creados.
    public void Load(List<IProcess> processToCharge) {
        for (IProcess process : processToCharge)
        {
            process.ChangeProcessState("LISTO");
            this.Memory.AddProcessToReadyProcessList(process);
        }
    }

    /* public void Dispatch(List<IProcess> readyProcess)
    {
        for (this.counter = 0; this.counter < 1; this.counter++) 
        {
            for (IProcess process : readyProcess) 
            {
                process.ChangeProcessState("EJECUCION");
                this.Memory.RemoveProcessFromReadyProcessList(process);
                this.CPU.Execute(process, this.CPU.);
                this.counter += 1;
            }
        }
    }

    public void Timeout(IProcess process)
    {
        for (process.GetProcessState() = proc)
        {

        }
        
    } */
}
