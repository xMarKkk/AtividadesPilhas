import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Navegador_simulado extends JFrame {
    private Funcoes_botoes funcoes = new Funcoes_botoes();
    
    // Componentes da interface Swing
    private JButton botao_voltar = new JButton("<--");
    private JButton botao_retornar = new JButton("-->");
    private JTextField input_navegador = new JTextField("Pesquise aqui");
    private JLabel jLabel1 = new JLabel();
    private JButton enter = new JButton("ENTER");
    private JTextField clicks_enter = new JTextField("Página atual: ");

    public Navegador_simulado() {
        configurarInterface();
        atualizarInterface();   
        // Configurações do campo de texto
        input_navegador.setForeground(Color.GRAY); // Cor do texto da dica
            input_navegador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (input_navegador.getText().equals("Digite a URL aqui")) {
                    input_navegador.setText("");
                    input_navegador.setForeground(Color.BLACK);
                }
            }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (input_navegador.getText().isEmpty()) {
                input_navegador.setText("Digite a URL aqui");
                input_navegador.setForeground(Color.GRAY);
            }
        }
    });
}

    // Layout
    private void configurarInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 480);
        setLayout(null);
        
        // Posicionamento dos componentes
        botao_voltar.setBounds(10, 10, 100, 30);
        botao_retornar.setBounds(120, 10, 100, 30);
        input_navegador.setBounds(230, 10, 300, 30);
        jLabel1.setBounds(10, 80, 690, 370);
        enter.setBounds(530, 10, 90, 29);
        clicks_enter.setBounds(10, 50, 610, 30);
        clicks_enter.setForeground(new Color(100, 30, 100)); // Cor da exibição da página
        clicks_enter.setFont(new Font("Arial", Font.BOLD, 20)); // Fonte Arial, negrito, tamanho 20


        jLabel1.setVerticalAlignment(SwingConstants.TOP); // Alinhamento vertical para label ficar topo
        clicks_enter.setEditable(false); //Trava edição do "Painel de exibição"
        
        // Adicionar componentes no JFrame
        add(botao_voltar);
        add(botao_retornar);
        add(input_navegador);
        add(jLabel1);
        add(enter);
        add(clicks_enter);
        
        // Listagem dos eventos
        botao_voltar.addActionListener(e -> {
            funcoes.voltar();
            atualizarInterface();
        });
        
        botao_retornar.addActionListener(e -> {
            funcoes.avancar();
            atualizarInterface();
        });
        
        enter.addActionListener(e -> {
            funcoes.navegarPara(input_navegador.getText());
            input_navegador.setText("");
            atualizarInterface();
        });
    }

    private void atualizarInterface() {
        StringBuilder historico = new StringBuilder("<html>Histórico de Navegação:<br>");
        for (String pagina : funcoes.getHistoricoVoltar()) {
            historico.append("→ ").append(pagina).append("<br>");
        }
        historico.append("</html>");
        jLabel1.setText(historico.toString());
        
        botao_voltar.setEnabled(!funcoes.getHistoricoVoltar().isEmpty());
        botao_retornar.setEnabled(!funcoes.getHistoricoAvancar().isEmpty());
        
        clicks_enter.setText("Página atual: " + funcoes.getPaginaAtual());
    }
}