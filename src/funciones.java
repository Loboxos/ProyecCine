
public class funciones {
private int idfunciones;
private String id_pelicula;
private int id_sala;
private String Fsala;
private String fecha;

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
public String getId_pelicula() {
	return id_pelicula;
}
public void setId_pelicula(String string) {
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
public funciones(int idfunciones, String id_pelicula, int id_sala, String fecha) {
	super();
	this.idfunciones = idfunciones;
	this.id_pelicula = id_pelicula;
	this.id_sala = id_sala;
	this.fecha = fecha;
}
public funciones() {
	super();
}

}
