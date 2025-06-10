package TPESPECIALPROG3.greedy;
import java.util.ArrayList;
import java.util.List;

public class Solucion2 {
    private List<String> maquinasSeleccionadas;
    private int piezasProducidas;
    private int estadosGenerados;

    public Solucion2() {
        this.maquinasSeleccionadas = new ArrayList<>();
        this.piezasProducidas = 0;
        this.estadosGenerados = 0;
    }

    public void setMaquinasSeleccionadas(List<String> maquinasSeleccionadas) {
        this.maquinasSeleccionadas = maquinasSeleccionadas;
    }

    public List<String> getMaquinasSeleccionadas() {
        return maquinasSeleccionadas;
    }

    public void setPiezasProducidas(int piezasProducidas) {
        this.piezasProducidas = piezasProducidas;
    }

    public int getPiezasProducidas() {
        return piezasProducidas;
    }

    public void setEstadosGenerados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public void imprimir() {
        System.out.println("=== Resultado Greedy ===");
        System.out.println("Piezas producidas : " + piezasProducidas);
        System.out.println("Puestas en funcionamiento: " + maquinasSeleccionadas.size());
        System.out.println("Secuencia óptima:");
        for (String maquina : maquinasSeleccionadas) {
            System.out.print(maquina + " -> ");
        }
        System.out.println("\nEstados generados: " + estadosGenerados);
    }
}
