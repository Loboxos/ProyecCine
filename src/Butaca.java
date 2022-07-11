public class Butaca {

 private int id_butacas;
 private char fila;
 private int numero;
 private boolean reservada;
 private int id_sala;
 //private id_Sala;
 

public char getFila() {
	return fila;
}
public int getId_butacas() {
	return id_butacas;
}
public void setId_butacas(int id_butacas) {
	this.id_butacas = id_butacas;
}
public int getId_sala() {
	return id_sala;
}
public void setId_sala(int id_sala) {
	this.id_sala = id_sala;
}
public void setFila(char fila) {
	this.fila = fila;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public boolean isReservada() {
	return reservada;
}
public void setReservada(boolean reservada) {
	this.reservada = reservada;
}
public Butaca(char fila, int numero, boolean reservada) {
	super();
	this.fila = fila;
	this.numero = numero;
	this.reservada = reservada;
}
public Butaca() {
	
}
public Butaca(char fila ,int numero,boolean op, int idsala) {
	this.fila = fila;
	this.numero = numero;
	this.reservada = op;
	this.id_sala=idsala;
	
}
@Override
public String toString() {
	return "Butaca [id_butacas=" + id_butacas + ", fila=" + fila + ", numero=" + numero + ", reservada=" + reservada
			+ ", id_sala=" + id_sala + "]";
}


}
