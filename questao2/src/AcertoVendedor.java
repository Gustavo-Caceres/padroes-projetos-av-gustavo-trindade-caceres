public class AcertoVendedor {
    public void imprimir(Lote lote) {
        double valorVenda = lote.getValorVenda();
        double comissao = lote.getComissaoCobrada();
        System.out.println("===== ACERTO DO VENDEDOR =====");
        System.out.println("Lote:              " + lote.getNome());
        System.out.printf("Valor de venda:    R$ %.2f%n", valorVenda);
        System.out.printf("Comissão cobrada:  R$ %.2f (%s)%n", comissao, lote.getRegraComissao().getNome());
        System.out.printf("Valor líquido:     R$ %.2f%n", valorVenda - comissao);
    }
}
