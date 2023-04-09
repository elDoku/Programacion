package logico;

public class MotherBoard extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6398190048088735735L;
	private String micro;
	private String conexionDisco;
	private String tipoRam;
	private String tipoConexion;

	public MotherBoard(float precio, int cantidad, String serial, String marca, String modelo,
			String micro, String conexionDisco, String tipoRam, String tipoConexion) {
		super(precio, cantidad, serial, marca, modelo);
		this.micro = micro;
		this.conexionDisco = conexionDisco;
		this.tipoRam = tipoRam;
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

	public String getConexionDisco() {
		return conexionDisco;
	}

	public void setConexionDisco(String discoDuro) {
		this.conexionDisco = discoDuro;
	}

	public String getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(String ram) {
		this.tipoRam = ram;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

}
