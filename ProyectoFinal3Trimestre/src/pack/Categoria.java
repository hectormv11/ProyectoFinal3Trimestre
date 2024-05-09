package pack;

public class Categoria {
	
	private String nombre;
	private Usuario user;
	private String ruta;
	
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
	
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public Categoria(String nombre, Usuario user) {
		
		this.nombre = nombre;
		this.user = user;
	}
	
	
	
}
