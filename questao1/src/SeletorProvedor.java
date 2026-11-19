import java.util.HashMap;
import java.util.Map;

public class SeletorProvedor {
    private Map<String, FabricaNuvem> fabricas = new HashMap<>();

    public void registrarFabrica(String provedor, FabricaNuvem fabrica) {
        fabricas.put(provedor, fabrica);
    }

    public FabricaNuvem obterFabrica(String provedor) {
        FabricaNuvem fabrica = fabricas.get(provedor);
        if (fabrica == null) {
            throw new IllegalArgumentException("Provedor não suportado: " + provedor);
        }
        return fabrica;
    }
}
