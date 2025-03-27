import java.util.Stack;

// Gerencia o histórico de navegação usando pilhas
public class Funcoes_botoes {
    // Pilha para páginas visitadas (voltar)
    private Stack<String> historicoVoltar = new Stack<>();
    // Pilha para páginas avançadas (avançar)
    private Stack<String> historicoAvancar = new Stack<>();
    // Armazena a página atual sendo exibida
    private String paginaAtual = "Nenhuma página carregada";

    // Adiciona nova "URL" ao histórico e limpa avanços
    public void navegarPara(String url) {
        if (url != null && !url.trim().isEmpty()) {
            historicoVoltar.push(url);
            historicoAvancar.clear(); // Limpa avanços após nova navegação
            paginaAtual = url;
        }
    }

    // Volta para página anterior (move de voltar para avançar)
    public void voltar() {
        if (!historicoVoltar.isEmpty()) {
            String pagina = historicoVoltar.pop();
            historicoAvancar.push(pagina);
            // Atualiza página atual ou mostra mensagem se vazio
            paginaAtual = historicoVoltar.isEmpty() ? "Nenhuma página" : historicoVoltar.peek();
        }
    }

    // Avança para próxima página (move de avançar para voltar)
    public void avancar() {
        if (!historicoAvancar.isEmpty()) {
            String pagina = historicoAvancar.pop();
            historicoVoltar.push(pagina);
            paginaAtual = pagina;
        }
    }

    // --- Métodos de acesso ---
    public Stack<String> getHistoricoVoltar() {
        return historicoVoltar;
    }

    public Stack<String> getHistoricoAvancar() {
        return historicoAvancar;
    }

    public String getPaginaAtual() {
        return paginaAtual;
    }
}