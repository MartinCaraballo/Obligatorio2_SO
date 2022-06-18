package com.mycompany.obligatorio.Process;

public interface IProcess extends Comparable<IProcess>
{
    public boolean hasCPU = false;

    public String getProcessName();

    public float getProcessSize();

    public ProcessControlBlock getProcessPCB();

    public float getTotalExecutionTime();

    public float getTimeBetweenIO();
    
    public float getActualTimeBetweenIO();
    
    public void decreaseActualTimeBetweenIO(float value);
    
    public void restartTimeBetweenIO();

    public float getTimeConsumedIO();

    public void setHasCPU(boolean b);
    
    public boolean getHasCPU();
    
    public void decreaseTotalExecutionTime(float time);
}
