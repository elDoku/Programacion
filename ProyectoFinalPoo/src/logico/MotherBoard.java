package logico;

public class MotherBoard extends Componente {

	private String micro;
	private String discoDuro;
	private String ram;
	private String tipoConexion;

	public MotherBoard( float precio, int cantidad, String serial, String marca, String modelo,
			String micro, String discoDuro, String ram, String tipoConexion) {
		super(precio, cantidad, serial, marca, modelo);
		this.micro = micro;
		this.discoDuro = discoDuro;
		this.ram = ram;
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

	public String getMicro() {
		return micro;
	}

	public void setMicro(String micro) {
		this.micro = micro;
	}

	public String getDiscoDuro() {
		return discoDuro;
	}

	public void setDiscoDuro(String discoDuro) {
		this.discoDuro = discoDuro;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

}
