public class VendaLote implements iFatura {
    private String nomeLote;
    private double valorVenda;

    public VendaLote(Lote lote) {
        this.nomeLote = lote.getNome();
        this.valorVenda = lote.getValorVenda();
    }

    @Override
    public String Descricao() {
        return String.format("Lote: %s%n%-31sR$ %10.2f", nomeLote, "Valor de venda:", valorVenda);
    }

    @Override
    public double Preco() {
        return valorVenda;
    }

    @Override
    public double ValorVenda() {
        return valorVenda;
    }
}
