package com.mycompany.obligatorio.Memory;
import com.mycompany.obligatorio.Process.*;
import java.util.*;


public class Memory
{
    //Representa la memoria con los procesos listos.
    ArrayList<IProcess> readyProcess; 
    private int MemorySize;

    public Memory(int size)
    {
        this.readyProcess = new ArrayList<>();
        this.MemorySize = size;
    }

    public boolean MemoryHasSpace(int processToCharge)
    {
        if (this.MemorySize <= processToCharge)
        {
            return true;
        }
        return false;
    }

    public int SpaceFree() {
        return this.MemorySize;
    }
     
}
