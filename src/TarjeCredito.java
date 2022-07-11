public class TarjeCredito {
	private int id_tarjeCredito;
	private String Nro;
	private double balance;
	private double limite;
	private String NombrBanco;
	
	public TarjeCredito() {
		
	}
	
	public TarjeCredito(int id_tarjetaCredito, String numero, double balance, double limite, String banco) {
		super();
		this.id_tarjeCredito = id_tarjetaCredito;
		this.Nro = numero;
		this.balance = balance;
		this.limite = limite;
		this.NombrBanco = banco;
	}

	public int getId_tarjeCredito() {
		return id_tarjeCredito;
	}

	public void setId_tarjeCredito(int id_tarjeCredito) {
		this.id_tarjeCredito = id_tarjeCredito;
	}

	public String getNro() {
		return Nro;
	}

	public void setNro(String nro) {
		Nro = nro;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public String getNombrBanco() {
		return NombrBanco;
	}

	public void setNombrBanco(String nombrBanco) {
		NombrBanco = nombrBanco;
	}
	
}
