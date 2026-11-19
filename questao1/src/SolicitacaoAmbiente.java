public class SolicitacaoAmbiente {
    private String nomeAmbiente;
    private String provedor;
    private int quantidadeMaquinas;
    private double gbArmazenamento;

    public SolicitacaoAmbiente(String nomeAmbiente, String provedor, int quantidadeMaquinas, double gbArmazenamento) {
        if (quantidadeMaquinas < 0 || gbArmazenamento < 0) {
            throw new IllegalArgumentException("Quantidades não podem ser negativas");
        }
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getQuantidadeMaquinas() {
        return quantidadeMaquinas;
    }

    public double getGbArmazenamento() {
        return gbArmazenamento;
    }
}
