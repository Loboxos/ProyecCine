
public class pelicula {
	
private int id_pelicula;
private int duracion;
private String Descripcion;
private String titulo;
private boolean Estreno;
private String Idioma;
private float PrecioXpers;

public int getDuracion() {
	return duracion;
}
public void setDuracion(int duracion) {
	this.duracion = duracion;
}
public String getDescripcion() {
	return Descripcion;
}
public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public boolean isEstreno() {
	return Estreno;
}
public void setEstreno(boolean estreno) {
	Estreno = estreno;
}
public String getIdioma() {
	return Idioma;
}
public void setIdioma(String idioma) {
	Idioma = idioma;
}
public float getPrecioXpers() {
	return PrecioXpers;
}
public void setPrecioXpers(float precioXpers) {
	PrecioXpers = precioXpers;
}

public int getId_pelicula() {
	return id_pelicula;
}
public void setId_pelicula(int id_pelicula) {
	this.id_pelicula = id_pelicula;
}
public pelicula() {
	
}
public pelicula(int id_pelicula,int duracion, String Descripcion,String titulo,boolean Estreno, String Idioma,float PrecioXpers) {
	super();
	this.id_pelicula=id_pelicula;
	this.duracion = duracion;
	this.Descripcion = Descripcion;
	this.titulo = titulo;
	this.Estreno = Estreno;
	this.Idioma = Idioma;
	this.PrecioXpers = PrecioXpers;
}
public void ActPelicula(int id_pelicula,int duracion, String Descripcion,String titulo,boolean Estreno, String Idioma,float PrecioXpers) {
	
}
public void NuevaPelicla(int id_pelicula,int duracion, String Descripcion,String titulo,boolean Estreno, String Idioma,float PrecioXpers) {
	
}

}
