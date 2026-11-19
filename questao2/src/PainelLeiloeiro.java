public class PainelLeiloeiro extends Observer {
    @Override
    public void update(Subject subject) {
        Lote lote = (Lote) subject;
        System.out.printf("      [Painel] %s | maior lance: R$ %.2f | total de lances: %d%n",
                lote.getNome(), lote.getLanceAtual(), lote.getTotalLances());
    }
}
