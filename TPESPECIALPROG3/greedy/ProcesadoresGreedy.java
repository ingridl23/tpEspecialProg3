
package TPESPECIALPROG3.greedy;
import java.util.ArrayList;
import java.util.List;


public class ProcesadoresGreedy {


    private ConfiguracionMaquinas config;

    public ProcesadoresGreedy(ConfiguracionMaquinas config) {
        this.config = config;
    }

    public Solucion2 resolver() {
        // Ordenamos máquinas por cantidad de piezas (de mayor a menor)
        List<String> maquinasOrdenadas = new ArrayList<>(config.getMaquinas().keySet());
     
        maquinasOrdenadas.sort((m1, m2) -> 
            Integer.compare(config.getMaquinas().get(m2), config.getMaquinas().get(m1))
        );

        int piezasRestantes = config.getPiezasTotales();
        List<String> maquinasSeleccionadas = new ArrayList<>();
        int piezasProducidas = 0;
        int estadosGenerados = 0;

        for (String maquina : maquinasOrdenadas) {
            int piezas = config.getMaquinas().get(maquina);

            while (piezas <= piezasRestantes) {
                maquinasSeleccionadas.add(maquina);
                piezasRestantes -= piezas;
                piezasProducidas += piezas;
                estadosGenerados++; // cada máquina elegida = 1 estado generado
            }

            if (piezasRestantes == 0) break;
        }

        Solucion2 solucion = new Solucion2();
        solucion.setMaquinasSeleccionadas(maquinasSeleccionadas);
        solucion.setPiezasProducidas(piezasProducidas);
        solucion.setEstadosGenerados(estadosGenerados);
        return solucion;
    }
}
