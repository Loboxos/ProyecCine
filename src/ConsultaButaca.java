import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultaButaca {
	ConexionBD conn = new ConexionBD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	public void inserta_butaca(Butaca butaca,int capacidades){
			 try{
		 String consulta = "INSERT INTO butacas (fila,numero,reservada,sala) VALUES (?,?,?,?)";
			 usarConexion=conn.conectar();
			 ps = usarConexion.prepareStatement(consulta);
			// System.out.println(consulta);
			 
			 System.out.println("Valores INSERTADOS con exito :) !");
			
			 char c;
			 char d = 0;
				if(capacidades==30){
					d='C';
				}else if(capacidades==40){
					d='D';
				}else if(capacidades==50) {
					d='E';
				}else if(capacidades==60) {
					d='F';
				}
			 
				for(c = 'A';c<=d;++c ) {
					 for (int i=0;i<10;i++) {
						 String b=Character.toString(c);
							ps.setObject(1,b);
							ps.setObject(2, butaca.getNumero()+i);
							ps.setObject(3, butaca.isReservada());
							ps.setObject(4,butaca.getId_sala());
							ps.executeUpdate();
							}
				}
				
			 
			 }catch(Exception e){
				 System.out.print(e);
			 }
				
	}
	
}
