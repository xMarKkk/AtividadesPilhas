import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// Janela principal do sistema hospitalar com interface gráfica
public class SistemaHospitalar extends JFrame {
    private ControleFila controle = new ControleFila();  // Controlador da lógica de negócio
    
    // Componentes da interface
    private JButton btnGerarSenha = new JButton("Gerar Senha");
    private JButton btnChamarProximo = new JButton("Chamar Próximo");
    private JButton btnReiniciar = new JButton("Reiniciar Sistema");
    private JTextArea txtFila = new JTextArea();        // Exibe fila de espera
    private JTextArea txtHistorico = new JTextArea();   // Exibe histórico de atendimentos
    private JLabel lblStatus = new JLabel("Status: ");  // Mostra status atual

    public SistemaHospitalar() {
        configurarInterface();   // Monta componentes visuais
        atualizarInterface();    // Carrega dados iniciais
    }

    // Configura layout e componentes da interface
    private void configurarInterface() {
        setTitle("Sistema de Controle Hospitalar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        
        // Painel superior com botões de ação
        JPanel painelSuperior = new JPanel(new FlowLayout());
        painelSuperior.add(btnGerarSenha);     // Gera novas senhas
        painelSuperior.add(btnChamarProximo);  // Chama próximo paciente
        painelSuperior.add(btnReiniciar);      // Reinicia todo o sistema
        painelSuperior.add(lblStatus);         // Exibe senha atual
        
        // Painel principal com áreas de texto
        JPanel painelInformacoes = new JPanel(new GridLayout(1, 2));
        txtFila.setEditable(false);       // Fila só para leitura
        txtHistorico.setEditable(false);  // Histórico imutável
        
        // Adiciona scroll às áreas de texto
        JScrollPane scrollFila = new JScrollPane(txtFila);
        JScrollPane scrollHistorico = new JScrollPane(txtHistorico);
        
        painelInformacoes.add(new JLabel("Fila de Espera:"));
        painelInformacoes.add(scrollFila);
        painelInformacoes.add(new JLabel("Histórico de Atendimentos:"));
        painelInformacoes.add(scrollHistorico);
        
        // Adiciona componentes à janela
        add(painelSuperior, BorderLayout.NORTH);
        add(painelInformacoes, BorderLayout.CENTER);
        
        // Configura ações dos botões
        btnGerarSenha.addActionListener(this::gerarSenhaAction);
        btnChamarProximo.addActionListener(this::chamarProximoAction);
        btnReiniciar.addActionListener(this::reiniciarAction);
    }

    // Atualiza todas as informações na tela
    private void atualizarInterface() {
        txtFila.setText(String.join("\n", controle.getFilaEspera()));
        txtHistorico.setText(String.join("\n", controle.getHistoricoAtendimentos()));
        lblStatus.setText(controle.getSenhaAtual());
        btnChamarProximo.setEnabled(!controle.getFilaEspera().isEmpty());
    }

    // Eventos dos botões
    private void gerarSenhaAction(ActionEvent e) {
        controle.gerarNovaSenha();
        atualizarInterface();
    }

    private void chamarProximoAction(ActionEvent e) {
        controle.chamarProximo();
        atualizarInterface();
    }

    private void reiniciarAction(ActionEvent e) {
        controle.reiniciarSistema();
        atualizarInterface();
    }
}