import java.util.concurrent.atomic.AtomicInteger;

public class MaquinaVirtualAws implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.10;
    private static final AtomicInteger sequencia = new AtomicInteger();

    private String id;

    public MaquinaVirtualAws() {
        this.id = "i-" + sequencia.incrementAndGet();
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
