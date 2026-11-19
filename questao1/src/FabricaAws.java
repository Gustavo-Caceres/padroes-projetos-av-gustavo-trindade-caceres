public class FabricaAws implements FabricaNuvem {
    @Override
    public String getNomeProvedor() {
        return "Aws";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAws();
    }

    @Override
    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoAws();
    }

    @Override
    public Fila criarFila() {
        return new FilaAws();
    }

    @Override
    public double getCustoPorHoraMaquina() {
        return MaquinaVirtualAws.CUSTO_POR_HORA;
    }

    @Override
    public double getCustoPorGbArmazenamento() {
        return ArmazenamentoAws.CUSTO_POR_GB;
    }

    @Override
    public double getCustoMensalFila() {
        return FilaAws.CUSTO_MENSAL;
    }
}
