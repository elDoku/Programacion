package logico;

import java.util.ArrayList;

public class Combo {
	private String codigo;
	private String nombre;
	private ArrayList<Componente> misComponentes;
	private float precioCombo;

	public Combo(String codigo, String nombre, ArrayList<Componente> misComponentes, float precioCombo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.misComponentes = new ArrayList<>();
		this.precioCombo = precioCombo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public float getPrecioCombo() {
		return precioCombo;
	}

	public void setPrecioCombo(float precioCombo) {
		this.precioCombo = precioCombo;
	}
	
	
}
