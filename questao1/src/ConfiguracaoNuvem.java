import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfiguracaoNuvem {
    private static ConfiguracaoNuvem instancia;

    private String regiaoPadrao;
    private double orcamentoMensalMaximo;

    private ConfiguracaoNuvem() {
        Properties propriedades = new Properties();
        try (InputStream entrada = new FileInputStream(localizarArquivo())) {
            propriedades.load(entrada);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler o config.properties", e);
        }
        this.regiaoPadrao = propriedades.getProperty("regiao.padrao");
        this.orcamentoMensalMaximo = Double.parseDouble(propriedades.getProperty("orcamento.mensal.maximo"));
        System.out.println(">> config.properties lido (região: " + regiaoPadrao
                + ", orçamento máximo: R$ " + String.format("%.2f", orcamentoMensalMaximo) + ")");
    }

    public static synchronized ConfiguracaoNuvem getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracaoNuvem();
        }
        return instancia;
    }

    private static String localizarArquivo() {
        String[] caminhos = { "config.properties", "src/config.properties", "questao1/src/config.properties" };
        for (String caminho : caminhos) {
            if (Files.exists(Path.of(caminho))) {
                return caminho;
            }
        }
        throw new IllegalStateException("Arquivo config.properties não encontrado");
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMensalMaximo() {
        return orcamentoMensalMaximo;
    }
}
