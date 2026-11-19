import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private String nome;
    private String provedor;
    private String regiao;
    private List<MaquinaVirtual> maquinas = new ArrayList<>();
    private Armazenamento armazenamento;
    private Fila fila;
    private double custoMensalEstimado;

    public Ambiente(String nome, String regiao, FabricaNuvem fabrica, int quantidadeMaquinas, double custoMensalEstimado) {
        this.nome = nome;
        this.regiao = regiao;
        this.provedor = fabrica.getNomeProvedor();
        for (int i = 0; i < quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        this.armazenamento = fabrica.criarArmazenamento();
        this.fila = fabrica.criarFila();
        this.custoMensalEstimado = custoMensalEstimado;
    }

    public String gerarResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append("===== AMBIENTE PROVISIONADO =====\n");
        resumo.append("Ambiente:       ").append(nome).append("\n");
        resumo.append("Provedor:       ").append(provedor).append("\n");
        resumo.append("Região:         ").append(regiao).append("\n");
        for (MaquinaVirtual maquina : maquinas) {
            resumo.append("Máquina:        ").append(maquina.getId()).append("\n");
        }
        resumo.append("Armazenamento:  ").append(armazenamento.getId()).append("\n");
        resumo.append("Fila:           ").append(fila.getId()).append("\n");
        resumo.append("Custo mensal:   R$ ").append(String.format("%.2f", custoMensalEstimado)).append("\n");
        return resumo.toString();
    }
}
