/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Resources.Memory;
import com.mycompany.obligatorio.Process.*;
import java.util.*;
/**
 *
 * @author TomasUcu
 */
public class Scheduller implements IScheduller {

    private ArrayList<IProcess> readyProcessList = new ArrayList<>();

    @Override
    public void dispatch(Memory memory) {
        
        this.readyProcessList = memory.getReadyProcess();
        IProcess process = this.readyProcessList.get(0);
        ProcessControlBlock processPCB = process.getProcessPCB();
        if (!process.hasCPU)
        {
            processPCB.changeProcessState(ProcessControlBlock.State.EJECUCION);
            memory.removeProcessFromReadyProcessList(process);
            //this.CPU.Execute(process, this.CPU.);
        }
    }

    @Override
    public void suspend() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void block() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void timeOut() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void end() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
