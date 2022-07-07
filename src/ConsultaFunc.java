import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultaFunc {
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	
public funciones mostrar() {
		
		try {
			usarConexion = conn.conectar(); // estamos usando la llave
			String consulta = "SELECT funciones.idfunciones,\r\n"
					+ "       pelicula.titulo,\r\n"
					+ "       salas.numero,\r\n"
					+ "       salas.formato,\r\n"
					+ "      funciones.fecha\r\n"
					+ "FROM funciones \r\n"
					+ "JOIN pelicula ON funciones.id_pelicula=pelicula.id_pelicula\r\n"
					+ "JOIN salas ON funciones.id_sala=salas.id_salas;";// usamos este query...
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
		    System.out.printf("%s %s %s %s %s%n","|id_FUNCION |","|   PELICULA    |","| NRO DE SALA |","| tipo de sala |","|    FECHA    |");
			while ( rs.next()) { // leemos linea por linea
                funciones func =new funciones();
                func.setIdfunciones(rs.getInt(1));
                func.setId_pelicula(rs.getString(2));
                func.setId_sala(rs.getInt(3));
                func.setFsala(rs.getString(4));
                func.setFecha(rs.getString(5));
System.out.printf("|%6d%20s%15d%15s%20s  |%n",func.getIdfunciones(),func.getId_pelicula(),func.getId_sala(),func.getFsala(),func.getFecha());
			}
		} catch (Exception e) {}
		return null;
	}
}
