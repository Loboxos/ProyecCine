
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
	
		public login ingresar(String email1, String contra2,int tipoU)  {
			try {
				usarConexion=conn.conectar();
				String consulta = "select * from usuarios where email="+"'"+ email1+"'"+" and clave="+"'"+contra2+"'"+"and tipoUsuario="+"'"+tipoU+"'";
				
				stm=usarConexion.createStatement();
			    rs=stm.executeQuery(consulta);	
			  // System.out.println(rs.getBoolean(consulta));
			    if (rs.next()) { // leemos linea por linea
					System.out.println("ingreso exitoso!!");
					int id_usuario = rs.getInt(1);
					String email =rs.getString(2);
					String clave =rs.getString(3);
					int tipoUsuario=rs.getInt(6);
					}else {
						System.out.println("ingreso incorrecto chico");
					}
			  
			}catch(Exception e) {
			}
			return null;
			     
			
			
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