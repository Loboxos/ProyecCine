
public class Reserv {
	private int id_reservas;
	private int idbutaca;
	private int id_sala;
	private String fechaCompra;
	private int fk_idUser;
	private int fk_idFunc;
	private float Precio;
	private String hora;
	
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
	public int getId_sala() {
		return id_sala;
	}
	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
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
	public void setPreci(float precio) {
		this.Precio = precio;
	}
	
	public Reserv(int idsala, String fecha ,float precio, int fk_idUser,int fk_idFunc, String hora,
			 int idbutaca) {
		super();
		this.id_sala = idsala;
		this.fechaCompra = fecha;
		this.Precio = precio;
		this.fk_idUser = fk_idUser;
		this.fk_idFunc = fk_idFunc;
		this.hora = hora;
		this.idbutaca=idbutaca;
	}
	public Reserv(int d) {
		super();
	 this.idbutaca=d; 
	}
	
}
