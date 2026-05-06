package parcial2.Model;

public class Usuario {
    private String nombre;
    private String password;
    private double saldo;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.saldo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void recargar(double monto) {
        saldo += monto;
    }

    public boolean apostar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void ganar(double monto) {
        saldo += monto;
    }


}