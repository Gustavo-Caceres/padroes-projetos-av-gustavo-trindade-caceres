import java.util.concurrent.atomic.AtomicInteger;

public class MaquinaVirtualAzure implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.12;
    private static final AtomicInteger sequencia = new AtomicInteger();

    private String id;

    public MaquinaVirtualAzure() {
        this.id = "vm-" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoPorHora() {
        return CUSTO_POR_HORA;
    }
}
