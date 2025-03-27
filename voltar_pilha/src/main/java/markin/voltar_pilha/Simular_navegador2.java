package markin.voltar_pilha;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Simular_navegador2 extends javax.swing.JFrame {

    private Stack<String> historicoVoltar = new Stack<>();
    private Stack<String> historicoAvancar = new Stack<>();
    private String paginaAtual = "Nenhuma página carregada";

    public Simular_navegador2() {
        initComponents();
        atualizarInterface();
    }

    private void atualizarInterface() {
        // Atualiza a exibição do histórico com formatação HTML
        StringBuilder historico = new StringBuilder("<html>Histórico de Navegação:<br>");
        for (String pagina : historicoVoltar) {
            historico.append("→ ").append(pagina).append("<br>");
        }
        historico.append("</html>");
        jLabel1.setText(historico.toString());
        
        // Atualiza status dos botões
        botao_voltar.setEnabled(!historicoVoltar.isEmpty());
        botao_retornar.setEnabled(!historicoAvancar.isEmpty());
        
        // Mostra página atual
        clicks_enter.setText("Página atual: " + paginaAtual);
    }

    private void navegarPara(String url) {
        if (!url.isBlank()) {
            historicoVoltar.push(url);
            historicoAvancar.clear();
            paginaAtual = url;
            atualizarInterface();
        }
    }

    private void voltar() {
        if (!historicoVoltar.isEmpty()) {
            String pagina = historicoVoltar.pop();
            historicoAvancar.push(pagina);
            paginaAtual = historicoVoltar.isEmpty() ? "Nenhuma página" : historicoVoltar.peek();
            atualizarInterface();
        }
    }

    private void avancar() {
        if (!historicoAvancar.isEmpty()) {
            String pagina = historicoAvancar.pop();
            historicoVoltar.push(pagina);
            paginaAtual = pagina;
            atualizarInterface();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input_navegador = new javax.swing.JTextField();
        botao_voltar = new javax.swing.JButton();
        botao_retornar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        enter = new javax.swing.JButton();
        clicks_enter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        input_navegador.setText("Digite a URL aqui");
        getContentPane().add(input_navegador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 300, 30));

        botao_voltar.setText("<-- Voltar");
        botao_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(botao_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        botao_retornar.setText("Avançar -->");
        botao_retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_retornarActionPerformed(evt);
            }
        });
        getContentPane().add(botao_retornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 100, 30));

        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 690, 370));

        enter.setText("IR");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });
        getContentPane().add(enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 70, 30));

        clicks_enter.setEditable(false);
        clicks_enter.setText("Página atual: ");
        getContentPane().add(clicks_enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 610, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_retornarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        avancar();
    }                                            

    private void enterActionPerformed(java.awt.event.ActionEvent evt) {                                      
        navegarPara(input_navegador.getText());
        input_navegador.setText("");
    }                                     

    private void botao_voltarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        voltar();
    }                                            

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simular_navegador2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_retornar;
    private javax.swing.JButton botao_voltar;
    private javax.swing.JTextField clicks_enter;
    private javax.swing.JButton enter;
    private javax.swing.JTextField input_navegador;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}