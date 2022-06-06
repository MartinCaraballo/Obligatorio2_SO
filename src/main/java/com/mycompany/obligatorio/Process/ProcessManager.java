package com.mycompany.obligatorio.Process;
import java.util.*;

public class ProcessManager
{
    private static List<IProcess> processList = new ArrayList<>();

    public static void AddProcessCreatedToList(IProcess process) {
        ProcessManager.processList.add(process);
    }
    
    public static List<IProcess> GetProcessList() {
        return ProcessManager.processList;
    }
    
    // Método para calcular la memoria necesaria para cargar toda la lista de procesos creados en memoria.
    public static int GetProcessCreatedListSize() {
        int listSize = 0;
        for (IProcess process : processList) {
            listSize += process.GetProcessSize();
        }
        return listSize;
    }

    // Cuando no hay el espacio necesario para cargar toda la lista de procesos creados, 
    // se necesita cargar una parte de ellos, por lo tanto este método abarca ese problema. NO ESTA FUNCIONANDO, SOLUCIONAR.
    public static List<IProcess> GetFragmentofProcessList(int freeSpaceInMemory) {
        List<IProcess> newList = new ArrayList<>();
        List<Integer> indexOfProcessToRemove = new ArrayList<>();
        int newListSizeCount = 0;
        
        while (newListSizeCount < freeSpaceInMemory) {
            for (IProcess iProcess : ProcessManager.processList) {
                newList.add(iProcess);
                newListSizeCount += iProcess.GetProcessSize();
                int index = ProcessManager.processList.indexOf(iProcess);
                indexOfProcessToRemove.add(index);
            }

            // Borro los elementos que cargo en memoria; dicho de otra forma, quedan los que no pude cargar.
            /* for (Integer integer : indexOfProcessToRemove) {
                ProcessManager.processList.remove(integer);
            } */
        }
        return newList;
    }
}