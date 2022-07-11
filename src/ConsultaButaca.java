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
		// String consulta2 =" ALTER TABLE butacas AUTO_INCREMENT = 1";
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
	public int comprobarDisp(int numeroBut) {
		try {
			usarConexion=conn.conectar();
			String consulta = "select reservada from butacas where id_Butaca="+"'"+ numeroBut +"'";
			stm=usarConexion.createStatement();
		    rs=stm.executeQuery(consulta);	
		    if(rs.next()) {
		    	int Disp=rs.getInt(1);
		    return Disp;
		    }
		}catch(Exception e) {
			
		}
		return 1;
	}
	public Butaca mostrar() {
		
		try {
			usarConexion = conn.conectar(); // estamos usando la llave
			String consulta = "SELECT * FROM butacas";// usamos este query...
			 System.out.printf("%s %s %s %s %n","|BUTACA NRO|","|FILA|","|numero|FALSE=DISPONIBLE TRUE=NO DISPONIBLE|","|SALA NRO|");
			stm = usarConexion.createStatement();
			
			rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
			
			while (rs.next()) { // leemos linea por linea
               		Butaca butaca= new Butaca();
               		butaca.setId_butacas(rs.getInt(1));
               		butaca.setFila(rs.getString(2).charAt(0));
               		butaca.setNumero(rs.getInt(3));
               		butaca.setReservada(rs.getBoolean(4));
               		butaca.setId_sala(rs.getInt(5));
               		

     System.out.printf("%d,%5s,%10d,%B,%5d\n",butaca.getId_butacas(),butaca.getFila(),butaca.getNumero(),butaca.isReservada(),butaca.getId_sala());
			}
		} catch (Exception e) {

		} 
		return null;
	}
	
	
	
	
	
	
	
}
