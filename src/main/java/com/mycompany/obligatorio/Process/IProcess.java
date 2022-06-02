package com.mycompany.obligatorio.Process;
import java.util.*;

public interface IProcess {

    List<IProcess> processList = new ArrayList<>();

    public void AddProcessCreatedtoList(IProcess process);
}
