/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio.Resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author TomasUcu
 */
public class Resource {
    private String name;
    private Map<String, String> specs = new HashMap<>();
    private boolean availability = false;
    private boolean priority = false;
    
    public Resource(String name) {
        this.name = name;
    }
    
    public Resource(String name, boolean availability, boolean priority) {
        this.name = name;
        this.availability = availability;
        this.priority = priority;
    }
    
    public void addSpec(String spec, String value) {
        this.specs.put(spec, value);
    }
    
    public Set<String> getNamesSpecs() {
        return this.specs.keySet();
    }

    public Set<Entry<String, String>> getNamesValuesSpecs() {
        return this.specs.entrySet();
    }    

    public String getName() {
        return this.name;
    }   
    
    public boolean getAvailability() {
        return this.availability;
    }
    
    public boolean getPriority() {
        return this.priority;
    }
    
    public boolean setAvailability(boolean a) {
        return this.availability = a;
    }
    
    public boolean setPriority(boolean p) {
        return this.priority = p;
    }
}
