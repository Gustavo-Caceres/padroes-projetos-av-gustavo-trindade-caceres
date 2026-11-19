public class Main {
    public static void main(String[] args) throws InterruptedException {
        SeletorProvedor seletor = new SeletorProvedor();
        seletor.registrarFabrica("Aws", new FabricaAws());
        seletor.registrarFabrica("Azure", new FabricaAzure());

        SolicitacaoAmbiente lojaProducao = new SolicitacaoAmbiente("loja-producao", "Aws", 3, 500);
        SolicitacaoAmbiente lojaHomologacao = new SolicitacaoAmbiente("loja-homologacao", "Aws", 1, 100);
        SolicitacaoAmbiente erp = new SolicitacaoAmbiente("erp-financeiro", "Azure", 2, 200);
        SolicitacaoAmbiente dataLake = new SolicitacaoAmbiente("data-lake", "Azure", 10, 5000);

        Thread thread1 = new Thread(() -> provisionar(seletor, lojaProducao));
        Thread thread2 = new Thread(() -> provisionar(seletor, lojaHomologacao));
        Thread thread3 = new Thread(() -> provisionar(seletor, erp));
        Thread thread4 = new Thread(() -> provisionar(seletor, dataLake));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        HistoricoAuditoria.getInstance().imprimir();
    }

    private static void provisionar(SeletorProvedor seletor, SolicitacaoAmbiente solicitacao) {
        FabricaNuvem fabrica = seletor.obterFabrica(solicitacao.getProvedor());
        Provisionador provisionador = new Provisionador(fabrica);
        provisionador.provisionar(solicitacao);
    }
}
