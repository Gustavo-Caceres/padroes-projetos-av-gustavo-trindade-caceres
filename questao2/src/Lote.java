import java.util.ArrayList;
import java.util.List;

public class Lote extends Subject {
    public static final double INCREMENTO_MINIMO = 0.05;

    private List<Lance> lances = new ArrayList<>();
    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;
    private RegraComissao regraComissao;
    private boolean aberto = true;
    private boolean vendido = false;
    private double comissaoCobrada;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao) {
        if (precoInicial <= 0 || precoReserva < 0) {
            throw new IllegalArgumentException("Preços inválidos");
        }
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    @Override
    protected boolean deveNotificar(Observer observer) {
        return observer != getUltimoLance().getLicitante();
    }

    public boolean darLance(Licitante licitante, double valor) {
        if (!aberto) {
            System.out.printf("   Lance de %s (R$ %.2f) RECUSADO: o lote %s está encerrado.%n",
                    licitante.getNome(), valor, nome);
            return false;
        }
        double minimo = Math.round(lanceAtual * (1 + INCREMENTO_MINIMO) * 100) / 100.0;
        if (valor < minimo) {
            System.out.printf("   Lance de %s (R$ %.2f) RECUSADO: o mínimo é R$ %.2f (5%% acima do lance atual de R$ %.2f).%n",
                    licitante.getNome(), valor, minimo, lanceAtual);
            return false;
        }
        lances.add(new Lance(licitante, valor));
        lanceAtual = valor;
        System.out.printf("   Lance de %s (R$ %.2f) ACEITO no lote %s.%n", licitante.getNome(), valor, nome);
        notifyAllObservers();
        return true;
    }

    public void setRegraComissao(RegraComissao regraComissao) {
        if (!aberto) {
            throw new IllegalStateException("O lote " + nome + " já foi encerrado");
        }
        this.regraComissao = regraComissao;
    }

    public void encerrar() {
        if (!aberto) {
            return;
        }
        aberto = false;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        if (vendido) {
            comissaoCobrada = regraComissao.calcular(lanceAtual);
            System.out.printf("   Lote %s VENDIDO para %s por R$ %.2f.%n", nome, getComprador().getNome(), lanceAtual);
        } else {
            System.out.printf("   Lote %s NÃO VENDIDO (maior lance R$ %.2f abaixo da reserva de R$ %.2f).%n",
                    nome, lanceAtual, precoReserva);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public int getTotalLances() {
        return lances.size();
    }

    public Lance getUltimoLance() {
        return lances.isEmpty() ? null : lances.get(lances.size() - 1);
    }

    public List<Lance> getLances() {
        return List.copyOf(lances);
    }

    public RegraComissao getRegraComissao() {
        return regraComissao;
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isVendido() {
        return vendido;
    }

    public Licitante getComprador() {
        return vendido ? getUltimoLance().getLicitante() : null;
    }

    public double getValorVenda() {
        if (!vendido) {
            throw new IllegalStateException("O lote " + nome + " não foi vendido");
        }
        return lanceAtual;
    }

    public double getComissaoCobrada() {
        if (!vendido) {
            throw new IllegalStateException("O lote " + nome + " não foi vendido");
        }
        return comissaoCobrada;
    }
}
