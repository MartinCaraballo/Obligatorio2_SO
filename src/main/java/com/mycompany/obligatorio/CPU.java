/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio;

import com.mycompany.obligatorio.Process.*;

public class CPU 
{
    private byte Cores;


    private CPU(byte cores) 
    {
        this.Cores = cores;
    }

    public boolean Execute(IProcess processToExecute, byte coresToUse)
    {
        return true;
    }
    
}
