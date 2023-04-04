package logico;

import java.util.ArrayList;

import javax.swing.JList;

import logical.Cliente;
import logical.Queso;
import logical.QuesoCilindricoH;



public class Tienda {
	private ArrayList<Combo> misCombos;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	public static int codigo = 1;
	public static Tienda tienda = null;
	
	public Tienda() {
		super();
		this.misCombos = new ArrayList<>();
		this.misComponentes = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misClientes = new ArrayList<>();
	}
	
	public static Tienda getInstance() {
		if (tienda == null) {
			tienda = new Tienda();
		}
		return tienda;
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
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}
	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	
	
	public void insertarComponente(Componente componente) {
		misComponentes.add(componente);
		codigo++;
		// la cantidad de quesos podria verse como el codigo
	}

	public void insertarCliente(Cliente cliente) {
		misClientes.add(cliente);
	}

	public void insertarFactura(Factura factura) {
		misFacturas.add(factura);
		codigo++;

	}

	public void verificarDisponibles(ArrayList<Componente> losComponentes) {
		ArrayList<Componente> nuevos = new ArrayList<>();
		nuevos.addAll(misComponentes);
		for (Componente componente : nuevos) {
			if (losComponentes.contains(componente)) {
				misComponentes.remove(componente);
			}
		}

	}

//	public ArrayList<Componente> mayorEsferico() {
//		ArrayList<> queso = new ArrayList<>();
//
//		float volumen = 0;
//		for (Factura factura : misfacturas) {
//			for (Queso aux : factura.getMisQuesos()) {
//				if (aux instanceof QuesoEsferico && aux.Volumen() > volumen) {
//					volumen = aux.Volumen();
//					queso.removeAll(queso);
//					queso.add(aux);
//				}
//				if (aux instanceof QuesoEsferico && aux.Volumen() == volumen) {
//					queso.add(aux);
//				}
//			}
//		}
//		return queso;
//	}

//	public int cantEsferico() {
//		int cant = 0;
//		for (Queso aux : misQuesos) {
//			if (aux instanceof QuesoEsferico) {
//				cant++;
//			}
//		}
//		return cant;
//	}

	public Cliente buscarClienteByCedula(String cedula) {
		Cliente auxCliente = null;
		for (Cliente cliente : misClientes) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				auxCliente = cliente;
			}
		}
		return auxCliente;
	}

	public Componente buscarQuesoByCodigo(String codigo) {
		Componente aux = null;
		for (Componente componente : misComponentes) {
			if (componente.getSerial().equalsIgnoreCase(codigo)) {
				aux = componente;
			}
		}
		return aux;
	}
	public float totalFactura(JList<String> lista) {
		int i = 0;

		float total = 0;

		for (i = 0; i >= 0 && i < lista.getModel().getSize(); i++) {
			String str = lista.getModel().getElementAt(i);
			String cod = str.substring(0, 4);
			for (Componente componente : misComponentes) {
//				if (componente instanceof QuesoCilindricoH) {
//					cod = str.substring(0, 5);
//				}
				if (componente.getSerial().equalsIgnoreCase(cod)) {
					total += componente.getPrecio();
				}

			}

		}
		return total;
	}
	public void modificarQueso(Componente componente) {
		// TODO Auto-generated method stub

	}

	public void modificarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

	}
	
}
