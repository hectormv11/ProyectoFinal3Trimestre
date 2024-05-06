package pack;

import java.sql.Date;

public class Transaccion {
	
	private int id;
	private double cantidad;
	private String cuenta;
	private Categoria cat;
	private String comentario;
	private String tipo;
	private Date fecha;
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
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
	public Cuenta getUser() {
		return cuenta;
	}
	public void setUser(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	
	public Transaccion(int id, double cantidad, Cuenta cuenta, Categoria cat, Date fecha, String comentario, String tipo) {
		
		this.id = id;
		this.cantidad = cantidad;
		this.cuenta = cuenta;
		this.cat = cat;
		this.comentario = comentario;
		this.tipo = tipo;
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Transaccion: " + id + ", cantidad -> " + cantidad + ", + Categoria -> " + cat + "]";
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
