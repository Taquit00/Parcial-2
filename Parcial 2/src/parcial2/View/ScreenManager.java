/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2.View;

import javax.swing.JFrame;
import parcial2.Controller.Controlador;
import parcial2.Model.Casino;
import parcial2.Model.Usuario;
import parcial2.View.Ruleta;

public class ScreenManager {

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
        Login menu = new Login();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setTitle("Registro");
    }

    public static void abrirRuleta(Login menu) {

        Ruleta vista = new Ruleta(menu);


        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Gestión Académica ");
        menu.setVisible(false);

    }

}


