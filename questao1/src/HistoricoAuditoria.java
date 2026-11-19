import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistoricoAuditoria {
    private static HistoricoAuditoria instancia;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private List<String> registros = new ArrayList<>();

    private HistoricoAuditoria() {
    }

    public static synchronized HistoricoAuditoria getInstance() {
        if (instancia == null) {
            instancia = new HistoricoAuditoria();
        }
        return instancia;
    }

    public synchronized void registrar(String nomeAmbiente, String provedor, String resultado) {
        registros.add(LocalDateTime.now().format(FORMATO) + " | " + nomeAmbiente + " | " + provedor + " | " + resultado);
    }

    public synchronized List<String> getRegistros() {
        return List.copyOf(registros);
    }

    public void imprimir() {
        List<String> copia = getRegistros();
        System.out.println("===== HISTÓRICO DE AUDITORIA (" + copia.size() + " registros) =====");
        for (String registro : copia) {
            System.out.println(registro);
        }
    }
}
