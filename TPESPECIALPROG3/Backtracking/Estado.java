package TPESPECIALPROG3.Backtracking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Estado {

private int piezasRestantes;
private int piezasTotales;
private List<String> secuencia;
private Map<String, Integer> maquinas;
   

    public Estado(int piezasTotales, Map<String, Integer> maquinas) {
        this.piezasRestantes = piezasTotales;
        this.piezasTotales = 0;
        this.secuencia = new ArrayList<>();
        this.maquinas = new HashMap<>(maquinas);
    }


    public int getPiezasRestantes() {
        return piezasRestantes;
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

  
    public List<String> getSecuencia() {
        return secuencia;
    }


    public Map<String, Integer> getMaquinas() {
        return maquinas;
    }

    public void setPiezasRestantes(int piezasRestantes) {
        this.piezasRestantes = piezasRestantes;
    }


    public void agregarPieza(String maquina) {
       int cantidad = maquinas.get(maquina);
       piezasRestantes -= cantidad;
       piezasTotales += cantidad;
       secuencia.add(maquina);

    }


    public void reducirPieza(String maquina){
        int cantidad = maquinas.get(maquina);
        piezasRestantes += cantidad;
        piezasTotales -= cantidad;
        secuencia.remove(secuencia.size() - 1); // Elimina la última máquina agregada
    }

    // Estado.java
public Estado copiar() {
    Estado copia = new Estado(this.piezasRestantes, new HashMap<>(this.maquinas));
    copia.secuencia = new ArrayList<>(this.secuencia);
    return copia;
}


}