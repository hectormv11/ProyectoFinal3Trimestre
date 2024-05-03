package pack;

public class Cuenta {
	
	private String nombre;
	private Usuario user;
	private double saldo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Cuenta(String nombre, Usuario user, double saldo) {
		
		this.nombre = nombre;
		this.user = user;
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", user=" + user + ", saldo=" + saldo + "]";
	}

}
