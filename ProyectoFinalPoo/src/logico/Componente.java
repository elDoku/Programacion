package logico;

public abstract class Componente {
	protected String tipo;
	protected float precio;
	protected int cantidad;
	protected String serial;
	public Componente(String tipo, float precio, int cantidad, String serial) {
		super();
		this.tipo = tipo;
		this.precio = precio;
		this.cantidad = 0;
		this.serial = serial;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	

	
	
}
