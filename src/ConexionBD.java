import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
		Connection con; //variable especial para la conexion
		private String DRIVER = "com.mysql.cj.jdbc.Driver";
		private String BD_URL= "jdbc:mysql://localhost:3306/bd_cine_final";
		private String USER = "root";
		private String PASS = "5528";
		Statement stmt;
		
		public Connection conectar() {
			try {
				Class.forName(DRIVER); //solamente vamos a decirle que utilice un driver(linea6)
				con = DriverManager.getConnection(BD_URL,USER,PASS); //ayuda a hacer el vinculo
			}catch(Exception error) { //exepciones son tipos de errores
				System.out.println("Problemas al intentar conectar a la bd" );
			}
			return con;
		}
	
		public ResultSet devuelveConsulta(String sql) throws SQLException  {
			System.out.println("creando consulta...");
			Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery(sql);
		    
		    return rs;
		}
	/*	public static void main() {
			System.out.println("hola");
		}*/
		
}