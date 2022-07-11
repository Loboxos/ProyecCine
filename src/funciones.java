
public class funciones {
private int idfunciones;
private int id_pelicula;
private int id_sala;
private String Fsala;
private String fecha;
private String hora;
private String titulo;
private int precio;

public int getPrecio() {
	return precio;
}

public void setPrecio(int precio) {
	this.precio = precio;
}

public String getHora() {
	return hora;
}

public void setHora(String hora) {
	this.hora = hora;
}

public String getFsala() {
	return Fsala;
}

public void setFsala(String fsala) {
	Fsala = fsala;
}

public int getIdfunciones() {
	return idfunciones;
}

public void setIdfunciones(int idfunciones) {
	this.idfunciones = idfunciones;
}
public int getId_pelicula() {
	return id_pelicula;
}
public void setId_pelicula(int string) {
	this.id_pelicula = string;
}
public int getId_sala() {
	return id_sala;
}
public void setId_sala(int id_sala) {
	this.id_sala = id_sala;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}

public funciones(int idfunciones, int id_pelicula, int id_sala, String fsala, String fecha, String hora, String titulo,
		int precio) {
	super();
	this.idfunciones = idfunciones;
	this.id_pelicula = id_pelicula;
	this.id_sala = id_sala;
	this.Fsala = fsala;
	this.fecha = fecha;
	this.hora = hora;
	this.titulo = titulo;
	this.precio = precio;
}

public funciones() {
	super();
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}



}
