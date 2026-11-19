import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor extends Observer {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private List<String> registros = new ArrayList<>();

    @Override
    public void update(Subject subject) {
        Lote lote = (Lote) subject;
        Lance lance = lote.getUltimoLance();
        registros.add(String.format("%s | %s | %s | R$ %.2f", lance.getDataHora().format(FORMATO),
                lote.getNome(), lance.getLicitante().getNome(), lance.getValor()));
    }

    public void imprimir() {
        System.out.println("===== REGISTROS DO AUDITOR (" + registros.size() + " lances aceitos) =====");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
