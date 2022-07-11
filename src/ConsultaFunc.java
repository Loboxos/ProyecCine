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

	public ConsultaFunc() {
		
	}
	public String ConsultaHora(int id_funcion) {
		try {
			usarConexion=conn.conectar();
			stm = usarConexion.createStatement();
			String consulta="Select hora from funciones where idfunciones="+"'"+id_funcion+"'";
	
			rs=stm.executeQuery(consulta);
			 while(rs.next()) { // leemos linea por linea
				  String hora =rs.getString(1);
	            return hora;
	            }
	    
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
public String ConsultaFecha(int id_funcion) {
	try {
		usarConexion=conn.conectar();
		stm = usarConexion.createStatement();
		String consulta="Select fecha from funciones where idfunciones="+"'"+id_funcion+"'";
		
		rs=stm.executeQuery(consulta);
		 while(rs.next()) { // leemos linea por linea
			  String fecha =rs.getString(1);
            return fecha;
            }
    
	}catch(Exception e) {
		System.out.println(e);
	}
	return null;
}
public int ConsultarPrecio(int id_funcion) {
	try {
		usarConexion=conn.conectar();
		stm = usarConexion.createStatement();
		String consulta="Select precio from funciones where idfunciones="+"'"+id_funcion+"'";
		
		rs=stm.executeQuery(consulta);
		 while(rs.next()) { // leemos linea por linea
			  int precio =rs.getInt(1);
            return precio;
            }
    
	}catch(Exception e) {
		System.out.println(e);
	}
	return 0;
}
public funciones mostrar() {
		
		try {
			usarConexion = conn.conectar(); // estamos usando la llave
			String consulta = "SELECT funciones.idfunciones,\r\n"
					+ "       pelicula.titulo,\r\n"
					+ "       salas.id_salas,\r\n"
					+ "      funciones.fecha,\r\n"
					+"       funciones.hora,\r\n"
					+"       funciones.precio\r\n"
					+ "FROM funciones \r\n"
					+ "JOIN pelicula ON funciones.id_pelicula=pelicula.id_pelicula\r\n"
					+ "JOIN salas ON funciones.id_sala=salas.id_salas;";// usamos este query...
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
		    System.out.printf("%s %s %s %s %s %s%n","|id_FUNCION |","|   PELICULA    |","|    sala   |","       |    FECHA    |","      |   HORA |  ","|      PRECIO    |");
			while ( rs.next()) { // leemos linea por linea
				
                funciones func =new funciones();
                func.setIdfunciones(rs.getInt(1));
                func.setTitulo(rs.getString(2));
                func.setId_sala(rs.getInt(3));
                func.setFecha(rs.getString(4));
                func.setHora(rs.getString(5));
                func.setPrecio(rs.getInt(6));
                
System.out.printf("|%6d%23s%15d%20s%20s%10d  |%n",func.getIdfunciones(),func.getTitulo(),func.getId_sala(),func.getFecha(),func.getHora(),func.getPrecio());
			}
		} catch (Exception e) {}
		return null;
	}
public void crearUnaFuncion(int idpelicula,int sala,String fecha, String hora,int precio) {
	try {
		usarConexion=conn.conectar();
		stm = usarConexion.createStatement();
		String consulta="insert into funciones (id_pelicula,id_sala,fecha,hora,precio) values ('"+idpelicula+"','"+sala+"','"+fecha+"','"+hora+"','"+precio+"')";
		System.out.println(consulta);
		stm.executeUpdate(consulta);
    
	}catch(Exception e) {
		System.out.println(e);
	}
}

}
