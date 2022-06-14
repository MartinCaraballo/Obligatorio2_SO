/*6
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio.Resources;

import com.mycompany.OperativeSystem.OperativeSystem;
import com.mycompany.obligatorio.Process.*;
import java.util.*;

public class CPU {

    private Map<Integer, IProcess> Cores;
    private float timeout;

    //Lista de procesos en ejecución
    private static List<IProcess> executingProcessList = new ArrayList<>();

    public CPU(byte cores, float timeout) {
        this.Cores = new HashMap<Integer, IProcess>((int) cores);
        this.timeout = timeout;
    }

    public void Execute() {
        for (int i = 1; i < this.Cores.size(); i++) {
            this.Cores.put(i, null);
        }
        while (!OperativeSystem.getInstance().Memory.getAllProcessInMemory().isEmpty()) {
            for (Map.Entry<Integer, IProcess> entry : Cores.entrySet()) {
                Integer core = entry.getKey();
                IProcess process = entry.getValue();
                if (process == null) {
                    OperativeSystem.getInstance().scheduller.dispatch();
                    IProcess processExecuting = this.getExecutingProcessList().get(this.getExecutingProcessList().size());
                    this.Cores.put(core, processExecuting);
                }
            }
            /*
            for (Map.Entry<Integer, IProcess> entry : Cores.entrySet()) {
                Integer core = entry.getKey();
                IProcess process = entry.getValue();
                this.Cores.replace(core, null);
            }*/
        }
    }

    public List<IProcess> getExecutingProcessList() {
        return this.executingProcessList;
    }

}
