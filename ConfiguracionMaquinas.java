
import java.util.Map;

public class ConfiguracionMaquinas {

    private int piezasTotales;
    private Map<String, Integer> maquinas;

    public ConfiguracionMaquinas(int piezasTotales, Map<String, Integer> maquinas) {
        this.piezasTotales = piezasTotales;
        this.maquinas = maquinas;
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    public Map<String, Integer> getMaquinas() {
        return maquinas;
    }

}
