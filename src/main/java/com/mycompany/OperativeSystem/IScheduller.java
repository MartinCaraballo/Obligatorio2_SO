package com.mycompany.OperativeSystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TomasUcu
 */
public interface IScheduller {
    // Listo a En ejecución.
    public void dispatch();
    
    // Listo a Suspendido Listo o Bloqueado a Suspendido Bloqueado.
    public void suspend();
    
    // En ejecución a Bloqueo (E/S).
    public void block();
    
    // En ejecución a Listo.
    public void timeOut();
    
    // En ejecución a Fin.
    public void end();
}
