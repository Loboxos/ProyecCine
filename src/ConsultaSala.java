import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultaSala {
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	
	/*public ArrayList<Sala> lista() {
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
	}*/
	public void CrearSala() {
		try {
			Scanner ingreso = new Scanner(System.in);
			System.out.println("Ingrese Numero de sala");
			int idsala=ingreso.nextInt();
			System.out.println("Ingrese formato ");
			String formato=ingreso.next();
			System.out.println("Ingrese capacidades");	
			int capacidades=ingreso.nextInt();
			String consulta = "insert into salas (id_salas,formato,capacidades)values(?,?,?)";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			ps.setObject(1,idsala);
			ps.setObject(2,formato);
			ps.setObject(3,capacidades);
			ps.executeUpdate();
			System.out.println("Sala agregada correctamente");
			ConsultaButaca GButacas = new ConsultaButaca();
			Butaca butaca=new Butaca('A',1,false,idsala) ;
			GButacas.inserta_butaca(butaca,capacidades);
			
			} catch (Exception e) {
			System.out.println("Sala NO agregada");
		}
	}
	public void ModifSala(){
		try { 
			Scanner ingreso = new Scanner(System.in);
			System.out.println("Ingrese Numero de sala a modificar");
			int idsala=ingreso.nextInt();
			System.out.println("Ingrese nuevo formato ");
			String formato=ingreso.next();
			System.out.println("Ingrese capacidades");	
			int capacidades=ingreso.nextInt();
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
		String consulta = "UPDATE salas set formato= '"+ formato +"' , capacidades = '" + capacidades +"'WHERE id_salas = '"+ idsala +"'";
	//System.out.println(consulta);
		stm.executeUpdate(consulta);
		
		System.out.println("Sala agregada correctamente");
		
		} catch (Exception e) {
			System.out.println("Sala NO actualizada");
		}
		
	}
	public void EliminSala() {
		Scanner ingr = new Scanner(System.in);
		System.out.println("Ingrese Numero de sala a eliminar");
		int idsala=ingr.nextInt();
		try {
		usarConexion = conn.conectar();
		stm=usarConexion.createStatement();
		String consulta = "DELETE FROM salas WHERE id_salas = '"+idsala+"'";
		stm.executeUpdate(consulta);
		System.out.println(consulta);
		System.out.println("sala eliminada Correctamente");
		} catch (Exception e) {
			System.out.println("sala NO eliminada");
			System.out.println(e.toString());
		}
	}
	public void buscarSala() {
		Scanner ingre = new Scanner(System.in);
		ConsultaSala sala = new ConsultaSala();
		sala.mostrar();
		System.out.println("Seleccione la sala ");
		int idsala=ingre.nextInt();
		try {
			usarConexion = conn.conectar();
			stm=usarConexion.createStatement();
			String consulta = "SELECT * FROM salas WHERE id_salas = '"+idsala+"'";
			rs= stm.executeQuery(consulta);
			while(rs.next()){
			int SalaEnc = rs.getInt(1);
			System.out.println(SalaEnc);
			}
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		
		

	
	
	public Sala mostrar() {
		
		try {
			usarConexion = conn.conectar(); // estamos usando la llave
			String consulta = "SELECT * FROM salas";// usamos este query...
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
			 System.out.println("|id_sala|   FORMATO   |CAPACIDAD|");
			while (rs.next()) { // leemos linea por linea
                Sala sala =new Sala();
                sala.setId_sala(rs.getInt(1));
                sala.setFormato(rs.getString(2));
                sala.setCapacidades(rs.getInt(3));
     System.out.printf("%5d,%10s,%10d\n",sala.getId_sala(),sala.getFormato(),sala.getCapacidades());
			}
		} catch (Exception e) {

		} 
		return null;
	}
}
