/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio;

import com.mycompany.obligatorio.Process.*;
import java.util.*;

public class CPU 
{
    private byte Cores;
    
    //Lista de procesos en ejecución
    private static List<IProcess> executingProcessList = new ArrayList<>();

    private CPU(byte cores) 
    {
        this.Cores = cores;
    }

    public boolean Execute(IProcess processToExecute, byte coresToUse)
    {
        return true;
    }
    
    public List<IProcess> getExecutingProcessList(){
        return this.executingProcessList;
    }
    
}
