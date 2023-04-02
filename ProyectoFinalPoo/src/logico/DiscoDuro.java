package logico;

public class DiscoDuro extends Componente {

	private String marca;
	private  String modelo;
	private float capacidad;
	private String tipoConexion;
	
	
	
	public DiscoDuro(String tipo, float precio, int cantidad, String serial, String marca, String modelo,
			float capacidad, String tipoConexion) {
		super(tipo, precio, cantidad, serial);
		this.marca = marca;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.tipoConexion = tipoConexion;
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
	public float getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

}
