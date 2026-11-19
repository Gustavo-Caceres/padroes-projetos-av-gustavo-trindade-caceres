public class ComissaoImoveis implements RegraComissao {
    public static final double PERCENTUAL = 0.03;
    public static final double VALOR_FIXO = 1500.00;

    @Override
    public String getNome() {
        return "Imóveis (3% + R$ 1.500,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * PERCENTUAL + VALOR_FIXO;
    }
}
