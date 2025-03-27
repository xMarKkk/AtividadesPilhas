import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Classe responsável pela gestão da fila de atendimento hospitalar
public class ControleFila {
    // Estruturas de dados principais
    private Queue<String> filaEspera = new LinkedList<>();        // Fila de pacientes aguardando
    private List<String> historicoAtendimentos = new ArrayList<>(); // Histórico de atendimentos concluídos
    private int contadorSenhas = 1;                              // Contador sequencial para geração de senhas
    private String senhaAtual = "Nenhum paciente em atendimento"; // Status do atendimento atual

    // Gera nova senha no formato PAC-XXX
    public void gerarNovaSenha() {
        String novaSenha = "PAC-" + String.format("%03d", contadorSenhas++); // Formata número com 3 dígitos
        filaEspera.add(novaSenha);  // Adiciona à fila de espera
    }

    // Move próximo paciente da fila para o histórico
    public void chamarProximo() {
        if (!filaEspera.isEmpty()) {
            String senha = filaEspera.poll();  // Remove da fila de espera
            historicoAtendimentos.add(senha);  // Registra no histórico
            senhaAtual = "Atendendo: " + senha; // Atualiza status
        } else {
            senhaAtual = "Nenhum paciente na fila"; // Mensagem de fila vazia
        }
    }

    // Reinicia todas as estruturas para estado inicial
    public void reiniciarSistema() {
        filaEspera.clear();            // Esvazia fila
        historicoAtendimentos.clear(); // Limpa histórico
        contadorSenhas = 1;            // Reseta contador
        senhaAtual = "Sistema reiniciado"; // Mensagem de reinício
    }

    // --- Métodos de acesso aos dados ---
    public Queue<String> getFilaEspera() {
        return filaEspera;  // Retorna fila completa
    }

    public List<String> getHistoricoAtendimentos() {
        return historicoAtendimentos;  // Retorna histórico completo
    }

    public String getSenhaAtual() {
        return senhaAtual;  // Retorna status do atendimento
    }
}