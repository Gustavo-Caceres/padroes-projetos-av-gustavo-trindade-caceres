public class ComissaoVeiculos implements RegraComissao {
    public static final double PERCENTUAL = 0.08;
    public static final double VALOR_MAXIMO = 5000.00;

    @Override
    public String getNome() {
        return "Veículos (8%, máximo R$ 5.000,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * PERCENTUAL, VALOR_MAXIMO);
    }
}
