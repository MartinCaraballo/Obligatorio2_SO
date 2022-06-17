package com.mycompany.obligatorio;

import java.util.Random;
import com.mycompany.obligatorio.Process.*;

public class Utils
{
    private static int countOfProcessCreated = ProcessControlBlock.getStaticID();

    public static void addProcesses(int numberOfProcess) {
        // for para crear procesos.
        int count = countOfProcessCreated;
        for (int i = count; i < (numberOfProcess + count); i++) {
            String stringI = Integer.toString(ProcessControlBlock.getStaticID());
            Random random = new Random();
            // Para el tamaño de un archivo, se generan números aleatorios entre 0 y 32 (32MB).
            // Para el tiempo total de ejecución de un proceso, se generan números aleatorios entre 0 y 2000 (2s/2000 ms).
            // Para el tiempo entre E/S de un proceso, se generan números aleatorios entre 0 y 2000 (2s/2000 ms).
            // Para el tiempo que dura una E/S de un proceso, se generan números aleatorios entre 0 y 10000 (10s/10000 ms).
            ProcessManager.createInstanceOfProcess("/home/process" + stringI, "Process" + stringI, random.nextFloat(32), random.nextFloat(2000), random.nextFloat(2000), random.nextFloat(10000));
        }
    }
}

