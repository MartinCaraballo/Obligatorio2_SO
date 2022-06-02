/* package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Memory.*;
import com.mycompany.obligatorio.Process.*;

public class OperativeSystem
{
    //Representa la carga de los procesos listos.
    public void Load()
    {
        if (IMemory.readyProcess.isEmpty())
        {
            //Agrega un proceso creado a la lista de listos.
            for (IProcess x : IProcess.processList) 
            {
                x.processState = Process.State.LISTO;
                IMemory.readyProcess.add(x);
            }
        }
    }

    public void Timeout(IProcess process)
    {
        if (!IMemory.readyProcess.isEmpty())
        {
            //Saca un 
        }
    }
} */
