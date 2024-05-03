package pack;

public class Usuario {
	
	private int id;
	private String usuario;
	private String pass;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Usuario(String usuario, String pass, String email) {
		
		this.usuario = usuario;
		this.pass = pass;
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Usuario [Nombre =" + usuario + ", pass =" + pass + ", email =" + email + "]";
	}
}
