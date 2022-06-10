package com.mycompany.obligatorio.Process;
import com.mycompany.OperativeSystem.OperativeSystem;
import java.util.*;

public class ProcessManager
{
    //Lista de procesos listos
    private static List<IProcess> processList = new ArrayList<>();

    //Lista de procesos bloqueados
    private static List<IProcess> blockedProcess = new ArrayList<>();
    
    // Devuelve la lista con todos los procesos en el sistema.
    public static List<IProcess> getProcessList() {
        return ProcessManager.processList;
    }
    public static IProcess getProcessById(int id) {
        String i = Integer.toString(id);
        ArrayList<IProcess> arr = OperativeSystem.getInstance().Memory.getAllProcessInMemory();
        IProcess res;
        for(IProcess x : arr) {
            if(x.getProcessPCB().getProcessID().equals(i)) {
                return x;
            }
        }
        return null;
    }

    // Devuelve la lista con todos los procesos bloqueados del sistema.
    public static List<IProcess> getBlockedProcessList() {
        return ProcessManager.blockedProcess;
    }
    
    // Agrega un proceso a la lista con todos los procesos bloqueados del sistema.
    public static void addBlockedProcessList(IProcess process) {
        ProcessManager.blockedProcess.add(process);
    }
    
    // Agrega un proceso a la lista con todos los procesos bloqueados del sistema.
    public static void removeBlockedProcessList(IProcess process) {
        ProcessManager.blockedProcess.remove(process);
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
        List<Integer> indexOfProcessToRemove = new ArrayList<>();
        float remaining = freeSpaceInMemory;
        
        while (remaining >= 0) {
            for (IProcess process : ProcessManager.processList) {
                if (process.getProcessSize() <= remaining) {
                    newReadyProcessList.add(process);
                    remaining -= process.getProcessSize();
                    int index = ProcessManager.processList.indexOf(process);
                    indexOfProcessToRemove.add(index);
                }
            }
            return newReadyProcessList;

            // Borro los elementos que cargo en memoria; dicho de otra forma, quedan los que no pude cargar.
            /* for (Integer index : indexOfProcessToRemove) {
                ProcessManager.processList.remove(index);
            } */
        }
        return newReadyProcessList;
    }

    public static IProcess createInstanceOfProcess(String path, String processName, float size, float executionTime, float timeBetweenIO, float timeConsumedIO) {
        IProcess process = new Process(path, processName, size, executionTime, timeBetweenIO, timeConsumedIO);
        ProcessManager.processList.add(process);
        return process;
    }

}