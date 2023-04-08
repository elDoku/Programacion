package logico;

import java.util.ArrayList;

import javax.swing.JList;

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

	public void insertarCombo(Combo combo) {
		misCombos.add(combo);
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

	// --------------------------------------------------------------------------

	public float gananciaDiscoDuro() {
		float total = 0;
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof DiscoDuro) {
					total += cp.getPrecio();

				}
			}
		}
		return total;

	}

	public float gananciaMotherBoard() {
		float total = 0;
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof MotherBoard) {
					total += cp.getPrecio();
				}
			}
		}
		return total;
	}

	public float gananciaMicro() {
		float total = 0;
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof Micro) {
					total += cp.getPrecio();
				}
			}
		}
		return total;
	}

	public float gananciaRam() {
		float total = 0;
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof Ram) {
					total += cp.getPrecio(); // se acumula el precio de cada queso cilíndrico hueco
				}
			}
		}
		return total;
	}

	public float gananciaCombo() {
		float total = 0;
		for (Factura fact : misFacturas) {
			for (Combo cb : fact.getMisCombos()) {
				total += cb.getPrecioCombo(); // se acumula el precio de cada queso cilíndrico hueco
			}
		}
		return total;
	}

	public float totalGanancia() {
		float total = 0;
		float gd = gananciaDiscoDuro();
		float gmb = gananciaMotherBoard();
		float gm = gananciaMicro();
		float gr = gananciaRam();
		total = gd + gmb + gm + gr;
		return total;
	}

	public int ventaDiscoDuro() {
		int cantidad = 0;
		ArrayList misCp = new ArrayList<>();
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof DiscoDuro) {
					misCp.add(cp);
					cantidad = misCp.size();

				}
			}
		}
		return cantidad;
	}

	public int ventaRam() {
		int cantidad = 0;
		ArrayList misCp = new ArrayList<>();
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof Ram) {
					misCp.add(cp);
					cantidad = misCp.size();

				}
			}
		}
		return cantidad;
	}

	public int ventaMotherBoard() {
		int cantidad = 0;
		ArrayList misCp = new ArrayList<>();
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof MotherBoard) {
					misCp.add(cp);
					cantidad = misCp.size();

				}
			}
		}
		return cantidad;
	}

	public int ventaMicro() {
		int cantidad = 0;
		ArrayList misCp = new ArrayList<>();
		for (Factura fact : misFacturas) {
			for (Componente cp : fact.getMisComponentes()) {
				if (cp instanceof Micro) {
					misCp.add(cp);
					cantidad = misCp.size();

				}
			}
		}
		return cantidad;
	}

	public int ventaCombo() {
		int cantidad = 0;
		ArrayList misCp = new ArrayList<>();
		for (Factura fact : misFacturas) {
			for (Combo cb : fact.getMisCombos()) {
				misCp.add(cb);
				cantidad = misCp.size();

			}

		}
		return cantidad;

	}

	// ------------------------------------------------------------------
	// public ArrayList<Componente> mayorEsferico() {
	// ArrayList<> queso = new ArrayList<>();
	//
	// float volumen = 0;
	// for (Factura factura : misfacturas) {
	// for (Queso aux : factura.getMisQuesos()) {
	// if (aux instanceof QuesoEsferico && aux.Volumen() > volumen) {
	// volumen = aux.Volumen();
	// queso.removeAll(queso);
	// queso.add(aux);
	// }
	// if (aux instanceof QuesoEsferico && aux.Volumen() == volumen) {
	// queso.add(aux);
	// }
	// }
	// }
	// return queso;
	// }

	// public int cantEsferico() {
	// int cant = 0;
	// for (Queso aux : misQuesos) {
	// if (aux instanceof QuesoEsferico) {
	// cant++;
	// }
	// }
	// return cant;
	// }

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

	
	public Combo buscarComboByCodigo(String codigo) {
		Combo aux = null;
		for (Combo componente : misCombos) {
			if (componente.getCodigo().equalsIgnoreCase(codigo)) {
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

				if (componente.getSerial().equalsIgnoreCase(cod)) {
					total += componente.getPrecio();
				}

			}
		}
		return total;
	}

	public float totalFacturaCombo(JList<String> lista) {

		int i = 0;

		float total = 0;

		for (i = 0; i >= 0 && i < lista.getModel().getSize(); i++) {
			String str = lista.getModel().getElementAt(i);
			String cod = str.substring(0, 4);

			for (Combo combo : misCombos) {

				if (combo.getCodigo().equalsIgnoreCase(cod)) {

					total += combo.PrecioCombo();
					System.out.println(total);
				}

			}
		}
		return total;
	}

	public int cantComponente(Componente aux) {

		int total = 0;

		for (Componente componente : misComponentes) {

			if (aux.marca.equalsIgnoreCase(componente.marca) && aux.modelo.equalsIgnoreCase(componente.modelo)) {

				total++;
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
