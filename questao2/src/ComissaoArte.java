public class ComissaoArte implements RegraComissao {
    public static final double PERCENTUAL = 0.20;

    @Override
    public String getNome() {
        return "Arte (20%)";
    }

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * PERCENTUAL;
    }
}
