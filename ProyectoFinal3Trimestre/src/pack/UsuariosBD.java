package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuariosBD {
	
	public static Usuario doLogin(String usuario, String contraseña) throws SQLException {

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM usuarios WHERE nombre = ? AND BINARY password = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(1, usuario);
		ps.setString(2, contraseña);

		ResultSet rs = ps.executeQuery();

		if(rs != null) {
			rs.next();
			int id = rs.getInt(1);
			//Me salto la conrtaseña
			String nombre = rs.getString(3);
			String email = rs.getString(4);

			Usuario user_devolver = new Usuario(id, rs.getString(2), nombre, email);

			return user_devolver;
		}

		return null;

	}
	
	public static int registrarse(String nombre, String contraseña, String email) throws SQLException {

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "INSERT INTO usuarios (password, nombre, email) VALUES (?, ?, ?)";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(1, contraseña);
		ps.setString(2, nombre);
		ps.setString(3, email);

		if(ps.execute()) {
			return 1;
		}

		return 0;

	}
	
	public static int actualizarContraseña(Usuario usuario, String contraseña) throws SQLException {
		
		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "UPDATE usuarios SET password = ? WHERE id_usuario = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(1, contraseña);
		ps.setInt(2, usuario.getId());

		if(ps.execute()) {
			return 1;
		}

		return 0;
		
	}

}
