
public class CreaUser {
	private int id_usuario;
	private String email;
	private String clave;
	private String nombre;
	private String apellido;
	private int tipoUsuario;
	
	public CreaUser() {
		
	}

	public CreaUser(String email, String clave, String nombre, String apellido, int tipoUsuario) {
		super();
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoUsuario = tipoUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/*public void mostrar() {
		System.out.print(this.email + "+" + this.clave);
		
	}*/
	
	
}
