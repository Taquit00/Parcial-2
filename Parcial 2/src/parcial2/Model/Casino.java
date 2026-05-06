
package parcial2.Model;


import java.util.ArrayList;

public class Casino {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static Usuario login(String user, String pass) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                return u;
            }
        }
        return null;
    }
}