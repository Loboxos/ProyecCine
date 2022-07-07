import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class NNTestConecction {
	

	public static void main(String[] args) {
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	
		try {
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery("SELECT * FROM salas");
			while (rs.next()) {

				int id_salas = rs.getInt(1);
				String pelicula = rs.getString(2);
				String tipo = rs.getString(3);
				int capacidades = rs.getInt(4);
				System.out.println(id_salas + "-"+ pelicula +"-"+ tipo +"-"+ capacidades);
				// System.out.println(listaLibros);
			}
		} catch (Exception e) {

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (usarConexion != null) {
					usarConexion.close();
				}
			} catch (Exception e2) {}
	}
  }  
}