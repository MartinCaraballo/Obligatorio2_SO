package com.mycompany.obligatorio.Resources;
import com.mycompany.obligatorio.Process.*;
import java.util.*;


public class Memory
{
    //Representa la memoria con los procesos listos.
    public ArrayList<IProcess> readyProcess; 

    // Representa la capacidad de la memoria en MB.
    private int MemorySize;

    public Memory(int size)
    {
        this.readyProcess = new ArrayList<>();
        this.MemorySize = size;
    }

    // Retorna true si la memoria tiene espacio para cargar toda la lista de procesos creados, o falso si no lo tiene.
    public boolean MemoryHasSpace() {
        return (this.MemorySize >= ProcessManager.GetProcessCreatedListSize());
    }

    // Retorna la memoria libre de la memoria.
    public int SpaceFree() {
        return this.MemorySize;
    }
     
}
