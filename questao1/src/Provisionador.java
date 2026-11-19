public class Provisionador {
    public static final int HORAS_POR_MES = 730;

    private FabricaNuvem fabrica;

    public Provisionador(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public double calcularCustoMensal(SolicitacaoAmbiente solicitacao) {
        return solicitacao.getQuantidadeMaquinas() * fabrica.getCustoPorHoraMaquina() * HORAS_POR_MES
                + solicitacao.getGbArmazenamento() * fabrica.getCustoPorGbArmazenamento()
                + fabrica.getCustoMensalFila();
    }

    public Ambiente provisionar(SolicitacaoAmbiente solicitacao) {
        ConfiguracaoNuvem configuracao = ConfiguracaoNuvem.getInstance();
        HistoricoAuditoria historico = HistoricoAuditoria.getInstance();
        String provedor = fabrica.getNomeProvedor();
        double custo = calcularCustoMensal(solicitacao);

        if (custo > configuracao.getOrcamentoMensalMaximo()) {
            String motivo = String.format("RECUSADO (custo estimado R$ %.2f ultrapassa o orçamento de R$ %.2f)",
                    custo, configuracao.getOrcamentoMensalMaximo());
            historico.registrar(solicitacao.getNomeAmbiente(), provedor, motivo);
            System.out.println(">> Ambiente " + solicitacao.getNomeAmbiente() + " " + motivo + "\n");
            return null;
        }

        Ambiente ambiente = new Ambiente(solicitacao.getNomeAmbiente(), configuracao.getRegiaoPadrao(), fabrica,
                solicitacao.getQuantidadeMaquinas(), custo);
        historico.registrar(solicitacao.getNomeAmbiente(), provedor, "ACEITO");
        System.out.println(ambiente.gerarResumo());
        return ambiente;
    }
}
