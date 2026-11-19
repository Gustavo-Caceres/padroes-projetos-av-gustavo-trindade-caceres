import java.time.LocalDateTime;

public class Lance {
    private Licitante licitante;
    private double valor;
    private LocalDateTime dataHora;

    public Lance(Licitante licitante, double valor) {
        this.licitante = licitante;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public Licitante getLicitante() {
        return licitante;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
