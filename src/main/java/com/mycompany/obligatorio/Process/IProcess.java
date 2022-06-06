package com.mycompany.obligatorio.Process;

public interface IProcess
{
    public boolean hasCPU = false;

    public String GetProcessName();

    public float GetProcessSize();

    public float GetTotalExecutionTime();

    public float GetTimeBetweenIO();

    public float GetTimeConsumedIO();
}
