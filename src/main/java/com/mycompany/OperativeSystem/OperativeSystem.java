package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.*;
import com.mycompany.obligatorio.Memory.*;
import com.mycompany.obligatorio.Process.*;

public class OperativeSystem
{

    public Memory memory;
    public CPU cpu;

    public OperativeSystem(int memorySize, byte numberOfCores)
    {
        this.memory = new Memory(memorySize);
        // this.cpu = new CPU(numberOfCores);
    }

    //Representa la carga de los procesos listos.
    public void Load()
    {
        // for (IProcess process :)
    }

    public void Timeout(IProcess process)
    {
    }
}
