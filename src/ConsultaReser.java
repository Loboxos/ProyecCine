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
			String consulta = "insert into reservas(id_sala,fecha,precio,fk_idUser,fk_idFunc,hora,fk_idButac)values(?,?,?,?,?,?,?)";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			System.out.println("aki estoy");
			
			
			ps.setObject(1, reserva.getId_sala());
			ps.setObject(2, reserva.getFechaCompra());
			ps.setObject(3, reserva.getPrecio());
			ps.setObject(4, reserva.getFk_idUser());
			ps.setObject(5, reserva.getFk_idFunc());
			ps.setObject(6, reserva.getHora());
			ps.setObject(7, reserva.getIdbutaca());
			
			ps.executeUpdate();
			System.out.println("correcto");
		} catch (Exception e) {
			System.out.println("tu consulta ta mal");
			System.out.println(e);
		}
	}
//SELECT DATEDIFF(NOW(),'2002-11-02'); #cuantos días han pasado
	//SELECT DATEDIFF(NOW(),'2010-03-20'); #Cuantos días faltan
	//date_add(now(), interval 3 day)
}
