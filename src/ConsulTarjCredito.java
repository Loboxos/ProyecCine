
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

public class ConsulTarjCredito {
	  ConexionBD conn = new ConexionBD();
		Connection usarConexion = null;
		Statement stm = null;
		ResultSet rs = null;
		PreparedStatement ps;
		
		public void inserta_TarjetaCredito(String numero, double balance, double limite, String banco){
	   		 try{
	   			usarConexion=conn.conectar();
				stm = usarConexion.createStatement();
				//otra forma para el ingreso por messageFormat para String
	   		 String balance_STR = String.valueOf(balance).replace(",", ".");
	   		 String limite_STR = String.valueOf(limite).replace(",", ".");
	   		 String consulta =  MessageFormat.format("INSERT INTO tarjcredito (numero, balance, limite, banco) VALUES ({0}, {1},{2},{3});", numero, balance_STR, limite_STR, banco);
	   		 System.out.println(consulta);
	   		 stm.executeUpdate(consulta);
	   		 
	   		 System.out.println("Valores INSERTADOS con exito :) !");
	   		 
	   		 }catch(Exception e){
	   			 System.out.println(e);
	   		 }
		}
	   public int consultar(String numero) {
		   try {
				usarConexion=conn.conectar();
				stm = usarConexion.createStatement();
				String consulta="Select id_tarjCredito from tarjcredito where numero="+"'"+numero+"'";
				
				rs=stm.executeQuery(consulta);
				 while(rs.next()) { // leemos linea por linea
					  int IDTARJCREDITO =rs.getInt(1);
		            return IDTARJCREDITO;
		            }
		    
			}catch(Exception e) {
				System.out.println(e);
			}
			return 0;	 
	   			 
	   			 
	   			 
	   			 
	   	}
	   		 
		
}

