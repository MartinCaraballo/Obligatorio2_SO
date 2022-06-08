package com.mycompany.obligatorio.Process;

public interface IProcess
{
    public boolean hasCPU = false;

    public String getProcessName();

    public float getProcessSize();

    public ProcessControlBlock getProcessPCB();

    public float getTotalExecutionTime();

    public float getTimeBetweenIO();

    public float getTimeConsumedIO();

    public void setHasCPU(boolean b);
    
    public void setTotalExecutionTime(float time);
}
