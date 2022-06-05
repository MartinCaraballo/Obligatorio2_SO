package com.mycompany.obligatorio.Process;

public interface IProcess
{
    public boolean hasCPU = false;

    enum State {}

    public String GetProcessID();

    public Process.State GetProcessState();

    public void ChangeProcessState(String newState);

    public void ChangeProcessState(Process.State newState);

    public int GetProcessSize();

    public String GetPath();

    public float GetTotalExecutionTime();

    public float GetTimeBetweenIO();

    public float GetTimeConsumedIO();
}
