public class ComissaoEletronicos implements RegraComissao {
    public static final double PERCENTUAL = 0.12;
    public static final double VALOR_MINIMO = 50.00;

    @Override
    public String getNome() {
        return "Eletrônicos (12%, mínimo R$ 50,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * PERCENTUAL, VALOR_MINIMO);
    }
}
