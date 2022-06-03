package com.mycompany.obligatorio.Process;
import java.util.*;

public class ProcessManager
{
    static List<IProcess> processList = new ArrayList<>();

    public void AddProcessCreatedToList(IProcess process) {
        ProcessManager.processList.add(process);
    }

    
}