package TPESPECIALPROG3.Backtracking;


import java.util.ArrayList;
import java.util.HashMap;



public class ProcesadoresBacktracking{

   private Solucion solucion;
   private int piezastotales;

   private ConfiguracionMaquinas maquinas;
  private int estadosGenerados;


 public ProcesadoresBacktracking(ConfiguracionMaquinas mm ){
    this.maquinas = mm;
    this.solucion = new Solucion();
    this.piezastotales = mm.getPiezasTotales();
 }


  /*
 * Estrategia de resolución :
 *
 * - Se construye un árbol de exploración donde cada nodo representa un estado del sistema,
 *   es decir, una combinación de máquinas en funcionamiento que produce una cierta cantidad de piezas.
 *
 * - Desde el estado inicial (sin máquinas activadas y todas las piezas por producir),
 *   se exploran todos los caminos posibles agregando una máquina a la solución parcial,
 *   siempre que la suma total de piezas no exceda las piezas requeridas.
 *
 * - Los estados finales son aquellos donde la suma de piezas alcanza exactamente el total requerido.
 *   Un estado es solución si además utiliza la menor cantidad de máquinas posibles.
 *
 * - Se aplica una poda cuando:
 *     - La cantidad de piezas en la solución parcial excede el total a producir.
 *     - Ya existe una solución encontrada con menos máquinas que la solución parcial actual.
 *
 * - En cada paso se registra la secuencia de máquinas utilizadas, la cantidad de piezas,
 *   y se cuenta la cantidad total de estados generados para evaluar el costo de la solución.
 */
 

 public Solucion resolver(){

   Estado  estado = new Estado(maquinas.getPiezasTotales(), maquinas.getMaquinas());                                                
           resolverRec(estado);
           solucion.setEstadosGenerados(estadosGenerados);
           return solucion;
 }


    private void resolverRec(Estado estado) {

        estadosGenerados++;

       if (estado.getPiezasRestantes()==0) {
        if (solucion.getMaquinas().isEmpty() || estado.getSecuencia().size()< solucion.getMaquinas().size()) {
         
            solucion.setPiezasTotales(piezastotales);
            solucion.setMaquinas(new HashMap<>(estado.getMaquinas()));
            solucion.setSecuencia(new ArrayList<>(estado.getSecuencia()));
        }
        return;
    }


    if(!solucion.getMaquinas().isEmpty() && estado.getSecuencia().size() >= solucion.getMaquinas().size()){
                   //ya hay una solucion con menos maquinas
                   return;
    
    } 
              //sigo buscando una solucion posible 
        
        // Si hay piezas restantes, intentar procesar en cada máquina
        for (String maquina : estado.getMaquinas().keySet()) {
            int piezas = estado.getMaquinas().get(maquina);

            if (piezas <= estado.getPiezasRestantes()) {
                Estado estadocopia = estado.copiar();
                estadocopia.agregarPieza(maquina);
                resolverRec(estadocopia);
                estadocopia.reducirPieza(maquina);
            }
        }
    }
    }
