
import java.util.*;

class ProcesadoresBacktracking{

 Solucion solucion;

 int costo;

 ConfiguracionMaquinas maquinas;



 public ProcesadoresBacktracking(ConfiguracionMaquinas mm ){
    this.maquinas = mm;
    this.solucion = new Solucion();
 }



 public Solucion resolver(){

   Estado  estado = new Estado(maquinas.getPiezasTotales(), maquinas.getMaquinas());                                                
           resolverRec(estado);
   return solucion;
 }


    private void resolverRec(Estado estado) {

        if(estado.getPiezasRestantes() == 0) {
            if (solucion.getPiezasTotales() < estado.getPiezasTotales()) {
                solucion.setPiezasTotales(estado.getPiezasTotales());
                solucion.setMaquinas(estado.getMaquinas());// Actualizar la solución si encuentra una mejor
            }else{
              //sigo buscando una solucion posible 

              for (String maquina : estado.getMaquinas().keySet()) {
                  int piezas = estado.getMaquinas().get(maquina);
                  if (piezas > 0) {
                  
                      estado.agregarPieza(maquina);

                  //poda cuando encuentro una solucion posible
                        if (solucion.getPiezasTotales() < estado.getPiezasTotales()) {
                            return; // Poda: no es necesario seguir buscando
                        }
                        
                        resolverRec(estado);
                      estado.reducirPieza(maquina);


                  }
              }
            }

        }
    }
}