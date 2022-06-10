package com.mycompany.obligatorio;
import java.util.Random;
import com.mycompany.obligatorio.Process.*;
import com.mycompany.OperativeSystem.*;
import com.mycompany.obligatorio.Interface.VentanaPrincipal;
import java.util.ArrayList;

public class Utils
{
    private static byte numberOfCores = 1;
    public static OperativeSystem operativeSystem = new OperativeSystem(4096, numberOfCores);
    public static VentanaPrincipal ventana = new VentanaPrincipal();

    public static void AddProcesses(int numberOfProcess) {
        // for para crear procesos.
        for (int i = 0; i < numberOfProcess; i++) {
            String stringI = Integer.toString(i+1);
            Random random = new Random();
            // Genera un número aleatorio entre 0 y el valor de esta variable.
            float randomUpperBound = 15;
            IProcess process = ProcessManager.createInstanceOfProcess("/home/process" + stringI, "Process" + stringI, random.nextFloat(32), random.nextFloat(randomUpperBound), random.nextFloat(randomUpperBound), random.nextFloat(randomUpperBound));
        }
    } 
}
