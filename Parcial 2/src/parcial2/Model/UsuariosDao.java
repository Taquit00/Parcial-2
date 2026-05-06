package parcial2.Model;

import java.util.ArrayList;

public class UsuariosDao {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    // Registrar usuario
    public static boolean registrar(String nombre, String password) {
        // Verificar si ya existe
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre)) {
                return false; // ya existe
            }
        }

        usuarios.add(new Usuario(nombre, password));
        return true;
    }

    // Login
    public static Usuario login(String nombre, String password) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
    
    public boolean guardar(Usuario user) {
        try {
            return usuarios.add(user);
           
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
}
