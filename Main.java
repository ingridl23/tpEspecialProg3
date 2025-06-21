
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


 class Main {

    public static void main(String[] args) {
        String rutaArchivo = "configuracion.txt"; 

        try {
            ConfiguracionMaquinas config = cargarConfiguracion(rutaArchivo);
            System.out.println("datos cargados");

            System.out.println("Piezas totales a producir: " + config.getPiezasTotales());
            System.out.println("Máquinas disponibles: " + config.getMaquinas());

            // Mostrar solución
            System.out.println("\n=== Resultado Backtracking ===");
            // Ejecutar el algoritmo de backtracking
            ProcesadoresBacktracking backtracking = new ProcesadoresBacktracking(config);
            Solucion solucionBT = backtracking.resolver();     

            if (solucionBT == null || solucionBT.getSecuencia().isEmpty()) {
                 System.out.println("No se encontró ninguna solución posible.");
                   } else {
                          solucionBT.imprimir();
                   }


            //mostrar solucion para greedy
            System.out.println("=== Resultado Greedy ===");       
             ProcesadoresGreedy greedy = new ProcesadoresGreedy(config);
             Solucion solucionGreedy = greedy.resolver();

             if (solucionGreedy == null || solucionGreedy.getSecuencia().isEmpty()) {
                 System.out.println("No se encontró ninguna solución posible con el algoritmo greedy.");
             } else {
                 solucionGreedy.imprimir();
             }



        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }



    public static ConfiguracionMaquinas cargarConfiguracion(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        int piezasTotales = Integer.parseInt(br.readLine().trim());
        Map<String, Integer> maquinas = new HashMap<>();

        String linea;
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.isEmpty()) continue; // Saltar líneas vacías

            String[] partes = linea.split(",");
            if (partes.length < 2) continue; // Saltar líneas mal formateadas

            String nombre = partes[0].trim();
            int piezas = Integer.parseInt(partes[1].trim());

            maquinas.put(nombre, piezas);
            System.out.println("Leído: '" + nombre + "' produce " + piezas + " piezas"); // DEBUG
        }

        br.close();
        return new ConfiguracionMaquinas(piezasTotales, maquinas);
    }
}
