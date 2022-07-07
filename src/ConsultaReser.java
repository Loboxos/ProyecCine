import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultaReser {
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	
	public void insertar(Reserv reserva) {
		try {
			String consulta = "insert into reservas (idbutaca)values(?)";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
		
			ps.setObject(2, reserva.getIdbutaca());
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("tu consulta ta mal");
		}
	}
//SELECT DATEDIFF(NOW(),'2002-11-02'); #cuantos días han pasado
	//SELECT DATEDIFF(NOW(),'2010-03-20'); #Cuantos días faltan
	//date_add(now(), interval 3 day)
}
