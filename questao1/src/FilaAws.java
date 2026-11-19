import java.util.concurrent.atomic.AtomicInteger;

public class FilaAws implements Fila {
    public static final double CUSTO_MENSAL = 0.40;
    private static final AtomicInteger sequencia = new AtomicInteger();

    private String id;

    public FilaAws() {
        this.id = "sqs-" + sequencia.incrementAndGet();
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
