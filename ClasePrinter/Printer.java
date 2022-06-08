import com.mycompany.obligatorio.Stats;

// Printer se encarga de imprimir estadisticas y la lista de procesos

public class Printer {
    public void StatPrinter(Stats stats) {
        System.out.println(stats.collectRAMUsage());
        System.out.println(stats.collectCPUUsage());
        System.out.println(stats.collectProcessList());
    }
}
// Extends para heredar, implements para interfaces