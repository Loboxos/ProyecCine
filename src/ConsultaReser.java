import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

public class ConsultaReser {
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	
	public void insertar(Reserv reserva) {
		try {
			System.out.println("toy aqui");
			String consulta = "insert into reservas(fk_idFunc,fecha,precio,fk_idUser,hora,fk_idButac,fk_iddesc,fk_tarjCredito)values(?,?,?,?,?,?,?,?)";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			System.out.println("aki estoy");
			
			
			ps.setObject(1, reserva.getFk_idFunc());
			ps.setObject(2, reserva.getFechaCompra());
			ps.setObject(3, reserva.getPrecio());
			ps.setObject(4, reserva.getFk_idUser());
			ps.setObject(5, reserva.getHora());
			ps.setObject(6, reserva.getIdbutaca());
			ps.setObject(7, reserva.getFk_iddesc());
			ps.setObject(8, reserva.getFk_idTarjCred());
			
			ps.executeUpdate();
			System.out.println("correcto");
		} catch (Exception e) {
			System.out.println("tu consulta ta mal");
			System.out.println(e);
		}
	}
		public Reserv mostrar() {
			
			try {
				usarConexion = conn.conectar(); // estamos usando la llave
				String consulta = "SELECT * FROM reservas";// usamos este query...
				stm = usarConexion.createStatement();
				rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
				 System.out.println("|id_reserva| id_sala | fecha | precio | id_usuario | id_funcion | hora | id_butaca | id_Desc | tarjCred |");
				while (rs.next()) { // leemos linea por linea
	               		Reserv reserva = new Reserv();
	               		reserva.setId_reservas(rs.getInt(1));
	               		reserva.setFk_idFunc(rs.getInt(2));
	               		reserva.setFechaCompra(rs.getString(3));
	               		reserva.setPrecio(rs.getInt(4));
	               		reserva.setFk_idUser(rs.getInt(5));
	               		reserva.setHora(rs.getString(6));
	               		reserva.setIdbutaca(rs.getInt(7));
	               		reserva.setFk_iddesc(rs.getInt(8));
	               		reserva.setFk_idTarjCred(rs.getInt(9));

	     System.out.printf("%5d,%5d,%10s,%5d,%5d,%10s,%5d,%5d,%5d\n",reserva.getId_reservas(),reserva.getFk_idFunc(),reserva.getFechaCompra(),reserva.getPrecio(),reserva.getFk_idUser(),reserva.getHora(),reserva.getIdbutaca(),reserva.getFk_iddesc(),reserva.getFk_idTarjCred());
				}
			} catch (Exception e) {

			} 
			return null;
		}
public Reserv mostrar(int dni) {
			
			try {
				usarConexion = conn.conectar(); // estamos usando la llave
				String consulta = "SELECT reservas.id_reservas,\r\n"
						+ "reservas.fecha,\r\n"
						+ "reservas.precio,\r\n"
						+ "usuarios.dni\r\n"
						+ "from reservas \r\n"
						+ "join usuarios ON reservas.fk_idUser=usuarios.id_usuario where usuarios.dni= "+dni+"";
				//String consulta = "SELECT * FROM reservas where id_reservas="+"'"+ id_reserv+"'";// usamos este query...
				stm = usarConexion.createStatement();
				rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
				 System.out.println("|id_reserva| fecha | precio | dni |");
				if (rs.next()) { // leemos linea por linea
	               		Reserv reserva = new Reserv();
	               		reserva.setId_reservas(rs.getInt(1));
	               		reserva.setFechaCompra(rs.getString(2));
	               		reserva.setPrecio(rs.getFloat(3));
	               	    reserva.setDniUser(rs.getInt(4));

	     System.out.printf("%5d,  %10s  , $%5.2f  ,  %5d\n",reserva.getId_reservas(),reserva.getFechaCompra(),reserva.getPrecio(),reserva.getDniUser());
				}
				else {
					System.out.println("dni incorrecto");
				}
			} catch (Exception e) {
  System.out.println("dni incorrecto");
			} 
			return null;
		}
	}
	
	
	
	
	
//SELECT DATEDIFF(NOW(),'2002-11-02'); #cuantos días han pasado
	//SELECT DATEDIFF(NOW(),'2010-03-20'); #Cuantos días faltan
	//date_add(now(), interval 3 day)

