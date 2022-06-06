public class Printer
// Printer se encarga de imprimir estadisticas y la lista de procesos
// Estadisticas: collectCPUusage, collectRAMusage, collectProcessList
{
    public void StatPrinter(Stats stats) extends stats
    {
        string CPUUsage = stats.collectCPUUsage;
        string RAMUsage= stats.collectRAMUsage;
        string ProcessList= stats.collectProcessList;
    }
}
// Extends para heredar, implements para interfaces