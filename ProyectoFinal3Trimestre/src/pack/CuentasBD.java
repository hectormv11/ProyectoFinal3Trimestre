package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CuentasBD {

	public static Cuenta[] getCuentas(Usuario user) throws SQLException {

		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM cuentas WHERE id_usuario = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setInt(1, user.getId());

		ResultSet rs = ps.executeQuery();

		if(rs != null) {
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				double saldo = rs.getDouble(4);

				Cuenta c = new Cuenta(id, nombre, user, saldo);
				lista.add(c);					
			}
		}

		Cuenta[] array = new Cuenta[lista.size()];

		for (int i = 0; i < array.length; i++) {

			array[i] = lista.get(i);

		}

		return array;

	}

	public static Cuenta getCuenta(int numCuenta, Usuario user) throws SQLException {


		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "SELECT * FROM cuentas WHERE id_cuenta = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setInt(1, numCuenta);

		ResultSet rs = ps.executeQuery();

		Cuenta c = null;

		if(rs != null) {
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				double saldo = rs.getDouble(4);

				c = new Cuenta(id, nombre, user, saldo);
			}
		}


		return c;

	}

	public static int registrarCuenta(String nombre, Usuario user, double saldo) throws SQLException {

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "INSERT INTO cuentas (nombre, id_usuario, saldo) VALUES (?, ?, ?)";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(1, nombre);
		ps.setInt(2, user.getId());
		ps.setDouble(3, saldo);

		if(ps.execute()) {
			return 1;
		}

		return 0;

	}

	public static int actualizarCuenta(String nombre, Cuenta c, double saldo) throws SQLException {

		Conexion con = new Conexion();
		Connection link = con.abrirConsulta();

		String consulta = "UPDATE cuentas SET nombre = ?, saldo = ?  WHERE id_cuenta = ?";

		PreparedStatement ps = link.prepareStatement(consulta);

		ps.setString(1, nombre);
		ps.setInt(3, c.getId());
		ps.setDouble(2, saldo);

		if(ps.execute()) {
			return 1;
		}

		return 0;

	}

}
