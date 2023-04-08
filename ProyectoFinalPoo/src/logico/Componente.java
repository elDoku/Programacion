package logico;

public abstract class Componente {

	protected float precio;
	protected int cantidad;
	protected String serial;
	protected String marca;
	protected String modelo;


	
	public Componente(float precio, int cantidad, String serial, String marca, String modelo) {
		super();
		
		this.precio = precio;
		this.cantidad = cantidad;
		this.serial = serial;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
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
	

	
	
}
