/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio;
import java.util.*;
import com.mycompany.obligatorio.Process.*;
/**
 *
 * @author juan-
 */
public class ProcessControlBlock {
    
    // Lista de procesos suspendidos 
    List<IProcess> suspendedProcess = new ArrayList<>();
    
    // Lista de procesos bloquados
    List<IProcess> blockedProcess = new ArrayList<>();
    
    // Lista de procesos listos
    List<IProcess> processList = new ArrayList<>();
}
