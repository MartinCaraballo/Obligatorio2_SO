package com.mycompany.obligatorio.Process;
import com.mycompany.OperativeSystem.OperativeSystem;
import com.mycompany.obligatorio.Interface.VentanaPrincipal;
import java.util.*;

public class ProcessManager
{
    //Lista de procesos listos para cargar.
    private static List<IProcess> processList = new ArrayList<>();

    //Lista de procesos bloqueados
    private static List<IProcess> blockedProcess = new ArrayList<>();
    
    // Lista de procesos suspendidos
    private static List<IProcess> suspendedProcess = new ArrayList<>();
    
    // Devuelve la lista con todos los procesos en el sistema.
    public static List<IProcess> getProcessList() {
        return processList;
    }
    
    public static void addProcessToProcessList(IProcess process) {
        processList.add(process);
    }
    
    public static void emptyProcessList() {
        processList.clear();
    }
    
    public static IProcess getProcessById(String id) {
        ArrayList<IProcess> arr = OperativeSystem.getInstance().Memory.getAllProcessInMemory();
        for(IProcess x : arr) {
            if(x.getProcessPCB().getProcessID().equals(id)) {
                return x;
            }
        }
        return null;
    }
    
    public static IProcess getProcessSuspendedById(String id) {
        for (IProcess process : suspendedProcess) {
            if (process.getProcessPCB().getProcessID().equals(id)) {
                return process;
            }
        }
        return null;
    }

    // Devuelve la lista con todos los procesos bloqueados del sistema.
    public static List<IProcess> getBlockedProcessList() {
        return blockedProcess;
    }
    
    // Devuelve la lista con todos los procesos suspendidos del sistema.
    public static List<IProcess> getSuspendedProcessList() {
        return suspendedProcess;
    }
    
    // Agrega un proceso a la lista con todos los procesos bloqueados del sistema.
    public static void addBlockedProcessList(IProcess process) {
        blockedProcess.add(process);
    }
    
    // Elimina un proceso de la lista de bloqueados. (Desbloquea un proceso).
    public static void removeBlockedProcessList(IProcess process) {
        blockedProcess.remove(process);
        process.getProcessPCB().changeProcessState(ProcessControlBlock.State.READY);
    }
    
    public static void suspendProcess(IProcess process) {
        suspendedProcess.add(process);
        process.getProcessPCB().changeProcessState(ProcessControlBlock.State.SUSPENDED);
        OperativeSystem.getInstance().Memory.removeProcessFromMemory(process);
    }
    
    public static void reanudeProcess(IProcess process) {
        suspendedProcess.remove(process);
        process.getProcessPCB().changeProcessState(ProcessControlBlock.State.READY);
        OperativeSystem.getInstance().Memory.addProcessToReadyProcessList(process);
    }
    
    public static void finalizeProcess(IProcess process) {
        if (blockedProcess.contains(process)) {
            blockedProcess.remove(process);
            OperativeSystem.getInstance().Memory.removeProcessFromMemory(process);
        }
        if (processList.contains(process)) {
            processList.remove(process);
        }
        if (OperativeSystem.getInstance().Memory.getReadyProcess().contains(process)) {
            OperativeSystem.getInstance().Memory.removeProcessFromMemory(process);
        }
        if (suspendedProcess.contains(process)) {
            suspendedProcess.remove(process);
        }
    }

    // Método para calcular la memoria necesaria para cargar toda la lista de procesos creados en memoria.
    public static float getProcessCreatedListSize() {
        float listSize = 0;
        for (IProcess process : processList) {
            listSize += process.getProcessSize();
        }
        return listSize;
    }

    // Cuando no hay el espacio necesario para cargar toda la lista de procesos creados, 
    // se necesita cargar una parte de ellos, por lo tanto este método abarca ese problema.
    public static List<IProcess> getFragmentofProcessList(float freeSpaceInMemory) {
        List<IProcess> newReadyProcessList = new ArrayList<>();
        List<IProcess> processToRemove = new ArrayList<>();
        float remaining = freeSpaceInMemory;
        
        for (IProcess process : ProcessManager.processList) {
            if (process.getProcessSize() <= remaining) {
                newReadyProcessList.add(process);
                remaining -= process.getProcessSize();
                processToRemove.add(process);
            }
        }
        
        // Borro los elementos que cargo en memoria; dicho de otra forma, quedan los que no pude cargar.
        for (IProcess process : processToRemove) {
                processList.remove(process);
            }           
        return newReadyProcessList;
    }

    public static IProcess createInstanceOfProcess(String path, String processName, float size, float executionTime, float timeBetweenIO, float timeConsumedIO) {
        IProcess process = new Process(path, processName, size, executionTime, timeBetweenIO, timeConsumedIO);
        processList.add(process);
        return process;
    }

}