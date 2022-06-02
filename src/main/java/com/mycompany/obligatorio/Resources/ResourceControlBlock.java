/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio.Resources;

import java.util.LinkedList;

/**
 *
 * @author TomasUcu
 */
public class ResourceControlBlock {
    private LinkedList resourceList = new LinkedList();
        
    public void addResource(Resource r) {
        resourceList.add(r);
    }

    public void deleteResource(Resource r) {
        resourceList.remove(r);
    }
    
    public String getResourceList() {
        StringBuffer cadena = new StringBuffer();
        resourceList.forEach( (c) -> cadena.append(c) );
        return cadena.toString();
    }
        
}
