
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Main{
    
    public static void main(String[] args) {


      String rutaArchivo = "configuracion.txt";
        try {
            ConfiguracionMaquinas config = cargarConfiguracion(rutaArchivo);
            System.out.println("Piezas totales: " + config.getPiezasTotales());
            System.out.println("Máquinas y piezas producidas: " + config.getMaquinas());
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
            String[] partes = linea.split(",");
            maquinas.put(partes[0], Integer.parseInt(partes[1]));
        }

        br.close();
        return new ConfiguracionMaquinas(piezasTotales, maquinas);
    }
}