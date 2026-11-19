public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Quadro Paisagem Paranaense", "Arte", 10000.00, 15000.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletrônicos", 3000.00, 8000.00, new ComissaoEletronicos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        quadro.attach(painel);
        quadro.attach(auditor);
        quadro.attach(ana);
        quadro.attach(bruno);
        quadro.attach(carla);

        notebook.attach(painel);
        notebook.attach(auditor);
        notebook.attach(ana);
        notebook.attach(bruno);

        System.out.println("===== LANCES: " + quadro.getNome() + " (" + quadro.getCategoria() + ") =====");
        quadro.darLance(ana, 11000.00);
        quadro.darLance(bruno, 11200.00);
        quadro.darLance(bruno, 12000.00);
        quadro.darLance(carla, 14000.00);

        System.out.println("\n>> Bruno deixou de acompanhar o lote " + quadro.getNome());
        quadro.detach(bruno);
        quadro.darLance(ana, 16000.00);

        System.out.println("\n===== LANCES: " + notebook.getNome() + " (" + notebook.getCategoria() + ") =====");
        notebook.darLance(ana, 3200.00);
        notebook.darLance(bruno, 3300.00);
        notebook.darLance(bruno, 3400.00);

        System.out.println("\n>> Campanha: o lote " + quadro.getNome() + " passa a usar a regra de comissão de Eletrônicos");
        quadro.setRegraComissao(new ComissaoEletronicos());

        System.out.println("\n===== ENCERRAMENTO =====");
        quadro.encerrar();
        notebook.encerrar();
        notebook.darLance(carla, 5000.00);

        iFatura fatura = new VendaLote(quadro);
        fatura = new SeguroTransporteDecorator(fatura);
        fatura = new CertificadoAutenticidadeDecorator(fatura);
        fatura = new EmbalagemEspecialDecorator(fatura);
        fatura = new EmbalagemEspecialDecorator(fatura);
        fatura = new EntregaExpressaDecorator(fatura);

        System.out.println();
        imprimirFatura(fatura);

        System.out.println();
        new AcertoVendedor().imprimir(quadro);

        System.out.println();
        auditor.imprimir();
    }

    private static void imprimirFatura(iFatura fatura) {
        System.out.println("===== FATURA DO COMPRADOR =====");
        System.out.println(fatura.Descricao());
        System.out.printf("%-31sR$ %10.2f%n", "TOTAL A PAGAR:", fatura.Preco());
    }
}
