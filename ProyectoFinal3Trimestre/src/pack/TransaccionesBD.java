package pack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransaccionesBD {

	public static Transaccion[] getTransacciones(Cuenta c, Usuario user) throws SQLException {

		ArrayList<Transaccion> lista = new ArrayList<Transaccion>();

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM transaccion WHERE cuenta = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setInt(1, c.getId());

		ResultSet rs = ps.executeQuery();

		if(rs != null) {
			while(rs.next()) {
				int id = rs.getInt(1);
				Double cant = rs.getDouble(2);
				String nombreCategoria = rs.getString(4);
				Date fecha = rs.getDate(5);
				String comentario = rs.getString(6);
				String tipo = rs.getString(7);

				Categoria cat = CategoriasBD.getCategoria(nombreCategoria, user);
				Categoria ca = new Categoria(nombreCategoria, user, cat.getRuta());

				Transaccion actual = new Transaccion(id, cant, c, ca, fecha, comentario, tipo);

				lista.add(actual);					
			}
		}

		Transaccion[] array = new Transaccion[lista.size()];

		for (int i = 0; i < array.length; i++) {
			array[i] = lista.get(i);
		}		

		return array;

	}	
	
	public static void añadirTransaccion(Transaccion trans) throws SQLException {
		
		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "INSERT INTO transaccion (cantidad, cuenta, categoria, fecha, comentario, tipo) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setDouble(1, trans.getCantidad());
		ps.setInt(2, trans.getCuenta().getId());
		ps.setString(3, trans.getCat().getNombre());
		ps.setDate(4, trans.getFecha());
		ps.setString(5, trans.getComentario());
		ps.setString(6, trans.getTipo());

		ps.execute();
		
	}
	
	public static Transaccion[] getTansFiltros(Usuario user, Cuenta c, double cantidad, Date fecha, Categoria categoria, String tipoS) throws SQLException {
		
		Conexion con = new Conexion();
		Statement stm = con.abrirConexion();

		ArrayList<Transaccion> lista = new ArrayList<Transaccion>();

		String consulta = "SELECT * FROM transaccion WHERE cuenta = " + c.getId();
		
		if(cantidad != 0.0) {
			consulta += "cantidad = " + cantidad;
		}
		if(fecha != null) {
			consulta += "fecha = " + fecha;
		}
		if(categoria != null) {
			consulta += "categoria = " + categoria.getNombre();
		}
		if(tipoS != null) {
			consulta += "tipo = " + tipoS;
		}
		
		ResultSet rs = stm.executeQuery(consulta);

		if(rs != null) {
			while(rs.next()) {
				
				int id = rs.getInt(1);
				Double cant = rs.getDouble(2);
				String nombreCategoria = rs.getString(4);
				Date fechaN = rs.getDate(5);
				String comentario = rs.getString(6);
				String tipo = rs.getString(7);

				Categoria cat = CategoriasBD.getCategoria(nombreCategoria, user);
				Categoria ca = new Categoria(nombreCategoria, user, cat.getRuta());

				Transaccion actual = new Transaccion(id, cant, c, ca, fechaN, comentario, tipo);

				lista.add(actual);
				
			}
		}

		Transaccion[] array = new Transaccion[lista.size()];

		for (int i = 0; i < array.length; i++) {
			array[i] = lista.get(i);
		}		

		return array;

	}

}
