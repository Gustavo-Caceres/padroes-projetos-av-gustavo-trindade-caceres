public class SeguroTransporteDecorator extends ServicoAdicionalDecorator {
    public static final double PERCENTUAL = 0.015;

    public SeguroTransporteDecorator(iFatura fatura) {
        super(fatura);
    }

    @Override
    public String Descricao() {
        return fatura.Descricao() + String.format("%n+ %-28s R$ %10.2f", "Seguro de transporte", custo());
    }

    @Override
    public double Preco() {
        return fatura.Preco() + custo();
    }

    private double custo() {
        return ValorVenda() * PERCENTUAL;
    }
}
