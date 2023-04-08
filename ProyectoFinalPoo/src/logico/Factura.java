package logico;

import java.util.ArrayList;


public class Factura {
	private ArrayList<Combo> misCombos; 
	private ArrayList<Componente> misComponentes;
	private Cliente cliente;
	private String codigo;
	
	public Factura(ArrayList<Combo> misCombos, ArrayList<Componente> misComponentes, Cliente cliente, String codigo) {
		super();
		this.misCombos = new ArrayList<>();
		this.misComponentes = new ArrayList<>();
		this.cliente = cliente;
		this.codigo = codigo;
	}
	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}
	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}
	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}
	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public float PrecioFactura(){
    	float precio = 0;
    	for (Componente componente : misComponentes) {
			precio += componente.getPrecio();
		}
    	
    	return precio;
    	
    }
}
