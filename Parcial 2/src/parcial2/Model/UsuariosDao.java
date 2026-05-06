
package parcial2.Model;

import java.util.ArrayList;
import java.util.List;


public class UsuariosDao {
    
    

    private static List<Usuario> listaUsuarios = new ArrayList<>();


    public boolean guardar(Usuario user) {
        try {
            return listaUsuarios.add(user);
           
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
}

