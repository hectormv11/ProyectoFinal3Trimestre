package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CuentasBD {
	
	public static String[] getCuentas(Usuario user) throws SQLException {
		
		ArrayList<String> lista = new ArrayList<String>();

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM cuentas WHERE id_usuario = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setInt(1, user.getId());

		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				//Me salto la conrtaseña
				String nombre = rs.getString(1);
				String saldo = rs.getString(3);
				lista.add(nombre + " - " + saldo +"€");					
			}
		}
		
		String[] array = new String[lista.size()];

		for (int i = 0; i < array.length; i++) {

			array[i] = lista.get(i);

		}

		return array;

	}

}
