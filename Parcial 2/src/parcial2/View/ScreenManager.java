package parcial2.View;

import javax.swing.JFrame;
import parcial2.Model.Usuario;

public class ScreenManager {

    private static JFrame current;

    public static void show(JFrame newScreen) {
        if (current != null) {
            current.dispose();
        }
        current = newScreen;
        current.setLocationRelativeTo(null);
        current.setVisible(true);
    }

    public static void abrirLogin() {
        Login login = new Login();
        login.setTitle("Login / Registro");
        show(login);
    }

    public static void abrirRuleta(Usuario usuario) {
        Ruleta ruleta = new Ruleta(usuario);
        ruleta.setTitle("Ruleta");
        show(ruleta);
    }
}