package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FiltrosBD {
	
	public static Transaccion[] getEditorial(String nombre) throws SQLException {

		Conexion con = new Conexion();
		Statement stm = con.abrirConexion();

		ResultSet rs = stm.executeQuery("SELECT * FROM editorial WHERE nombre = '" + nombre + "'");

		String cif = "";

		if(rs != null) {
			while(rs.next()) {
				cif = rs.getString(1);
			}
		}
		
		Editorial ed = new Editorial(cif, nombre);


		return ed;

	}

}
