package pack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriasBD {
	
	public static ArrayList<Categoria> getTransacciones(Usuario user) throws SQLException {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM categorias WHERE id_usuario = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setInt(1, user.getId());

		ResultSet rs = ps.executeQuery();

		if(rs != null) {
			while(rs.next()) {
				
				int id = rs.getInt(1);
				
				String nombreCategoria = rs.getString(4);
				
				String tipo = rs.getString(7);

				Categoria ca = new Categoria(nombreCategoria, user);

				

				lista.add(lista);					
			}
		}
		

		return lista;

	}

}
