package logico;

public class Micro extends Componente {
	
	private String marca;
	private  String modelo;
	private  String tipoConexion;
	private  String MemoriaRam;
	private  String procesamiento;
	
	public Micro(String tipo, float precio, int cantidad, String serial, String marca, String modelo,
			String tipoConexion, String memoriaRam, String procesamiento) {
		super(tipo, precio, cantidad, serial);
		this.marca = marca;
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		MemoriaRam = memoriaRam;
		this.procesamiento = procesamiento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getMemoriaRam() {
		return MemoriaRam;
	}

	public void setMemoriaRam(String memoriaRam) {
		MemoriaRam = memoriaRam;
	}

	public String getProcesamiento() {
		return procesamiento;
	}

	public void setProcesamiento(String procesamiento) {
		this.procesamiento = procesamiento;
	}


}
