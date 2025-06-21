import java.util.ArrayList;

import java.util.List;




class Solucion {

    private int piezasTotales;
  
    private List<String> secuencia;
    private int estadosGenerados;

    public Solucion (){
       this.piezasTotales = 0;
     
       this.secuencia = new ArrayList<>();
    }


 public List<String> getSecuencia() {
    return secuencia;
}

public void setSecuencia(List<String> secuencia) {
    this.secuencia = new ArrayList<>(secuencia); // Copia 
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

   

    public void imprimir(){
        System.out.println("Piezas producidas : " + piezasTotales);
        System.out.println("Puestas en funcionamiento: " + secuencia.size());

       System.out.println("Secuencia de optima: ");
        for (String maquina : secuencia) {
            System.out.print(maquina + "-> ");
        }

        System.out.println("Estados generados: " + estadosGenerados);
       
    }




}