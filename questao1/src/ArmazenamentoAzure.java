import java.util.concurrent.atomic.AtomicInteger;

public class ArmazenamentoAzure implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.02;
    private static final AtomicInteger sequencia = new AtomicInteger();

    private String id;

    public ArmazenamentoAzure() {
        this.id = "blob://" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoPorGb() {
        return CUSTO_POR_GB;
    }
}
