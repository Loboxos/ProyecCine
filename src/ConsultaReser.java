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
			System.out.println("toy aqui");
			String consulta = "insert into reservas(id_reservas,idbutaca,id_sala,fecha,precio,fk_idUser,fk_idFunc,hora)values(?,?,?,?,?,?,?,?)";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			System.out.println("aki estoy");
			
			ps.setObject(1, reserva.getId_reservas());
			ps.setObject(2, reserva.getIdbutaca());
			ps.setObject(3, reserva.getId_sala());
			ps.setObject(4, reserva.getFechaCompra());
			ps.setObject(5, reserva.getPrecio());
			ps.setObject(6, reserva.getFk_idUser());
			ps.setObject(7, reserva.getFk_idFunc());
			ps.setObject(8, reserva.getHora());
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("tu consulta ta mal");
		}
	}
//SELECT DATEDIFF(NOW(),'2002-11-02'); #cuantos días han pasado
	//SELECT DATEDIFF(NOW(),'2010-03-20'); #Cuantos días faltan
	//date_add(now(), interval 3 day)
}
