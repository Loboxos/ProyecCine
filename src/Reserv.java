
public class Reserv {
	private int id_reservas;
	private int idbutaca;
	private String fechaCompra;
	private int fk_idUser;
	private int fk_idFunc;
	private String hora;
	private int fk_iddesc;
	private int fk_idTarjCred;
	private float Precio;
	private int DniUser;
	private float preciofinal;
	
	public float getPreciofinal() {
		return preciofinal;
	}
	public void setPreciofinal(float preciofinal) {
		this.preciofinal = preciofinal;
	}
	public int getDniUser() {
		return DniUser;
	}
	public void setDniUser(int dniUser) {
		DniUser = dniUser;
	}
	public float getFk_iddesc() {
		return fk_iddesc;
	}
	public void setFk_iddesc(int fk_iddesc) {
		this.fk_iddesc = fk_iddesc;
	}
	public int getFk_idTarjCred() {
		return fk_idTarjCred;
	}
	public void setFk_idTarjCred(int fk_idTarjCred) {
		this.fk_idTarjCred = fk_idTarjCred;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getId_reservas() {
		return id_reservas;
	}
	public void setId_reservas(int id_reservas) {
		this.id_reservas = id_reservas;
	}
	public int getIdbutaca() {
		return idbutaca;
	}
	public void setIdbutaca(int idbutaca) {
		this.idbutaca = idbutaca;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public int getFk_idUser() {
		return fk_idUser;
	}
	public void setFk_idUser(int fk_idUser) {
		this.fk_idUser = fk_idUser;
	}
	public int getFk_idFunc() {
		return fk_idFunc;
	}
	public void setFk_idFunc(int fk_idFunc) {
		this.fk_idFunc = fk_idFunc;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		this.Precio = precio;
	}
	
	public Reserv(int fk_idFunc, String fecha ,float precio, int fk_idUser, String hora,
			 int idbutaca,float precioFinal,int fk_tarjcredito) {
		super();
		this.fk_idFunc = fk_idFunc;
		this.fechaCompra = fecha;
		this.Precio = precio;
		this.fk_idUser = fk_idUser;
		this.hora = hora;
		this.idbutaca=idbutaca;
		this.preciofinal=precioFinal;
		this.fk_idTarjCred=fk_tarjcredito;
		
	}
	public Reserv(int d) {
		super();
	 this.idbutaca=d; 
	}
	public Reserv() {
		
	}

	
}
