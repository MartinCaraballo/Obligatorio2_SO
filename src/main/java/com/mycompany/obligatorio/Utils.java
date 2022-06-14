package com.mycompany.obligatorio;
import java.util.Random;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.obligatorio.Interface.VentanaPrincipal;

public class Utils
{
    private static int countOfProcessCreated = ProcessControlBlock.getStaticID();

    public static void AddProcesses(int numberOfProcess) {
        // for para crear procesos.
        int count = countOfProcessCreated;
        for (int i = count; i < (numberOfProcess + count); i++) {
            String stringI = Integer.toString(ProcessControlBlock.getStaticID());
            Random random = new Random();
            // Genera un número aleatorio entre 0 y el valor de esta variable.
            float randomUpperBound = 15;
            ProcessManager.createInstanceOfProcess("/home/process" + stringI, "Process" + stringI, random.nextFloat(32), random.nextFloat(randomUpperBound), random.nextFloat(randomUpperBound), random.nextFloat(randomUpperBound));
        }
    } 
}

