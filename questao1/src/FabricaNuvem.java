public interface FabricaNuvem {
    String getNomeProvedor();
    MaquinaVirtual criarMaquinaVirtual();
    Armazenamento criarArmazenamento();
    Fila criarFila();
    double getCustoPorHoraMaquina();
    double getCustoPorGbArmazenamento();
    double getCustoMensalFila();
}
