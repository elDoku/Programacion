package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JList;







public class Tienda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1850334921469337776L;
	private ArrayList<User> misUser;
	private static User LoginUser;
	
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
		this.misUser= new ArrayList<>();
		
		cargarComponentesDesdeArchivo();
		cargarCombosDesdeArchivo();
		cargarFacturasDesdeArchivo();
		cargarClientesDesdeArchivo();
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
	
	//////////////////////////////////////////////////
	
	public ArrayList<User> getMisUsers() {
		return misUser;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUser = misUsers;
	}
	
	public void regUser(User user) {
		misUser.add(user);
		
	}

	public static Tienda getTienda() {
		return tienda;
	}

	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
	}
	
	public static User getLoginUser() {
		return LoginUser;
	}

	public static void setLoginUser(User loginUser) {
			Tienda.LoginUser = loginUser;
	}
	
	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (User user : misUser) {
			if(user.getUserName().equals(text) && user.getPass().equals(text2)){
				LoginUser = user;
				login = true;
			}
		}
		return login;
	}


	///////////////////////////////////////////////
	
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
	
	public void verificarDisponiblesCombos(ArrayList<Combo> losCombos) {
		ArrayList<Combo> nuevos = new ArrayList<>();
		nuevos.addAll(misCombos);
		for (Combo combo : nuevos) {
			if (losCombos.contains(combo)) {
				misCombos.remove(combo);
			}
		}

	}
	
	//////////////////////////////////////////////////////////

	public void guardarComponentesEnArchivo() {
        try {
            File archivo = new File("Miscomponentes.dat");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(misComponentes.size());
            for (Componente componente : misComponentes) {
            	
            	oos.writeObject(componente);
			}
            
            
            oos.close();
            fos.close();
            System.out.println("Se ha guardado el ArrayList misComponentes en el archivo " + archivo.getPath());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al guardar el ArrayList misComponentes en el archivo: " + e.getMessage());
        }
    }
	
	
	public void cargarComponentesDesdeArchivo() {
	    try {
	        File archivo = new File("Miscomponentes.dat");
	        FileInputStream fis = new FileInputStream(archivo);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        int numComponentes = ois.readInt();
	        for (int i = 0; i < numComponentes; i++) {
	            Componente componente = (Componente) ois.readObject();
	            misComponentes.add(componente);
	        }
	        ois.close();
	        fis.close();
	        System.out.println("Se han cargado " + numComponentes + " componentes desde el archivo " + archivo.getPath());
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al cargar los componentes desde el archivo: " + e.getMessage());
	    }
	}
	
	
	public void guardarCombosEnArchivo() {
        try {
            File archivo = new File("Miscombos.dat");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(misCombos.size());
            for (Combo combo : misCombos) {
            	
            	oos.writeObject(combo);
			}
            
            oos.close();
            fos.close();
            System.out.println("Se ha guardado el ArrayList misCombos en el archivo " + archivo.getPath());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al guardar el ArrayList misCombos en el archivo: " + e.getMessage());
        }
    }
	
	public void cargarCombosDesdeArchivo() {
	    try {
	        File archivo = new File("Miscombos.dat");
	        FileInputStream fis = new FileInputStream(archivo);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        int numCombos = ois.readInt();
	        for (int i = 0; i < numCombos; i++) {
	            Combo combo = (Combo) ois.readObject();
	            misCombos.add(combo);
	        }
	        ois.close();
	        fis.close();
	        System.out.println("Se han cargado " + numCombos + " combos desde el archivo " + archivo.getPath());
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al cargar los combos desde el archivo: " + e.getMessage());
	    }
	}
	
	
	public void guardarFacturasEnArchivo() {
        try {
            File archivo = new File("MisFacturas.dat");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(misFacturas.size());
            for (Factura factura : misFacturas) {
            	
            	oos.writeObject(factura);
			}
            
            oos.close();
            fos.close();
            System.out.println("Se ha guardado el ArrayList misFacturas en el archivo " + archivo.getPath());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al guardar el ArrayList misFacturass en el archivo: " + e.getMessage());
        }
    }
	
	
	public void cargarFacturasDesdeArchivo() {
	    try {
	        File archivo = new File("MisFacturas.dat");
	        FileInputStream fis = new FileInputStream(archivo);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        int numFacturas = ois.readInt();
	        for (int i = 0; i < numFacturas; i++) {
	            Factura factura = (Factura) ois.readObject();
	            misFacturas.add(factura);
	        }
	        ois.close();
	        fis.close();
	        System.out.println("Se han cargado " + numFacturas + " las facturas desde el archivo " + archivo.getPath());
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al cargar las facturas desde el archivo: " + e.getMessage());
	    }
	}
	
	
	public void guardarClientesEnArchivo() {
        try {
            File archivo = new File("MisClientes.dat");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(misFacturas.size());
            for (Cliente cliente : misClientes) {
            	
            	oos.writeObject(cliente);
			}
            
            oos.close();
            fos.close();
            System.out.println("Se ha guardado el ArrayList misClientes en el archivo " + archivo.getPath());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al guardar el ArrayList misClientes en el archivo: " + e.getMessage());
        }
    }
	
	
	public void cargarClientesDesdeArchivo() {
	    try {
	        File archivo = new File("MisClientes.dat");
	        FileInputStream fis = new FileInputStream(archivo);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        int numClientes = ois.readInt();
	        for (int i = 0; i < numClientes; i++) {
	            Cliente cliente = (Cliente) ois.readObject();
	            misClientes.add(cliente);
	        }
	        ois.close();
	        fis.close();
	        System.out.println("Se han cargado " + numClientes + " los Clientes desde el archivo " + archivo.getPath());
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al cargar los clientes desde el archivo: " + e.getMessage());
	    }
	}
	
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


	public Cliente buscarClienteByCedula(String cedula) {
		Cliente auxCliente = null;
		for (Cliente cliente : misClientes) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				auxCliente = cliente;
			}
		}
		return auxCliente;
	}

	public Componente buscarComponenteByCodigo(String codigo) {
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
					total += componente.getPrecio() * componente.getCantidad();
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

	public ArrayList<User> getMisUser() {
		return misUser;
	}

	public void setMisUser(ArrayList<User> misUser) {
		this.misUser = misUser;
	}

	

}
