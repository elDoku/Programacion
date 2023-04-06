package logico;

public class Ram extends Componente {

	private String marca;
	private  float cantMemoria;
	private String tipo;
	
	
	
	
	

	public Ram(String tipo, float precio, int cantidad, String serial, String marca, String modelo, String marca2,
			float cantMemoria, String tipo2) {
		super(tipo, precio, cantidad, serial, marca, modelo);
		marca = marca2;
		this.cantMemoria = cantMemoria;
		tipo = tipo2;
	}
	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getCantmemoria() {
		return cantMemoria;
	}

	public void setCantmemoria(float cantmemoria) {
		this.cantMemoria = cantmemoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
