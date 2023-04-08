package visual;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.Factura;
import logico.Micro;
import logico.MotherBoard;
import logico.Ram;
import logico.Tienda;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField txtCedula;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JList<String> list_1;
	private JScrollPane scrollPane_1;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JSpinner spnTotal;
	private JButton btnFacturar;

	private ArrayList<Cliente> misCliente;
	private ArrayList<Componente> misComponentes;
	DefaultListModel<String> modelo0 = new DefaultListModel<String>();
	DefaultListModel<String> modelo = new DefaultListModel<String>();
	DefaultListModel<String> modeloAux = new DefaultListModel<String>();
	// para crear un modelo para el texto del jlist

	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		setTitle("Factura");
		setBounds(100, 100, 522, 476);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 486, 122);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 11, 46, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(70, 8, 216, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente aux = null;
				Cliente auxFacturar = Tienda.getInstance().buscarClienteByCedula(txtCedula.getText());
				if (auxFacturar == null) {

					txtNombre.setEditable(true);
					txtTelefono.setEditable(true);
					txtDireccion.setEditable(true);
				} else {

					txtNombre.setEditable(false);
					txtTelefono.setEditable(false);
					txtDireccion.setEditable(false);
					txtNombre.setText(auxFacturar.getNombre());
					txtTelefono.setText(auxFacturar.getTelefono());
					txtDireccion.setText(auxFacturar.getDireccion());
				}

			}
		});
		btnBuscar.setBounds(298, 7, 89, 23);
		panel.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 52, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(70, 42, 216, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(298, 45, 61, 14);
		panel.add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(361, 42, 115, 23);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 82, 61, 14);
		panel.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(70, 79, 406, 23);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 139, 486, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(299, 34, 177, 174);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);

		JLabel lblQuesosDisponibles = new JLabel("Componentes / Combos:");
		lblQuesosDisponibles.setBounds(10, 11, 177, 14);
		panel_1.add(lblQuesosDisponibles);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		list_1 = new JList<String>();
		scrollPane_1.setViewportView(list_1);

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnDerecha.setEnabled(!list.isSelectionEmpty());
			}
		});
		list_1.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnIzquierda.setEnabled(!list_1.isSelectionEmpty());
			}
		});

		// Llena el carrito de disponibles
		ArrayList<Componente> componentes2 = Tienda.getInstance().getMisComponentes();
		ArrayList<Combo> misCombos= Tienda.getInstance().getMisCombos();
		// Aqui traigo mis quesos hacia un arreglo
		ArrayList<String> nombresComponentes = new ArrayList<String>();
		// Aqui creo un arreglo de strings para colocar los codigos y nombres de los
		// quesos
		for (Componente q : componentes2) {
			if (q instanceof Ram) {
				nombresComponentes.add(q.getSerial() + "-Ram");
				// es decir que a un string si se le puede agregar de otra clase
			}
			if (q instanceof Micro) {
				nombresComponentes.add(q.getSerial() + "-Micro (" + ")");
			}
			if (q instanceof MotherBoard) {
				nombresComponentes.add(q.getSerial() + "-MotherBoard");
			}
			if (q instanceof DiscoDuro) {
				nombresComponentes.add(q.getSerial() + "-DiscoDuro");
			}
			
		}
		
		for (Combo combo :  misCombos) {
			nombresComponentes.add(combo.getCodigo()+"-Combo");
		}
		
	
		// Aqui se presentan los quesos
		// Creo una lista modelo para presentar los los nombres de la lista anterior
		DefaultListModel<String> modeloComponentes = new DefaultListModel<String>();
		for (String nombre : nombresComponentes) {
			// se recorre el arreglo string de la variable nombre de la clase string
			modeloComponentes.addElement(nombre);
		}
		list.setModel(modeloComponentes);

		// ------------------------------------------------------------------------

		JLabel lblCarritoDeCompra = new JLabel("Carrito de Compra:");
		lblCarritoDeCompra.setBounds(299, 11, 177, 14);
		panel_1.add(lblCarritoDeCompra);

		// ------------------------------------------------------------------------
		//
		// ---------------------------------------------------------------------------------------

		btnDerecha = new JButton(">>");
		btnDerecha.setEnabled(false);
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				ArrayList<Componente> Componentes = Tienda.getInstance().getMisComponentes();
				ArrayList<Combo> Combos = Tienda.getInstance().getMisCombos();
				// array que recoge los quesos
				if (index >= 0 && index < (Componentes.size()+Combos.size())) {
					// verifica que lo que se busca esta dentro de la lista
					// seleccionado dentro de los quesos
					// boolean encontrado = false;
					modelo = modeloComponentes;
					// aqui igualo modelo al modelo de la lista 1

					if (index >= 0 && index < modelo.getSize()) {

						String codigo = (String) modelo.getElementAt(index);
						// index++;
						modelo0.addElement(codigo);
						// modelo0 es la lista 2
						modelo.removeElementAt(index);
					}
					list.setModel(modelo);
					list_1.setModel(modelo0);
					spnTotal.setValue(Tienda.getInstance().totalFactura(list_1)+Tienda.getInstance().totalFacturaCombo(list_1));
					if (list_1.getModel().getSize() > 0) {
						btnFacturar.setEnabled(true);
					}
					if (list_1.getModel().getSize() < 1) {
						btnFacturar.setEnabled(false);
					}
				}
			}
		});
		btnDerecha.setBounds(199, 62, 89, 25);
		panel_1.add(btnDerecha);

		// ---------------------------------------------------------------------------------------
		btnIzquierda = new JButton("<<");
		btnIzquierda.setEnabled(false);
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list_1.getSelectedIndex();
				ListModel<String> componentes = list_1.getModel();
				// quesos es un arreglo con los datos de la primera lista
				if (index >= 0 && index < componentes.getSize()) {
//					modelo0 = modelo;

					String codigo = (String) modelo0.getElementAt(index);
					// codigo es el elemento seleccionado de la 2dalista
					modelo.addElement(codigo);
					// modelo0 es la lista 2
					modelo0.removeElementAt(index);

				}
				list.setModel(modelo);
				list_1.setModel(modelo0);
				spnTotal.setValue(Tienda.getInstance().totalFactura(list_1)+Tienda.getInstance().totalFacturaCombo(list_1));
				if (list_1.getModel().getSize() > 0) {
					btnFacturar.setEnabled(true);
				}
				if (list_1.getModel().getSize() < 1) {
					btnFacturar.setEnabled(false);
				}
			}
			// modelo.removeAllElements();

		});
		btnIzquierda.setBounds(199, 154, 88, 23);
		panel_1.add(btnIzquierda);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(209, 110, 64, 22);
		panel_1.add(spinner);

		// ---------------------------------------------------------------------------------------
		//

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 369, 46, 14);
		contentPanel.add(lblTotal);

		spnTotal = new JSpinner();
		spnTotal.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnTotal.setEnabled(false);
		spnTotal.setBounds(349, 365, 110, 22);
		contentPanel.add(spnTotal);

//		
//		ArrayList<Queso> quesos3 = TiendaQueso.getInstance().getMisQuesos();
////		
//		for (Queso q : quesos3) {
//			if (q instanceof QuesoEsferico) {
//				modelo.addElement(q.getCodigo() + "-Esférico");
//				// es decir que a un string si se le puede agregar de otra clase
//			}
//			if (q instanceof QuesoCilindrico && !(q instanceof QuesoCilindricoH)) {
//				modelo.addElement(q.getCodigo() + "-Cilíndrico");
//			}
//			if (q instanceof QuesoCilindricoH) {
//				modelo.addElement(q.getCodigo() + "-CilíndricoH");
//			}
//
//		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFacturar = new JButton("Facturar");
				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente aux = null;
						Factura factura = null;
						String cedula = txtCedula.getText();
						String nombre = txtNombre.getText();
						String telefono = txtTelefono.getText();
						String direccion = txtDireccion.getText();
						ArrayList<String> nombresQ = new ArrayList<String>();
						ListModel<String> misComponentes = list_1.getModel();
						aux = new Cliente(nombre, direccion, telefono, cedula);
						factura = new Factura(null, losComponentes(),aux,"CF-00" + Tienda.getInstance().getMisFacturas().size());
//						String codigo,ArrayList<Queso> misQuesos, Cliente cliente
						Tienda.getInstance().insertarCliente(aux);
						Tienda.getInstance().insertarFactura(factura);
						Tienda.getInstance().verificarDisponibles(losComponentes());
						JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
						clean();

					}
				});
				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private ArrayList<Componente> losComponentes() {
		ArrayList<Componente> array = new ArrayList<>();
		int i = 0;
		for (i = 0; i >= 0 && i < list_1.getModel().getSize(); i++) {
			String str = list_1.getModel().getElementAt(i);
			String cod = str.substring(0, 4);
			for (Componente componente : Tienda.getInstance().getMisComponentes()) {
				
				if (componente.getSerial().equalsIgnoreCase(cod)) {
					array.add(componente);
				}
			}
		}
		return array;
	}

	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtNombre.setEditable(false);
		txtTelefono.setEditable(false);
		txtDireccion.setEditable(false);
		btnDerecha.setEnabled(false);
		btnIzquierda.setEnabled(false);

		DefaultListModel<String> limpio = new DefaultListModel<String>();
		spnTotal.setValue(new Float(0.0));
		modelo0 = limpio;
		list_1.setModel(limpio);

	}
}
