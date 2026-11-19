import java.util.concurrent.atomic.AtomicInteger;

public class FilaAzure implements Fila {
    public static final double CUSTO_MENSAL = 0.50;
    private static final AtomicInteger sequencia = new AtomicInteger();

    private String id;

    public FilaAzure() {
        this.id = "sb-" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoMensal() {
        return CUSTO_MENSAL;
    }
}
