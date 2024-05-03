package pack;

public class Transaccion {
	
	private int id;
	private double cantidad;
	private Usuario user;
	private Categoria cat;
	private String comentario;
	private char tipo;
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	
	public Transaccion(int id, double cantidad, Usuario user, Categoria cat, String comentario, char tipo) {
		
		this.id = id;
		this.cantidad = cantidad;
		this.user = user;
		this.cat = cat;
		this.comentario = comentario;
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Transaccion: " + id + ", cantidad -> " + cantidad + ", + Categoria -> " + cat + "]";
	}
}
