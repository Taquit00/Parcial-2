/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import parcial2.Model.Usuario;
import parcial2.Model.UsuariosDao;
import parcial2.View.Login;
import parcial2.View.ScreenManager;

/**
 *
 * @author Andrea Florez
 */
public class ControladorLo implements ActionListener{
    private Login vista;
    private UsuariosDao dao;

    public ControladorLo(Login vista, UsuariosDao dao) {
        this.vista = vista;
        this.dao = dao;
        
        this.vista.getBtnRegistro().addActionListener(this);
        this.vista.getBtnSesion().addActionListener(this);
        
        this.vista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ScreenManager.cerrarLogin(ControladorLo.this);
            }            
        }); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vista.getBtnRegistro()) {
            registrar();            
        } else if (e.getSource()== vista.getBtnSesion()) {
            iniciosecion(); 
            ScreenManager.abrirRuleta(vista);
        }
    }
    private void registrar(){
        try {
            Usuario usu= capturadatos();
            if (dao.guardar(usu)) {
                JOptionPane.showMessageDialog(vista, "usuario guardado");
                limpiarcampo();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "error en los datos " + e.getMessage());
        }        
    }
    private void iniciosecion(){
        try {
            Usuario ust= capturadatos();
            if (dao.guardar(ust)) {
                JOptionPane.showMessageDialog(vista, "secion iniciada");
                limpiarcampo();                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "error al iniciar secion");
        }
    }
    private Usuario capturadatos(){
        return new Usuario(
        vista.getNameRegistro().getText(),
        vista.getPassRegistro().getText()
        );
    }
    private void limpiarcampo(){
        vista.getNameRegistro().setText("");
        vista.getPassRegistro().setText("");
    }
    public void finalizar(){
        this.vista.dispose();
        this.vista=null;
        this.dao=null;
        System.err.println("controlador liberado");
        
    }
}
