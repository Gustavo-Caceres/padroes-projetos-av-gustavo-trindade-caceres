public class FabricaAzure implements FabricaNuvem {
    @Override
    public String getNomeProvedor() {
        return "Azure";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAzure();
    }

    @Override
    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoAzure();
    }

    @Override
    public Fila criarFila() {
        return new FilaAzure();
    }

    @Override
    public double getCustoPorHoraMaquina() {
        return MaquinaVirtualAzure.CUSTO_POR_HORA;
    }

    @Override
    public double getCustoPorGbArmazenamento() {
        return ArmazenamentoAzure.CUSTO_POR_GB;
    }

    @Override
    public double getCustoMensalFila() {
        return FilaAzure.CUSTO_MENSAL;
    }
}
