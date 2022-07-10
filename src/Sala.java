
public class Sala {
	private int id_sala;
	private int numero;
    private String formato;
    private int capacidades;
 

	public Sala(int id_sala, int numero, String formato, int capacidades) {
		super();
		this.id_sala = id_sala;
		this.numero = numero;
		this.formato = formato;
		this.capacidades = capacidades;
	}
	
	public Sala() {
	
	}

	public int getId_sala() {
		return id_sala;
	}
	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public int getCapacidades() {
		return capacidades;
	}
	public void setCapacidades(int capacidades) {
		this.capacidades = capacidades;
	}
    
    

}

