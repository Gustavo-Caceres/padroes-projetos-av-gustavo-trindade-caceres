public class CertificadoAutenticidadeDecorator extends ServicoAdicionalDecorator {
    public static final double VALOR = 300.00;

    public CertificadoAutenticidadeDecorator(iFatura fatura) {
        super(fatura);
    }

    @Override
    public String Descricao() {
        return fatura.Descricao() + String.format("%n+ %-28s R$ %10.2f", "Certificado de autenticidade", custo());
    }

    @Override
    public double Preco() {
        return fatura.Preco() + custo();
    }

    private double custo() {
        return VALOR;
    }
}
