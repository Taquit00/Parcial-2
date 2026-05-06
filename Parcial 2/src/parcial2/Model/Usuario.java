
package parcial2.Model;


public class Usuario {
    private String username;
    private String password;
    private double saldo;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 0.0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void recargar(double monto) {
        saldo += monto;
    }

    public boolean apostar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void ganar(double monto) {
        saldo += monto;
    }
}

