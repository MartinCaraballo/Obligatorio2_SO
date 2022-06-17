package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Resources.CPU;
import com.mycompany.obligatorio.Interface.VentanaPrincipal;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Resources.*;

public class OperativeSystem {

    private static OperativeSystem instance;
    public Memory Memory;
    public Scheduller scheduller;
    public IOController iocontroller;
    
    private OperativeSystem(int memorySize, byte numberOfCores, float timeout) {
        this.Memory = new Memory(memorySize);
        this.scheduller = new Scheduller();
        this.iocontroller = new IOController();
        CPU.createInstanceOfCPU(numberOfCores, timeout);
    }

    // Si hay una instancia la devuelve, si no crea una instancia de sistema operativo con una memoria y numeros de cores default. A modos de que el programa pueda funcionar.
    public static OperativeSystem getInstance() {         
        return instance;
    }

    // Si hay una instancia la devuelve, si no crea una con los parámetros indicados.
    public static OperativeSystem getInstance(int memorySize, byte numberOfCores, float timeout) {
        if (instance == null) {
            instance = new OperativeSystem(memorySize, numberOfCores, timeout);
        }
        return instance;
    }

    public static void resetSystem() {
        instance.Memory.eraseAllFromMemory();
        VentanaPrincipal.getInstance().DisplayProcess();
        VentanaPrincipal.getInstance().DisplayProgressBar(0);
        instance = null;
    }

    // Este método carga una lista de procesos en memoria.
    // Si la memoria tiene espacio, carga toda la lista de procesos creados, si no, carga un fragmento de ella.
    public boolean LoadProcess() {
        if (this.Memory.memoryHasSpaceToLoadAll()) {
            for (IProcess process : ProcessManager.getProcessList()) {
                this.Load(process);
            }
            ProcessManager.emptyProcessList();
            return true;
        } else if (!this.Memory.memoryHasSpaceToLoadAll()) {
            for (IProcess iprocess : ProcessManager.getFragmentofProcessList(this.Memory.spaceFree())) {
                this.Load(iprocess);
            }
            return true;
        }
        return false;
    }

    //Representa la carga de los procesos creados.
    public void Load(IProcess process) {
        if (process.getProcessSize() <= Memory.spaceFree()) {
            ProcessControlBlock processPCB = process.getProcessPCB();
            processPCB.changeProcessState(ProcessControlBlock.State.READY);
            this.Memory.addProcessToMemory(process);
        } else {
            ProcessManager.addProcessToProcessList(process);
        }
    }
    
    public void dispatch() {
        this.scheduller.start();
    }
}
