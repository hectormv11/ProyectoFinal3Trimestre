package pack;

public class Categoria {
	
	private String nombre;
	private Usuario user;
	
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
	
	public Categoria(String nombre, Usuario user) {
		
		this.nombre = nombre;
		this.user = user;
	}
	@Override
	public String toString() {
		return "nombre" + " - " + user;
	}
}
