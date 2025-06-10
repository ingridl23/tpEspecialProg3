package TPESPECIALPROG3.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Solucion {

    private int piezasTotales;
    private  Map<String, Integer> maquinas;
    private List<String> secuencia;
    private int estadosGenerados;

    public Solucion (){
       this.piezasTotales = 0;
       this.maquinas = new HashMap<>();
       this.secuencia = new ArrayList<>();
    }


 public List<String> getSecuencia() {
    return secuencia;
}

public void setSecuencia(List<String> secuencia) {
    this.secuencia = new ArrayList<>(secuencia); // Copia defensiva
}

public int getEstadosGenerados(){
    return this.estadosGenerados;
}


public void setEstadosGenerados(int ee){
    this.estadosGenerados =ee;
}

    public int getPiezasTotales() {
        return piezasTotales;
    }


    public void setPiezasTotales(int piezasTotales) {
        this.piezasTotales = piezasTotales;
    }

    public Map<String, Integer> getMaquinas() {
        return maquinas;
    }


    public void setMaquinas(Map<String, Integer> maquinas) {
        this.maquinas = maquinas;
    }



    public void imprimir(){
        System.out.println("Piezas producidas : " + piezasTotales);
        System.out.println("Puestas en funcionamiento: " + maquinas.size());

       System.out.println("Secuencia de optima: ");
        for (String maquina : secuencia) {
            System.out.print(maquina + "-> ");
        }

        System.out.println("Estados generados: " + estadosGenerados);
       
    }




}