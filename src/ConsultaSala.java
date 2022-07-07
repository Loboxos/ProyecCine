import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultaSala {
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	
	public ArrayList<Sala> lista() {
		ArrayList<Sala> listaPelis= new ArrayList<>();
		try {
			usarConexion = conn.conectar();
			String consulta = "SELECT * FROM salas";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			while (rs.next()) {
			Sala sa = new Sala();
            sa.setId_sala(rs.getInt(1));
            sa.setNumero(rs.getInt(2));
            sa.setFormato(rs.getString(3));
            sa.setCapacidades(rs.getInt(4));

			}
		} catch (Exception e) {

		}
		return listaPelis;
	}
	public Sala mostrar() {
		
		try {
			usarConexion = conn.conectar(); // estamos usando la llave
			String consulta = "SELECT * FROM salas";// usamos este query...
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
			while (rs.next()) { // leemos linea por linea
                Sala sala =new Sala();
                sala.setId_sala(rs.getInt(1));
                sala.setNumero(rs.getInt(2));
                sala.setFormato(rs.getString(3));
                sala.setCapacidades(rs.getInt(4));
                System.out.println("id_sala NRO DE SALA  FORMATO CAPACIDAD");
System.out.printf("%d,%d,%s,%d\n",sala.getId_sala(),sala.getNumero(),sala.getFormato(),sala.getCapacidades());
			}
		} catch (Exception e) {

		}
		return null;
	}
}
