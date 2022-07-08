
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
    import java.sql.Statement;
	

	public class ConsultasUser{
		ConexionBD conn = new ConexionBD();
		Connection usarConexion = null;
		Statement stm = null;
		ResultSet rs = null;
		PreparedStatement ps;
	
		public CreaUser ingresar(String email1, String contra2,int tipoU)  {
			CreaUser cliente=null;
			try {
				usarConexion=conn.conectar();
				String consulta = "select * from usuarios where email="+"'"+ email1+"'"+" and clave="+"'"+contra2+"'"+"and tipoUsuario="+"'"+tipoU+"'";
				stm=usarConexion.createStatement();
			    rs=stm.executeQuery(consulta);	
			  // System.out.println(rs.getBoolean(consulta));
			    if (rs.next()) {//pregunta si la linea existe
					System.out.println("ingreso exitoso!!");
					CreaUser usuario1 =new CreaUser();
				
				usuario1.setId_usuario(rs.getInt(1));
				usuario1.setEmail(rs.getString(2));
				usuario1.setClave(rs.getString(3));
				usuario1.setNombre(rs.getString(4));
				usuario1.setApellido(rs.getString(5));
				usuario1.setTipoUsuario(rs.getInt(6));
				//Customer client = new Customer(rs.getString(2),rs.getString(3));
				cliente= usuario1;
					}else {
						System.out.println("ingreso incorrecto chico");
					}
			  
			}catch(Exception e) {
			}
			return cliente;
		}
      public int retornaId (String email1, String contra2,int tipoU) {
			
			try {
				usarConexion=conn.conectar();
				String consulta = "select * from usuarios where email="+"'"+ email1+"'"+" and clave="+"'"+contra2+"'"+"and tipoUsuario="+"'"+tipoU+"'";
				stm=usarConexion.createStatement();
			    rs=stm.executeQuery(consulta);	
			  // System.out.println(rs.getBoolean(consulta));
			    while(rs.next()) { // leemos linea por linea
					System.out.println("ingreso exitoso!!");
				   CreaUser user =new CreaUser();
				   user.setId_usuario(rs.getInt(1));
                   return user.getId_usuario();
                   }	    
			}catch(Exception e) {
			}
			return 0;
		}
		public void RegistrarUser(CreaUser usuario){
			
			try {
			System.out.println("entro aki");
			String consulta = "insert into usuarios (email,clave,nombre,apellido,tipoUsuario)values(?,?,?,?,?)";
			usarConexion=conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			ps.setObject(1, usuario.getEmail());
			ps.setObject(2, usuario.getClave());
			ps.setObject(3, usuario.getNombre());
			ps.setObject(4,usuario.getApellido());
			ps.setObject(5, usuario.getTipoUsuario());
			ps.executeUpdate();
			}catch(Exception e) {
				
			}
			
		}
		
	}