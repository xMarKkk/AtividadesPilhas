import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Navegador_simulado navegador = new Navegador_simulado();
            navegador.setVisible(true);
        });
    }
}