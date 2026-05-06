
package parcial2.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parcial2.Model.Casino;
import parcial2.Model.Usuario;
import parcial2.View.Ruleta;

public class Controlador implements ActionListener {

    private Ruleta vista;
    private Casino dao; 
    private int numeroElegido;
    
    public Controlador(Ruleta vista, Casino dao) {

        this.vista = vista;

        this.dao = dao;

        this.vista.getGIRAR().addActionListener(this);

        this.vista.getNUM().addActionListener(this);

        this.vista.getCantApostar().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getGIRAR()) {
            girar();
            Usuario usuario = null;
            jugar(usuario,2,2000);//ejemplo
            

        }
        
        
    
    }
    public static int girar() {
        return (int) (Math.random() * 37);
        
        
    }

    public static void jugar(Usuario usuario, int numeroElegido, double apuesta) {

        if (!usuario.apostar(apuesta)) {
            System.out.println("Saldo insuficiente");
            return;
        }

        int resultado = girar();
        System.out.println("Número ganador: " + resultado);

        if (resultado == numeroElegido) {
            double premio = apuesta * 36;
            usuario.ganar(premio);
            System.out.println("¡Ganaste! Premio: " + premio);
        } else {
            System.out.println("Perdiste");
        }
    }
}


