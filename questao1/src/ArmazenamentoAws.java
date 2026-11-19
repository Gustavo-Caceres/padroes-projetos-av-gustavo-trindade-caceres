import java.util.concurrent.atomic.AtomicInteger;

public class ArmazenamentoAws implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.023;
    private static final AtomicInteger sequencia = new AtomicInteger();

    private String id;

    public ArmazenamentoAws() {
        this.id = "s3://" + sequencia.incrementAndGet();
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
