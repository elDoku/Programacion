package logico;

public class Ram extends Componente {

	private String marca;
	private  float cantmemoria;
	private String tipo;
	
	
	
	
	public Ram(String tipo, float precio, int cantidad, String serial, String marca, float cantmemoria, String tipo2) {
		super(tipo, precio, cantidad, serial);
		this.marca = marca;
		this.cantmemoria = cantmemoria;
		tipo = tipo2;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getCantmemoria() {
		return cantmemoria;
	}

	public void setCantmemoria(float cantmemoria) {
		this.cantmemoria = cantmemoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
