import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaHospitalar sistema = new SistemaHospitalar();
            sistema.setVisible(true);
        });
    }
}