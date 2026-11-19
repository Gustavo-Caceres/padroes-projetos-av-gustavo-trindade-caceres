public class Participante extends Observer implements Licitante {
    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void update(Subject subject) {
        Lote lote = (Lote) subject;
        System.out.printf("      [%s] Novo lance no lote %s: R$ %.2f%n", nome, lote.getNome(), lote.getLanceAtual());
    }
}
