package logico;

public class Ram extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1562685468018217480L;
	private  float cantMemoria;
	private String tipoRam;
	public Ram( float precio, int cantidad, String serial, String marca, String modelo,
			float cantMemoria, String tipoRam) {
		super( precio, cantidad, serial, marca, modelo);
	
		this.cantMemoria = cantMemoria;
		this.tipoRam = tipoRam;
	}
	
	public float getCantMemoria() {
		return cantMemoria;
	}
	public void setCantMemoria(float cantMemoria) {
		this.cantMemoria = cantMemoria;
	}
	public String getTipoRam() {
		return tipoRam;
	}
	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}
	
	
	
	

	
}
