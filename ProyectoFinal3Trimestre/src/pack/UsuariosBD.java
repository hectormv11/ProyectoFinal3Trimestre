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
	
	public static int registrarse(String usuario, String contraseña, String email) throws SQLException {

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "INSERT INTO usuarios (password, nombre, email) VALUES (?, ?, ?)";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(2, contraseña);
		ps.setString(3, usuario);
		ps.setString(4, email);

		if(ps.execute()) {
			return 1;
		}

		return 0;

	}

}
