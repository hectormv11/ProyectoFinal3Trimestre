package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaccionesBD {
	
	public static Transaccion doLogin(String usuario, String contraseña) throws SQLException {

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

			return null;
		}

		return null;

	}	

}
