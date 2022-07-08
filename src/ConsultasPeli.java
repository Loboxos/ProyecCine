import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ConsultasPeli{
	
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;

	/*public ArrayList<pelicula> lista() {
		ArrayList<pelicula> listaPelis= new ArrayList<>();
		try {
			usarConexion = conn.conectar();
			String consulta = "SELECT * FROM pelicula";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			while (rs.next()) {

				pelicula Peli = new pelicula();

				Peli.setId_pelicula(rs.getInt(1));
				Peli.setDuracion(rs.getInt(2));
				Peli.setDescripcion(rs.getString(3));
				Peli.setTitulo(rs.getString(4));
				Peli.setEstreno(rs.getBoolean(5));
				Peli.setIdioma(rs.getString(6));
				Peli.setPrecioXpers(rs.getFloat(7));

			}
		} catch (Exception e) {

		}
		return listaPelis;
	}*/
	public pelicula mostrar() {
	
	try {
		usarConexion = conn.conectar(); // estamos usando la llave
		String consulta = "SELECT * FROM pelicula";// usamos este query...
		stm = usarConexion.createStatement();
		rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
		
		while (rs.next()) { // leemos linea por linea
			pelicula Peli=new pelicula();
			Peli.setId_pelicula(rs.getInt(1));
			Peli.setDuracion(rs.getInt(2));
			Peli.setDescripcion(rs.getString(3));
		    Peli.setTitulo(rs.getString(4));
			Peli.setEstreno(rs.getBoolean(5));
			Peli.setIdioma(rs.getString(6));
			Peli.setPrecioXpers(rs.getFloat(7));
System.out.printf("%d,%d,%s,%s,%s,%s,$%.2f\n", Peli.getId_pelicula(),Peli.getDuracion(), Peli.getDescripcion(),Peli.getTitulo(), Peli.isEstreno(), Peli.getIdioma(), Peli.getPrecioXpers() );
		}
	} catch (Exception e) {

	}
	return null;

}
public void insertar(pelicula peli) {
	try {
		String consulta = "insert into pelicula (id_pelicula,duracion,Descripcion,titulo,Estreno,Idioma,PrecioXpers)values(?,?,?,?,?,?,?)";
		usarConexion = conn.conectar();
		ps = usarConexion.prepareStatement(consulta);
		ps.setObject(1, peli.getId_pelicula());
		ps.setObject(2, peli.getDuracion());
		ps.setObject(3, peli.getDescripcion());
		ps.setObject(4, peli.getTitulo());
		ps.setObject(5, peli.isEstreno());
		ps.setObject(6, peli.getIdioma());
		ps.setObject(7, peli.getPrecioXpers());
		
		ps.executeUpdate();
	} catch (Exception e) {
	}
}
}

