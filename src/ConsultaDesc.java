import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

public class ConsultaDesc {
    ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	
	
	public void Creadescuento(String dia, float porcentaje, float precioFinal){
		try {
			usarConexion=conn.conectar();
			stm = usarConexion.createStatement();
			//otra forma de insertar datos
			 String consulta=  MessageFormat.format("INSERT INTO descuento (dia, porcentaje, precioFinal) VALUES (''{0}'', {1}, {2});", dia, porcentaje, precioFinal);
			 System.out.println(consulta);
			 stm.executeUpdate(consulta);
			 System.out.println("Valores INSERTADOS con exito :) !");
			 stm.close();
			 usarConexion.close();
			 
			 }catch(Exception e){
				 System.out.println(e);
			 }
		
	}
}