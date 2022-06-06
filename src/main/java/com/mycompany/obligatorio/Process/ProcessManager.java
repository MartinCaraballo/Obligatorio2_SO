package com.mycompany.obligatorio.Process;
import java.util.*;

public class ProcessManager
{
    private static List<IProcess> processList = new ArrayList<>();

    private static List<IProcess> suspendedProcess = new ArrayList<>();

    private static List<IProcess> blockedProcess = new ArrayList<>();
    
    // Devuelve la lista con todos los procesos en el sistema.
    public static List<IProcess> GetProcessList() {
        return ProcessManager.processList;
    }

    // Devuelve la lista con todos los procesos suspendidos del sistema.
    public static List<IProcess> GetSuspendedProcessList() {
        return ProcessManager.suspendedProcess;
    }

    // Devuelve la lista con todos los procesos bloqueados del sistema.
    public static List<IProcess> GetBlockedProcessList() {
        return ProcessManager.blockedProcess;
    }

    // Método para calcular la memoria necesaria para cargar toda la lista de procesos creados en memoria.
    public static float GetProcessCreatedListSize() {
        float listSize = 0;
        for (IProcess process : processList) {
            listSize += process.GetProcessSize();
        }
        return listSize;
    }

    // Cuando no hay el espacio necesario para cargar toda la lista de procesos creados, 
    // se necesita cargar una parte de ellos, por lo tanto este método abarca ese problema.
    public static List<IProcess> GetFragmentofProcessList(float freeSpaceInMemory) {
        List<IProcess> newReadyProcessList = new ArrayList<>();
        List<Integer> indexOfProcessToRemove = new ArrayList<>();
        float remaining = freeSpaceInMemory;
        
        while (remaining > 0) {
            for (IProcess process : ProcessManager.processList) {
                if (process.GetProcessSize() <= remaining) {
                    newReadyProcessList.add(process);
                    remaining -= process.GetProcessSize();
                    int index = ProcessManager.processList.indexOf(process);
                    indexOfProcessToRemove.add(index);
                }
                return newReadyProcessList;
            }

            // Borro los elementos que cargo en memoria; dicho de otra forma, quedan los que no pude cargar.
            for (Integer index : indexOfProcessToRemove) {
                ProcessManager.processList.remove(index);
            }
        }
        return newReadyProcessList;
    }

    public static IProcess CreateInstanceOfProcess(String path, String processName, float size, float executionTime, float timeBetweenIO, float timeConsumedIO) {
        IProcess process = new Process(path, processName, size, executionTime, timeBetweenIO, timeConsumedIO);
        ProcessManager.processList.add(process);
        return process;
    }

}