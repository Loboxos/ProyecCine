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
					+ "       salas.id_salas,\r\n"
					+ "      funciones.fecha\r\n"
					+ "FROM funciones \r\n"
					+ "JOIN pelicula ON funciones.id_pelicula=pelicula.id_pelicula\r\n"
					+ "JOIN salas ON funciones.id_sala=salas.id_salas;";// usamos este query...
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
		    System.out.printf("%s %s %s %s%n","|id_FUNCION |","|   PELICULA    |","|    sala   |","|    FECHA    |");
			while ( rs.next()) { // leemos linea por linea
                funciones func =new funciones();
                func.setIdfunciones(rs.getInt(1));
                func.setTitulo(rs.getString(2));
                func.setId_sala(rs.getInt(3));
                func.setFecha(rs.getString(4));
System.out.printf("|%6d%20s%15d%20s  |%n",func.getIdfunciones(),func.getTitulo(),func.getId_sala(),func.getFecha());
			}
		} catch (Exception e) {}
		return null;
	}
public void crearUnaFuncion(int idpelicula,int sala,String fecha) {
	try {
		usarConexion=conn.conectar();
		stm = usarConexion.createStatement();
		String consulta="insert into funciones (id_pelicula,id_sala,fecha) values ('"+idpelicula+"','"+sala+"','"+fecha+"')";
		System.out.println(consulta);
		stm.executeUpdate(consulta);
      
		/*String consulta = "insert into funciones (id_pelicula,id_sala,fecha) values('"+idpelicula+"','"+sala+"','"+fecha+"')";
		
		usarConexion = conn.conectar();
		ps = usarConexion.prepareStatement(consulta);
		ps.setObject(1, idpelicula);
		ps.setObject(2, sala);
		ps.setObject(3, fecha);
		System.out.println(consulta);
		ps.executeUpdate();*/
	}catch(Exception e) {
		System.out.println(e);
	}
}

}
