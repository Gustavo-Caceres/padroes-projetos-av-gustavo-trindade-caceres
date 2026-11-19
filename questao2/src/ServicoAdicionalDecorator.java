public abstract class ServicoAdicionalDecorator implements iFatura {
    protected iFatura fatura;

    public ServicoAdicionalDecorator(iFatura fatura) {
        this.fatura = fatura;
    }

    @Override
    public double ValorVenda() {
        return fatura.ValorVenda();
    }
}
