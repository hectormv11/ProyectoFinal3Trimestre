package pack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TransaccionesBD {
	
	public static Transaccion[] getTransacciones(String nombreCuenta) throws SQLException {
		
		

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM transaccion WHERE cuenta = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(1, nombreCuenta);

		ResultSet rs = ps.executeQuery();

		if(rs != null) {
			rs.next();
			int id = rs.getInt(1);
			Double cant = rs.getDouble(2);
			String cuenta = rs.getString(3);
			String categoria = rs.getString(4);
			Date fecha = rs.getDate(5);
			String tipo = rs.getString(6);

			Transaccion transaccion_devolver = new Transaccion(id, cant, null, null, fecha, categoria, tipo);

			return null;
		}

		return null;

	}	

}
