package pack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriasBD {
	
	public static ArrayList<Categoria> getCategorias(Usuario user) throws SQLException {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM categorias WHERE id_usuario = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setInt(1, user.getId());

		ResultSet rs = ps.executeQuery();

		if(rs != null) {
			while(rs.next()) {
				
				String nombreCategoria = rs.getString(1);
				String ruta = rs.getString(3);
				Categoria ca = new Categoria(nombreCategoria, user, ruta);

				lista.add(ca);					
			}
		}
		

		return lista;

	}
	
	public static Categoria getCategoria(String nombre, Usuario user) throws SQLException {
		
		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();
		Categoria ca = null;

		String consulta = "SELECT * FROM categorias WHERE nombre = ?";
		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(1, nombre);
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
								
				String ruta = rs.getString(3);

				ca = new Categoria(nombre, user, ruta);
				
			}
		}
		return ca;
		
	}
	
	public static void añadirCategoria(String nombre, Usuario user, String ruta) throws SQLException {
		
		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "INSERT INTO categorias (nombre, id_usuario, imagen) VALUES (?, ?, ?)";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setInt(2, user.getId());
		ps.setString(1, nombre);
		ps.setString(3, ruta);

		ps.execute();
		
	}
	
	

}
