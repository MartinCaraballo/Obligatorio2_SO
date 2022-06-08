/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio;

import java.lang.management.MemoryUsage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.obligatorio.Process.ProcessManager;
import com.mycompany.obligatorio.Resources.Memory;

/**
 *
 * @author juan-
 */
public class Stats {

    public float collectCPUUsage()
    // Porcentaje de CPU utilizada
    {
        return();
    }

    public float collectRAMUsage(Memory memory)
    // Porcentaje de RAM utilizada
    {
        return (memory.memoryUsage());
    }

    public List collectProcessList()
    // Cantidad de procesos
    {
        return (ProcessManager.getProcessList());
    }

    // Number of process
    // memorySize
    // process.size
}
