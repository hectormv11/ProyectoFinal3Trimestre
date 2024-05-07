package pack;

public class Cuenta {
	
	private int id;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Cuenta(int id, String nombre, Usuario user, double saldo) {
		
		this.id = id;
		this.nombre = nombre;
		this.user = user;
		this.saldo = saldo;
	}
	
	public Cuenta() {
		
	}
	@Override
	public String toString() {
		return nombre + " - " + saldo;
	}
	
	
	
}
