import java.util.ArrayList;
import java.util.List;


public class ProcesadoresGreedy {
    private ConfiguracionMaquinas config;
    private Solucion solucion;


    public ProcesadoresGreedy(ConfiguracionMaquinas config) {
        this.config = config;
          this.solucion = new Solucion();
    }
    /**
     * Estrategia de resolución Greedy :
     *
     * - Se ordenan las máquinas disponibles de forma descendente según la cantidad de piezas que pueden producir.
     *   Es decir, primero se intenta usar la máquina que más piezas produce.
     *
     * - Desde el estado inicial (sin piezas producidas), se recorre la lista de máquinas ordenadas:
     *      - Mientras la máquina actual no supere la cantidad de piezas restantes por producir,
     *        se la agrega a la solución parcial y se actualizan los contadores.
     *
     * - El algoritmo finaliza cuando se alcanza exactamente la cantidad de piezas requeridas,
     *   o cuando ya no hay ninguna máquina que pueda seguir sumando sin pasarse.
     *
     * - La heurística aplicada consiste en elegir siempre la máquina que produce más piezas,
     *   intentando minimizar la cantidad de puestas en funcionamiento (aunque no garantiza óptimo).
     *
     * - Se contabiliza un estado generado por cada vez que se elige una máquina.
     *
     * - La solución final incluye:
     *      - La lista de máquinas seleccionadas (en orden de uso).
     *      - La cantidad total de piezas producidas.
     *      - El número de estados generados.
     *
     *    Este algoritmo no explora todos los caminos posibles ni garantiza la solución óptima,
     *       pero permite obtener rápidamente una solución factible aplicando una decisión local óptima.
     */

    public Solucion resolver() {
        // Ordenamos máquinas por cantidad de piezas (de mayor a menor)
        List<String> maquinasOrdenadas = new ArrayList<>(config.getMaquinas().keySet());
        // Usamos una expresión lambda para ordenar las máquinas
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

         
        solucion.setMaquinasSeleccionadas(maquinasSeleccionadas);
        solucion.setPiezasProducidas(piezasProducidas);
        solucion.setEstadosGenerados(estadosGenerados);
        return solucion;
    }
}
