package logico;

public class Micro extends Componente {

	private String tipoConexion;
	private String procesamiento;

	public Micro(float precio, int cantidad, String serial, String marca, String modelo, String tipoConexion,
			String procesamiento) {
		super(precio, cantidad, serial, marca, modelo);
		this.tipoConexion = tipoConexion;

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

	public String getProcesamiento() {
		return procesamiento;
	}

	public void setProcesamiento(String procesamiento) {
		this.procesamiento = procesamiento;
	}

}
