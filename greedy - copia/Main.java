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
            System.out.println("Piezas totales a producir: " + config.getPiezasTotales());
            System.out.println("Máquinas disponibles: " + config.getMaquinas());

            // Ejecutar el algoritmo de greedy
            ProcesadoresGreedy  procesador = new ProcesadoresGreedy(config);
            Solucion solucion = procesador.resolver();

            // Mostrar solución
            System.out.println("\n=== Resultado Greedy===");
            if (solucion == null) {
                 System.out.println("No se encontró ninguna solución posible.");
                   } else {
                   solucion.imprimir();
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
            System.out.println("\n Leído: '" + nombre + "' produce " + piezas + " piezas"); // DEBUG
        }

        br.close();
        return new ConfiguracionMaquinas(piezasTotales, maquinas);
    }
}
