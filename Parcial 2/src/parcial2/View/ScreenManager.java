package parcial2.View;

import javax.swing.JFrame;
import parcial2.Controller.ControladorLo;
import parcial2.Model.Casino;
import parcial2.Model.Usuario;

public class ScreenManager {

    private static JFrame ventanaActual;

    
    private static JFrame current;

    public static void show(JFrame newScreen) {
        if (current != null) {
            current.dispose();
        }
        current = newScreen;
        current.setVisible(true);
    }

    public static void registrar(String user, String pass) {
        Casino.usuarios.add(new Usuario(user, pass));

        Usuario u = Casino.login(user, pass);
        if (u != null) {

        } else {

        }

    }

    public static void abrirLogin() {
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setTitle("Registro");
    }

    public static void abrirRuleta(Login login) {

        Ruleta vista = new Ruleta(login);

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Gestión Académica ");
        login.setVisible(false);

    }

    public static void cerrarLogin(ControladorLo controladorr) {
        if (controladorr != null) {
            controladorr.finalizar();
            controladorr = null;
            System.err.println("pantalla cerrada");

        }
    }

}
