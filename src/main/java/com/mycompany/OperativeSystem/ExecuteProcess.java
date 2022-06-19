/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OperativeSystem;

import com.mycompany.obligatorio.Resources.CPU;


public class ExecuteProcess extends Thread {
    
    
    public CPU CPU;
    
    public ExecuteProcess(CPU cpu) {
        this.CPU = cpu;
    }
    
    public void run() {
        this.CPU.Execute();
    }
}
