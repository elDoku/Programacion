package logico;



public class MotherBoard extends Componente {

	
	private  String micro;
	private  String DiscoDuro;
	private  String Ram;
	
		
	
	public MotherBoard(String tipo, float precio, int cantidad, String serial, String marca, String modelo,
			String micro, String discoDuro, String ram) {
		super(tipo, precio, cantidad, serial, marca, modelo);
		this.micro = micro;
		DiscoDuro = discoDuro;
		Ram = ram;
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
		return DiscoDuro;
	}
	public void setDiscoDuro(String discoDuro) {
		DiscoDuro = discoDuro;
	}
	public String getRam() {
		return Ram;
	}
	public void setRam(String ram) {
		Ram = ram;
	}


	
}
